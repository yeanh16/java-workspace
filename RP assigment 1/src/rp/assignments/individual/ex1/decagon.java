package rp.assignments.individual.ex1;

import rp.robotics.DifferentialDriveRobot;
import rp.systems.StoppableRunnable;

/**
 * 
 * Very empty example controller structure.
 * 
 * @author Nick Hawes
 *
 */
public class decagon implements StoppableRunnable{
	
	private DifferentialDriveRobot robot;
	private Float sideLength;

	public decagon(DifferentialDriveRobot _robot, Float _sideLength){
		this.robot= _robot;
		this.sideLength=_sideLength;
	}

	@Override
	public void run() {
		float _sideLength=sideLength;
		robot.getDifferentialPilot().travel(_sideLength);
		robot.getDifferentialPilot().rotate(36);
		robot.getDifferentialPilot().travel(_sideLength);
		robot.getDifferentialPilot().rotate(36);
		robot.getDifferentialPilot().travel(_sideLength);
		robot.getDifferentialPilot().rotate(36);
		robot.getDifferentialPilot().travel(_sideLength);
		robot.getDifferentialPilot().rotate(36);
		robot.getDifferentialPilot().travel(_sideLength);
		robot.getDifferentialPilot().rotate(36);
		robot.getDifferentialPilot().travel(_sideLength);
		robot.getDifferentialPilot().rotate(36);
		robot.getDifferentialPilot().travel(_sideLength);
		robot.getDifferentialPilot().rotate(36);
		robot.getDifferentialPilot().travel(_sideLength);
		robot.getDifferentialPilot().rotate(36);
		robot.getDifferentialPilot().travel(_sideLength);
		robot.getDifferentialPilot().rotate(36);
		robot.getDifferentialPilot().travel(_sideLength);
		robot.getDifferentialPilot().rotate(36);

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}

}