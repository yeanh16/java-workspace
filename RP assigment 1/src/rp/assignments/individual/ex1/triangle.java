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
public class triangle implements StoppableRunnable{
	
	private DifferentialDriveRobot robot;
	private Float sideLength;

	public triangle(DifferentialDriveRobot _robot, Float _sideLength){
		this.robot= _robot;
		this.sideLength=_sideLength;
	}

	@Override
	public void run() {
		float _sideLength=sideLength;
		robot.getDifferentialPilot().travel(_sideLength);
		robot.getDifferentialPilot().rotate(120);
		robot.getDifferentialPilot().travel(_sideLength);
		robot.getDifferentialPilot().rotate(120);
		robot.getDifferentialPilot().travel(_sideLength);
		robot.getDifferentialPilot().rotate(120);
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}

}