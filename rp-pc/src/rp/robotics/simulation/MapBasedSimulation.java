package rp.robotics.simulation;

import java.util.ArrayList;
import java.util.Iterator;

import lejos.geom.Line;
import lejos.robotics.RangeFinder;
import lejos.robotics.RangeReadings;
import lejos.robotics.localization.PoseProvider;
import lejos.robotics.navigation.Pose;
import rp.config.RangeScannerDescription;
import rp.config.WheeledRobotConfiguration;
import rp.geom.GeometryUtils;
import rp.robotics.DifferentialDriveRobotPC;
import rp.robotics.LocalisedRangeScanner;
import rp.robotics.TouchSensorEvent;
import rp.robotics.TouchSensorListener;
import rp.robotics.mapping.RPLineMap;
import rp.robotics.visualisation.MapVisualisationComponent;
import rp.systems.StoppableRunnable;
import rp.util.Rate;

/**
 * This combines a simulated robot with a map to create a simple simulation of
 * the robot in a 2D world. This class provides collision detection between a
 * single robot and the map and also supports limited sensing of the world.
 * 
 * 
 * @author Nick Hawes
 *
 */
public class MapBasedSimulation implements StoppableRunnable,
		Iterable<DifferentialDriveRobotPC> {

	protected final RPLineMap m_map;
	protected final ArrayList<DifferentialDriveRobotPC> m_robots = new ArrayList<DifferentialDriveRobotPC>();
	private float m_simulationRateHz = 30;
	private boolean m_running = false;
	private Thread m_simThread;
	private ArrayList<FootprintTouchPair> m_touchSensors;

	private class FootprintTouchPair {
		final PoseProvider poser;
		final Line[] footprint;
		final TouchSensorListener listener;
		boolean triggered = false;

		public FootprintTouchPair(Line[] _footprint, PoseProvider _poser,
				TouchSensorListener _listener) {
			footprint = _footprint;
			listener = _listener;
			poser = _poser;
		}
	}

	private class RelativeRangeScanner implements LocalisedRangeScanner {
		final PoseProvider poser;
		final RangeScannerDescription scannerDesc;

		public RelativeRangeScanner(PoseProvider _poser,
				RangeScannerDescription _desc) {
			poser = _poser;
			scannerDesc = _desc;
		}

		@Override
		public RangeScannerDescription getDescription() {
			return scannerDesc;
		}

		/**
		 * Gets the absolute pose of the sensor.
		 */
		@Override
		public Pose getPose() {
			return GeometryUtils.transform(poser.getPose(),
					scannerDesc.getScannerPose());
		}

		@Override
		public void setPose(Pose _aPose) {
			throw new RuntimeException(
					"setPose is unimplemented for this ranger");
		}

		@Override
		public RangeReadings getRangeValues() {
			return m_map.takeReadings(poser.getPose(), scannerDesc);
		}

		@Override
		public void setAngles(float[] _angles) {
			throw new RuntimeException(
					"setAngles is unimplemented for this ranger");
		}

		@Override
		public RangeFinder getRangeFinder() {
			return null;
		}

		@Override
		public float getRange() {
			// TODO improve efficiency by only getting the first reading
			return getRangeValues().get(0).getRange();
		}

		@Override
		public float[] getRanges() {
			return new float[] { getRange() };
		}

	}

	public MapBasedSimulation(RPLineMap _map) {
		m_map = _map;
	}

	@Override
	public void run() {
		Rate r = new Rate(m_simulationRateHz);
		m_running = true;
		while (m_running) {

			if (m_touchSensors != null) {
				synchronized (m_touchSensors) {
					for (FootprintTouchPair sensor : m_touchSensors) {
						if (isInCollision(sensor.poser.getPose(),
								sensor.footprint)) {
							if (!sensor.triggered) {
								sensor.triggered = true;

								long start = System.currentTimeMillis();
								sensor.listener
										.sensorPressed(new TouchSensorEvent(
												100, 3));
								long responseTime = System.currentTimeMillis()
										- start;
								if (responseTime > 100) {
									// fail("TouchSensorListener must respond faster than 100ms");
									System.out
											.println("WARNING: TouchSensorListener must respond faster than 100ms. Response time was "
													+ responseTime + "ms");
								}
							}
						} else if (sensor.triggered) {
							sensor.triggered = false;
						}
					}
				}
			}

			synchronized (m_robots) {
				for (DifferentialDriveRobotPC robot : m_robots) {

					if (isInCollision(robot)) {
						robot.startCollision();
					}
				}
			}

			r.sleep();
		}
	}

	private boolean isInCollision(Pose _pose, Line[] _footprint) {
		Line[] m_footprint = new Line[_footprint.length];
		// transform robot footprint to it's pose location
		GeometryUtils.transform(_pose, _footprint, m_footprint);
		// check for footprint intersection with map
		return m_map.intersectsWith(m_footprint);

	}

	private boolean isInCollision(DifferentialDriveRobotPC _robot) {
		Line[] m_footprint = new Line[_robot.getFootprint().length];
		// transform robot footprint to it's pose location
		GeometryUtils.transform(_robot.getPose(), _robot.getFootprint(),
				m_footprint);
		// check for footprint intersection with map
		return m_map.intersectsWith(m_footprint);

	}

	@Override
	public void stop() {
		m_running = false;
	}

	/**
	 * Add a robot to the simulation with the given configuration at the given
	 * pose.
	 * 
	 * @param _config
	 */
	public DifferentialDriveRobotPC addRobot(WheeledRobotConfiguration _config,
			Pose _start) {

		DifferentialDriveRobotPC robot = new DifferentialDriveRobotPC(_config);
		robot.setPose(_start);
		synchronized (m_robots) {
			if (_config != null && !m_robots.contains(_config)) {
				m_robots.add(robot);
			}
		}

		// if the first robot was added, the start sim running
		if (m_robots.size() == 1) {
			m_simThread = new Thread(this);
			m_simThread.setPriority(9);
			m_simThread.start();
		}

		return robot;
	}

	public void addTouchSensorListener(DifferentialDriveRobotPC _robot,
			TouchSensorListener _listener, int _sensorIndex) {
		for (DifferentialDriveRobotPC robot : m_robots) {
			if (robot.equals(_robot)) {

				if (robot.getTouchSensors() == null) {
					throw new NullPointerException(
							"Robot has no touch sensors in description");
				}

				if (_sensorIndex >= robot.getTouchSensors().size()) {
					throw new IndexOutOfBoundsException(
							"Sensor index is out of bounds");
				} else {
					if (m_touchSensors == null) {
						m_touchSensors = new ArrayList<MapBasedSimulation.FootprintTouchPair>(
								1);
					}
					synchronized (m_touchSensors) {
						m_touchSensors.add(new FootprintTouchPair(robot
								.getTouchSensors().get(_sensorIndex), robot,
								_listener));
					}
					return;
				}

			}
		}
		throw new IllegalArgumentException("Robot is not part of simulation");
	}

	/*
	 * Add a touch sensor listener to the first touch sensor on the robot.
	 */
	public void addTouchSensorListener(DifferentialDriveRobotPC _robot,
			TouchSensorListener _listener) {
		addTouchSensorListener(_robot, _listener, 0);
	}

	public LocalisedRangeScanner getRanger(DifferentialDriveRobotPC _robot) {
		return getRanger(_robot, 0);
	}

	public LocalisedRangeScanner getRanger(DifferentialDriveRobotPC _robot,
			int _sensorIndex) {
		for (DifferentialDriveRobotPC robot : m_robots) {
			if (robot.equals(_robot)) {

				if (robot.getRangeScanners() == null) {
					throw new NullPointerException(
							"Robot has no range scanners in description");
				}
				if (_sensorIndex >= robot.getRangeScanners().size()) {
					throw new IndexOutOfBoundsException(
							"Sensor index is out of bounds");
				} else {
					if (m_touchSensors == null) {
						m_touchSensors = new ArrayList<MapBasedSimulation.FootprintTouchPair>(
								1);
					}

					return new RelativeRangeScanner(robot, robot
							.getRangeScanners().get(_sensorIndex));

				}

			}
		}
		throw new IllegalArgumentException("Robot is not part of simulation");
	}

	/**
	 * Creates a visualisation for the given simulation.
	 * 
	 * @param _sim
	 * @return
	 */
	public static MapVisualisationComponent createVisulation(
			MapBasedSimulation _sim) {
		MapVisualisationComponent visualisation = MapVisualisationComponent
				.createVisualisation(_sim.m_map);
		for (DifferentialDriveRobotPC robot : _sim.m_robots) {
			visualisation.addRobot(robot);
		}
		return visualisation;
	}

	public RPLineMap getMap() {
		return m_map;
	}

	@Override
	public Iterator<DifferentialDriveRobotPC> iterator() {
		return m_robots.iterator();
	}

}
