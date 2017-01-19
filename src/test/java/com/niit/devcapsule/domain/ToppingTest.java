package com.niit.devcapsule.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The class <code>BaseTest</code> contains tests for the class
 * <code>{@link Base}</code>.
 *
 * @author PSachdev
 * @version $Revision: 1.0 $
 * @generatedBy CodePro at 12/17/15 1:42 PM
 */
public class ToppingTest {

  /** The fixture. */
  Topping fixture;

  /**
   * Sets the up.
   *
   * @throws Exception
   *           the exception
   */
  @Before
  public void setUp() throws Exception {

  }

  /**
   * Test constructur empty.
   */
  @Test
  public void testConstructurEmpty() {
    fixture = new Topping();
    assertNotNull(fixture);
  }

  /**
   * Test constructur id.
   */
  @Test
  public void testConstructurId() {
    fixture = new Topping(1L);
    assertNotNull(fixture);
    assertEquals(fixture.getId().longValue(), 1L);
  }

  /**
   * Test constructur name.
   */
  @Test
  public void testConstructurName() {
    fixture = new Topping("Onion");
    assertNotNull(fixture);
    assertEquals(fixture.getName(), "Onion");
  }

  /**
   * Test constructur all.
   */
  @Test
  public void testConstructurAll() {
    fixture = new Topping(1L, "Onion");
    assertNotNull(fixture);
    assertEquals(fixture.getName(), "Onion");
    assertEquals(fixture.getId().longValue(), 1L);
  }

  /**
   * Test set name.
   */
  @Test
  public void testSetName() {
    fixture = new Topping(1L);
    fixture.setName("Onion");
    assertEquals(fixture.getName(), "Onion");
  }

  /**
   * Launch the test.
   *
   * @param args
   *          the command line arguments
   *
   */
  public static void main(String[] args) {
    new org.junit.runner.JUnitCore().run(ToppingTest.class);
  }

  /**
   * Perform post-test clean-up.
   *
   * @throws Exception
   *           if the clean-up fails for some reason
   *
   */
  @After
  public void tearDown() throws Exception {

  }

}