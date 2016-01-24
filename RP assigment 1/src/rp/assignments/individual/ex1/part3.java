package rp.assignments.individual.ex1;

import lejos.robotics.RangeFinder;
import lejos.robotics.Touch;
import rp.config.RangeFinderDescription;
import rp.robotics.DifferentialDriveRobot;
import rp.robotics.EventBasedTouchSensor;
import rp.robotics.TouchSensorEvent;
import rp.robotics.TouchSensorEventSource;
import rp.robotics.TouchSensorListener;
import rp.systems.StoppableRunnable;

public class part3 extends Thread implements StoppableRunnable,TouchSensorEventSource, Touch, TouchSensorListener, EventBasedTouchSensor{

	private DifferentialDriveRobot robot;
	private RangeFinderDescription desc;
	private RangeFinder ranger;
	private Float touchRange;
	
	public part3(RangeFinderDescription _desc, RangeFinder _ranger, Float _touchRange)
	{
		this.desc = _desc;
		this.ranger = _ranger;
		this.touchRange = _touchRange;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run(){
		robot.getDifferentialPilot().forward();
		while(robot.getDifferentialPilot().isMoving()){
			if (touchRange >= ranger.getRange()){
				sensorPressed(null);
				while(robot.getDifferentialPilot().isMoving()){
					if (touchRange <= ranger.getRange()){
						sensorReleased(null);
						sensorBumped(null);
					}
				}
			}
		}
	}
	
	
	@Override
	public boolean isPressed() {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public void addTouchSensorListener(TouchSensorListener _listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sensorPressed(TouchSensorEvent _e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sensorReleased(TouchSensorEvent _e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sensorBumped(TouchSensorEvent _e) {
		// TODO Auto-generated method stub
		
	}

}
