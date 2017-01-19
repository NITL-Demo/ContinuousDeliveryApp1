package com.niit.devcapsule.service;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all of
 * the tests within its package as well as within any subpackages of its
 * package.
 *
 * @generatedBy CodePro at 12/15/15 5:52 PM
 * @author PSachdev
 * @version $Revision: 1.0 $
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ PizzaBaseServiceImplTest.class, ToppingServiceImplTest.class, PizzaServiceImplTest.class })
public class TestAll {

  /**
   * Launch the test.
   *
   * @param args
   *          the command line arguments
   *
   * @generatedBy CodePro at 12/15/15 5:52 PM
   */
  public static void main(String[] args) {
    JUnitCore.runClasses(new Class[] { TestAll.class });
  }
}
