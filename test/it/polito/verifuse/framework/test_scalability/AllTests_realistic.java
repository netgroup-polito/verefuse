package it.polito.verifuse.framework.test_scalability;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.extensions.RepeatedTest;
import junit.framework.TestCase;
import junit.framework.TestSuite;

@RunWith(Suite.class)
@SuiteClasses({ 
	Scalability_test_requirement_realistic_500vnfs.class,
	Scalability_test_requirement_realistic_1000vnfs.class,
	Scalability_test_requirement_not_order_realistic_500vnfs.class,
	Scalability_test_requirement_not_order_realistic_1000vnfs.class,
})

public class AllTests_realistic{

}
