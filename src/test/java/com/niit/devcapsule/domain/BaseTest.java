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
public class BaseTest {

  /** The fixture. */
  Base fixture;

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
    fixture = new Base();
    assertNotNull(fixture);
  }

  /**
   * Test constructur id.
   */
  @Test
  public void testConstructurId() {
    fixture = new Base(1L);
    assertNotNull(fixture);
    assertEquals(fixture.getId().longValue(), 1L);
  }

  /**
   * Test constructur name.
   */
  @Test
  public void testConstructurName() {
    fixture = new Base("Pan");
    assertNotNull(fixture);
    assertEquals(fixture.getName(), "Pan");
  }

  /**
   * Test constructur all.
   */
  @Test
  public void testConstructurAll() {
    fixture = new Base(1L, "Pan");
    assertNotNull(fixture);
    assertEquals(fixture.getName(), "Pan");
    assertEquals(fixture.getId().longValue(), 1L);
  }

  /**
   * Test set name.
   */
  @Test
  public void testSetName() {
    fixture = new Base(1L);
    fixture.setName("Pan");
    assertEquals(fixture.getName(), "Pan");
  }

  /**
   * Launch the test.
   *
   * @param args
   *          the command line arguments
   *
   */
  public static void main(String[] args) {
    new org.junit.runner.JUnitCore().run(BaseTest.class);
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