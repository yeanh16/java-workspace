package rp.assignments.individual.ex1;

import lejos.util.Delay;
import rp.robotics.DifferentialDriveRobot;
import rp.robotics.TouchSensorEvent;
import rp.robotics.TouchSensorListener;
import rp.systems.ControllerWithTouchSensor;
import rp.systems.StoppableRunnable;
import rp.systems.WheeledRobotSystem;
import rp.util.Rate;

/**
 * 
 * Very empty example controller structure.
 * 
 * @author Nick Hawes
 *
 */
public class TouchSensor implements StoppableRunnable, TouchSensorListener, ControllerWithTouchSensor{
	
	private DifferentialDriveRobot robot;
	private boolean bumped =false;
	
	public TouchSensor(DifferentialDriveRobot _robot){
		this.robot= _robot;
	}

	

	@Override
	public void sensorPressed(TouchSensorEvent _e) {
		// TODO Auto-generated method stub
		this.bumped = true;
	}

	@Override
	public void sensorReleased(TouchSensorEvent _e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sensorBumped(TouchSensorEvent _e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		Rate r ;
		boolean m_run=true;
		while(m_run==true){
			robot.getDifferentialPilot().forward();
			r = new Rate(100);
			while(m_run==true && robot.getDifferentialPilot().isMoving()){
				if(bumped==true){
					robot.getDifferentialPilot().stop();
					robot.getDifferentialPilot().rotate(180);
					bumped=false;
					r.sleep();
				}
				r.sleep();
			}
		}
		
	}



	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

}
