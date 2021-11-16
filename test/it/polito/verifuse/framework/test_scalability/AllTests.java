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
	Scalability_test_requirement.class, 
	Scalability_test_vnfs_t10.class, 
	Scalability_test_vnfs_t3.class,
	Scalability_test_vnfs_t5.class, 
	Scalability_test_vnfs_t8.class,
	Scalability_test_requirement_not_order.class,
	Scalability_test_progressive.class,
	Scalability_test_progressive_not_order.class})

public class AllTests{

}
