package rp.assignments.individual.ex1;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

import rp.robotics.DifferentialDriveRobotPC;
import rp.robotics.testing.TestViewer;
import rp.robotics.testing.ZoneSequenceTestWithSim;

public class test {

	public static void main(String[] args) throws Exception  {
		 
	        Ex1Tests tests = new Ex1Tests();
	        ZoneSequenceTestWithSim<DifferentialDriveRobotPC, ?> test = tests.createBumperTest();
	        TestViewer demo = new TestViewer(test, test.getSimulation());
	        demo.run();
	        
	        org.junit.runner.Result result = JUnitCore.runClasses(rp.assignments.individual.ex1.Ex1Tests.class);

	        System.out.println(String.format("%d/%d tests successful",
	                result.getRunCount() - result.getFailureCount(),
	                result.getRunCount()));
	        for (Failure failure : result.getFailures()) {
	            System.out.println(failure.toString());
	        }
	        
	}

}
