package it.polito.verifuse.framework.test_scalability;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import junit.extensions.ActiveTestSuite;
import junit.extensions.RepeatedTest;
import junit.framework.JUnit4TestAdapter;
import junit.framework.TestSuite;

public class MultipleTest {

	public static void main(String[] args) {
		int maxAttempts=5;
		try{
			TestSuite mySuite = new ActiveTestSuite();
			JUnitCore junit = new JUnitCore();
			junit.addListener(new TextListener(System.out));
			mySuite.addTest(new RepeatedTest(new JUnit4TestAdapter(Scalability_test_requirement.class), maxAttempts));
			mySuite.addTest(new RepeatedTest(new JUnit4TestAdapter(Scalability_test_requirement_not_order.class), maxAttempts));
			mySuite.addTest(new RepeatedTest(new JUnit4TestAdapter(Scalability_test_progressive.class), maxAttempts));
			mySuite.addTest(new RepeatedTest(new JUnit4TestAdapter(Scalability_test_progressive_not_order.class), maxAttempts));
			mySuite.addTest(new RepeatedTest(new JUnit4TestAdapter(Scalability_test_vnfs_t10.class), maxAttempts));
			mySuite.addTest(new RepeatedTest(new JUnit4TestAdapter(Scalability_test_vnfs_t3.class), maxAttempts));
			mySuite.addTest(new RepeatedTest(new JUnit4TestAdapter(Scalability_test_vnfs_t8.class), maxAttempts));
			mySuite.addTest(new RepeatedTest(new JUnit4TestAdapter(Scalability_test_vnfs_t5.class), maxAttempts));
			junit.run(mySuite);

		}catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

}
