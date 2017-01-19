package com.niit.devcapsule.controller;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all of
 * the tests within its package as well as within any subpackages of its
 * package.
 *
 * @generatedBy CodePro at 12/16/15 11:56 PM
 * @author PSachdev
 * @version $Revision: 1.0 $
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ PizzaBaseControllerTest.class, ToppingControllerTest.class, PizzaControllerTest.class,
    PizzaOrderControllerTest.class })
public class TestAll {

  /**
   * Launch the test.
   *
   * @param args
   *          the command line arguments
   *
   * @generatedBy CodePro at 12/16/15 11:56 PM
   */
  public static void main(String[] args) {
    JUnitCore.runClasses(new Class[] { TestAll.class });
  }
}
