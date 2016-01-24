package rp.assignments.individual.ex1;

import lejos.robotics.RangeFinder;
import rp.config.RangeFinderDescription;
import rp.robotics.DifferentialDriveRobot;
import rp.robotics.EventBasedTouchSensor;
import rp.systems.ControllerWithTouchSensor;
import rp.systems.StoppableRunnable;

public class SolutionFactory {

    public static StoppableRunnable createEquilateralTriangleController(DifferentialDriveRobot _robot, Float _sideLength) {
    	triangle tri = new triangle(_robot,_sideLength);
    	tri.run();
    	return tri;
    }
    
    public static StoppableRunnable createSquareController( DifferentialDriveRobot _robot, Float _sideLength){
		square sq = new square(_robot,_sideLength);
    	return sq;
    	
    }
    
    public static StoppableRunnable createDecagonController( DifferentialDriveRobot _robot, Float _sideLength){
		decagon dc = new decagon(_robot,_sideLength);
    	return dc;
    	
    }
    
    public static ControllerWithTouchSensor createBumperController(DifferentialDriveRobot _robot)
    {
    	TouchSensor ts = new TouchSensor(_robot);
		return ts;
    	
    }
    
    public static EventBasedTouchSensor createVirtualBumper(RangeFinderDescription _desc, RangeFinder _ranger, Float _touchRange) {
		part3 p3 = new part3(_desc, _ranger, _touchRange);
    	return p3;
    	
    }

    

}
