
import rp.robotics.DifferentialDriveRobot;
import rp.systems.StoppableRunnable;

/**
 * 
 * Very empty example controller structure.
 * 
 * @author Nick Hawes
 *
 */
public class triangle implements StoppableRunnable{
	
	private DifferentialDriveRobot robot;

	public static StoppableRunnable createEquilateralTriangleController( DifferentialDriveRobot _robot, Float _sideLength) {
		return null;
	}

	@Override
	public void run() {
		robot.getDifferentialPilot().travel(1.0);
		robot.getDifferentialPilot().rotate(60);
		robot.getDifferentialPilot().travel(1.0);
		robot.getDifferentialPilot().rotate(60);
		robot.getDifferentialPilot().travel(1.0);
		robot.getDifferentialPilot().rotate(60);
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}

}