package com.niit.devcapsule.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

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
public class PizzaTest {

  /** The fixture. */
  Pizza fixture;

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
    fixture = new Pizza();
    assertNotNull(fixture);
  }

  /**
   * Test constructur id.
   */
  @Test
  public void testConstructor1() {
    fixture = new Pizza(1L, "Veggie", new BigDecimal(102), new Base(1L, "Pan"));
    assertNotNull(fixture);
    assertEquals(fixture.getName(), "Veggie");
    assertEquals(fixture.getId().longValue(), 1L);
    assertEquals(fixture.getBase().getId().longValue(), 1L);
  }

  /**
   * Test constructur id.
   */
  @Test
  public void testConstructor2() {
    Set<Topping> toppings = new HashSet<Topping>();
    toppings.add(new Topping(1L, "Onion"));
    toppings.add(new Topping(2L, "Tomato"));
    fixture = new Pizza(1L, "Veggie", new BigDecimal(102), new Base(1L, "Pan"), toppings);
    toppings = fixture.getToppings();
    assertNotNull(fixture);
    assertEquals(fixture.getName(), "Veggie");
    assertEquals(fixture.getId().longValue(), 1L);
    assertEquals(fixture.getBase().getId().longValue(), 1L);
    assertNotNull(toppings);
  }

  /**
   * Test constructur id.
   */
  @Test
  public void testSetBase() {
    fixture = new Pizza();
    fixture.setBase(new Base(1L, "Pan"));
    assertNotNull(fixture);
    assertEquals(fixture.getBase().getId().longValue(), 1L);
  }

  /**
   * Test constructur id.
   */
  @Test
  public void testSetPrice() {
    fixture = new Pizza();
    fixture.setPrice(new BigDecimal(102));
    assertNotNull(fixture);
    assertEquals(fixture.getPrice(), new BigDecimal(102));
  }

  /**
   * Launch the test.
   *
   * @param args
   *          the command line arguments
   *
   */
  public static void main(String[] args) {
    new org.junit.runner.JUnitCore().run(PizzaTest.class);
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