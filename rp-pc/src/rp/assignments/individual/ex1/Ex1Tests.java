package rp.assignments.individual.ex1;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import lejos.geom.Point;
import lejos.robotics.RangeFinder;
import lejos.robotics.navigation.Pose;

import org.junit.Test;

import rp.assignments.AbstractTestHarness;
import rp.config.RangeFinderDescription;
import rp.robotics.DifferentialDriveRobotPC;
import rp.robotics.EventBasedTouchSensor;
import rp.robotics.LocalisedRangeScanner;
import rp.robotics.TouchSensorEventSource;
import rp.robotics.TouchSensorListener;
import rp.robotics.testing.TargetZone;
import rp.robotics.testing.TestMaps;
import rp.robotics.testing.ZoneSequence;
import rp.robotics.testing.ZoneSequenceTestWithSim;

/**
 * 
 * Test instances for Individual Exercise 1
 * 
 * @author Nick Hawes
 *
 */

public class Ex1Tests extends AbstractTestHarness {

	private static final String TEST_CLASS = "rp.assignments.individual.ex1.SolutionFactory";

	public Ex1Tests() throws ClassNotFoundException {
		super(TEST_CLASS);
	}

	/**
	 * Example test for Individual Exercise 1a: a triangle with side length of
	 * 1.0m
	 * 
	 * @return
	 */
	public static ZoneSequence getTriangleTestSequence() {

		Pose start = new Pose(3f, 3f, 0f);

		ArrayList<TargetZone> zones = new ArrayList<TargetZone>();
		zones.add(new TargetZone(new Point(4.0f, 3.0f), 0.1f));
		zones.add(new TargetZone(new Point(3.5f, 3.87f), 0.1f));
		zones.add(new TargetZone(new Point(3.0f, 3.0f), 0.1f));

		return new ZoneSequence(start, zones);
	}

	/**
	 * Example test for Individual Exercise 1b: a square with side length of
	 * 1.0m
	 * 
	 * @return
	 */
	public static ZoneSequence getSquareTestSequence() {

		Pose start = new Pose(3.0f, 3.0f, 0.0f);
		ArrayList<TargetZone> zones = new ArrayList<TargetZone>(4);
		zones.add(new TargetZone(new Point(4.0f, 3.0f), 0.1f));
		zones.add(new TargetZone(new Point(4.0f, 4.0f), 0.1f));
		zones.add(new TargetZone(new Point(3.0f, 4.0f), 0.1f));
		zones.add(new TargetZone(new Point(3.0f, 3.0f), 0.1f));
		return new ZoneSequence(start, zones);
	}

	/**
	 * Example test for Individual Exercise 1c: a decagon with side length of
	 * 0.2m
	 * 
	 * @return
	 */
	public static ZoneSequence getDecagonSequence() {
		Pose start = new Pose(3.0f, 3.0f, 0.0f);
		ArrayList<TargetZone> zones = new ArrayList<TargetZone>(10);
		zones.add(new TargetZone(new Point(3.2f, 3.0f), 0.1f));
		zones.add(new TargetZone(new Point(3.3618035f, 3.117557f), 0.1f));
		zones.add(new TargetZone(new Point(3.4236069f, 3.3077683f), 0.1f));
		zones.add(new TargetZone(new Point(3.3618035f, 3.4979796f), 0.1f));
		zones.add(new TargetZone(new Point(3.2f, 3.6155367f), 0.1f));
		zones.add(new TargetZone(new Point(3.0f, 3.6155367f), 0.1f));
		zones.add(new TargetZone(new Point(2.8381965f, 3.4979796f), 0.1f));
		zones.add(new TargetZone(new Point(2.7763932f, 3.3077683f), 0.1f));
		zones.add(new TargetZone(new Point(2.8381965f, 3.117557f), 0.1f));
		zones.add(new TargetZone(new Point(3.0f, 3.0f), 0.1f));
		return new ZoneSequence(start, zones);
	}

