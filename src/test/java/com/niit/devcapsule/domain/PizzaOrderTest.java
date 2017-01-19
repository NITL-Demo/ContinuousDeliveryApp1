package com.niit.devcapsule.domain;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/**
 * The class <code>BaseTest</code> contains tests for the class
 * <code>{@link Base}</code>.
 *
 * @author PSachdev
 * @version $Revision: 1.0 $
 */
public class PizzaOrderTest {
  PizzaOrder fixture;

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
    fixture = new PizzaOrder();
    assertNotNull(fixture);
  }

  /**
   * Test constructur id.
   */
  @Test
  public void testConstructure() {
    Set<Pizza> pizzas = new HashSet<Pizza>();
    Pizza e = new Pizza();
    e.setId(1L);
    pizzas.add(e);
    fixture = new PizzaOrder(1L, pizzas, new BigDecimal(1020));
    assertNotNull(fixture);
  }

}