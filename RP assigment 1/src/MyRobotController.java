

import rp.robotics.DifferentialDriveRobot;
import rp.systems.StoppableRunnable;

/**
 * 
 * Very empty example controller structure.
 * 
 * @author Nick Hawes
 *
 */
public class MyRobotController implements StoppableRunnable {

	
	private DifferentialDriveRobot robot;

	public MyRobotController(DifferentialDriveRobot _robot) {
	this.robot = _robot;
	}

	@Override
	public void run() {
		robot.getDifferentialPilot().travel(1.0);
		robot.getDifferentialPilot().rotate(120);
		robot.getDifferentialPilot().travel(1.0);
		robot.getDifferentialPilot().rotate(120);
		robot.getDifferentialPilot().travel(1.0);
		robot.getDifferentialPilot().rotate(120);	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}

}