	public static ZoneSequence getBumperSequence() {
		Pose start = new Pose(0.2f, 0.5f, 0.0f);
		ArrayList<TargetZone> zones = new ArrayList<TargetZone>(4);
		zones.add(new TargetZone(new Point(1.8000001f, 0.5f), 0.2f));
		zones.add(new TargetZone(new Point(0.20000005f, 0.5f), 0.2f));
		zones.add(new TargetZone(new Point(1.8000001f, 0.5f), 0.2f));
		zones.add(new TargetZone(new Point(0.20000005f, 0.5f), 0.2f));

		return new ZoneSequence(start, zones);

	}

	public ZoneSequenceTestWithSim<DifferentialDriveRobotPC, ?> createTriangeTest() {
		return createSequenceTest(TestMaps.EMPTY_8_x_6,
				getTriangleTestSequence(), 30000,
				"createEquilateralTriangleController", 1.0f);
	}

	public ZoneSequenceTestWithSim<DifferentialDriveRobotPC, ?> createSquareTest() {
		return createSequenceTest(TestMaps.EMPTY_8_x_6,
				getSquareTestSequence(), 40000, "createSquareController", 1.0f);
	}

	public ZoneSequenceTestWithSim<DifferentialDriveRobotPC, ?> createDecagonTest() {
		return createSequenceTest(TestMaps.EMPTY_8_x_6, getDecagonSequence(),
				50000, "createDecagonController", 0.2f);
	}

	public ZoneSequenceTestWithSim<DifferentialDriveRobotPC, ?> createBumperTest() {

		// test with bumper controller, this doesn't include the touch sensor.
		ZoneSequenceTestWithSim<DifferentialDriveRobotPC, ?> test = createSequenceTest(
				TestMaps.EMPTY_2_x_1, getBumperSequence(), 50000,
				"createBumperController");

		// this adds the touch sensor for the simulator if the controller
		// accepts it
		DifferentialDriveRobotPC robot = test.getSimulation().iterator().next();
		Object controller = test.getController();

		if (controller instanceof TouchSensorEventSource) {
			test.getSimulation().addTouchSensorListener(robot,
					(TouchSensorListener) controller);
		} else {
			fail("Controller does not implement TouchSensorListener");
		}

		return test;
	}

	public ZoneSequenceTestWithSim<DifferentialDriveRobotPC, ?> createVirtualBumperTest() {

		// test with bumper controller
		ZoneSequenceTestWithSim<DifferentialDriveRobotPC, ?> test = createSequenceTest(
				TestMaps.EMPTY_2_x_1, getBumperSequence(), 50000,
				"createBumperController");

		DifferentialDriveRobotPC robot = test.getSimulation().iterator().next();
		LocalisedRangeScanner ranger = test.getSimulation().getRanger(robot);

		EventBasedTouchSensor sensor = getTouchSensor("createVirtualBumper",
				ranger.getDescription(), ranger, 0.2f);

		Object controller = test.getController();

		if (controller instanceof TouchSensorListener) {
			sensor.addTouchSensorListener((TouchSensorListener) controller);
		} else {
			fail("Controller does not implement TouchSensorListener");
		}

		return test;
	}

	@Test
	public void triangleTest() {
		System.out.println("Running triangle test");
		runSequenceTest(createTriangeTest());
	}

	@Test
	public void squareTest() {
		System.out.println("Running square test");
		runSequenceTest(createSquareTest());
	}

	@Test
	public void decagonTest() {
		System.out.println("Running decagon test");
		runSequenceTest(createDecagonTest());
	}

	@Test
	public void bumperTest() {
		System.out.println("Running bumper test");
		runSequenceTest(createBumperTest(), true);
	}

	@Test
	public void virtualBumnerTest() {
		System.out.println("Running virtual bumper tests");
		runSequenceTest(createVirtualBumperTest(), true);
	}
}
