package com.niit.devcapsule.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.easymock.Capture;
import org.easymock.EasyMock;
import org.easymock.IAnswer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.niit.devcapsule.dao.PizzaDAO;
import com.niit.devcapsule.domain.Base;
import com.niit.devcapsule.domain.Pizza;
import com.niit.devcapsule.domain.Topping;

/**
 * The class <code>PizzaBaseServiceImplTest</code> contains tests for the class
 * <code>{@link PizzaBaseServiceImpl}</code>.
 *
 * @author PSachdev
 * @version $Revision: 1.0 $
 */
public class PizzaServiceImplTest {

  /** The pizza dao. */
  PizzaDAO pizzaDAO;

  /** The fixture. */
  PizzaServiceImpl fixture;

  /** The toppings. */
  Set<Topping> toppings = new HashSet<Topping>();

  /**
   * Sets the up.
   *
   * @throws Exception
   *           the exception
   */
  @Before
  public void setUp() throws Exception {
    fixture = new PizzaServiceImpl();
    pizzaDAO = EasyMock.createNiceMock(PizzaDAO.class);
    fixture.pizzaDao = pizzaDAO;

    // findAll
    List<Pizza> pizzas = new ArrayList<Pizza>();
    toppings.add(new Topping(1L, "Onion"));
    toppings.add(new Topping(2L, "Tomato"));
    Pizza newPizza = new Pizza(1L, "Veggie", new BigDecimal(102.00), new Base(1L, "Pan"), toppings);
    pizzas.add(newPizza);
    EasyMock.expect(fixture.findAll()).andReturn(pizzas);

    // save
    final Capture<Pizza> pizzaCapturedSave = new Capture<Pizza>();
    EasyMock.expect(pizzaDAO.save(EasyMock.capture(pizzaCapturedSave))).andAnswer(new IAnswer<Pizza>() {
      public Pizza answer() throws Throwable {
        return pizzaCapturedSave.getValue();
      }
    }).anyTimes();

    EasyMock.expect(pizzaDAO.findById(1L)).andReturn(newPizza).anyTimes();

    EasyMock.expect(pizzaDAO.findById(2L)).andReturn(null).anyTimes();

    EasyMock.replay(pizzaDAO);
  }

  /**
   * Test find all.
   *
   * @throws Exception
   *           the exception
   */
  @Test
  public void testFindAll() throws Exception {
    List<Pizza> result = fixture.findAll();
    assertNotNull(result);
    assertEquals(result.size(), 1);
  }

  /**
   * Test save.
   *
   * @throws Exception
   *           the exception
   */
  @Test
  public void testSave() throws Exception {
    Pizza pizza = new Pizza(1L, "Veggie", new BigDecimal(102.00), new Base(1L, "Pan"));
    pizza = fixture.updatePizza(pizza);
    assertNotNull(pizza);
    assertEquals(pizza.getName(), "Veggie");
  }

  /**
   * Test add.
   *
   * @throws Exception
   *           the exception
   */
  @Test
  public void testAddWithToppings() throws Exception {
    Pizza pizza = new Pizza(1L, "Veggie", new BigDecimal(102.00), new Base(1L, "Pan"), toppings);
    pizza = fixture.addPizza(pizza);
    assertNotNull(pizza);
    assertEquals(pizza.getName(), "Veggie");
  }

  /**
   * Test add.
   *
   * @throws Exception
   *           the exception
   */
  @Test
  public void testAddWithoutToppings() throws Exception {
    Pizza pizza = new Pizza(1L, "Veggie", new BigDecimal(102.00), new Base(1L, "Pan"));
    pizza = fixture.addPizza(pizza);
    assertNotNull(pizza);
    assertEquals(pizza.getName(), "Veggie");
  }

  /**
   * Test findById.
   *
   * @throws Exception
   *           the exception
   */
  @Test
  public void testFindById() throws Exception {
    Pizza pizza = fixture.findById(1L);
    assertNotNull(pizza);
    assertEquals(pizza.getName(), "Veggie");
  }

  /**
   * Test findByIdNotFound.
   *
   * @throws Exception
   *           the exception
   */
  @Test
  public void testFindByIdNotFound() throws Exception {
    Pizza pizza = fixture.findById(2L);
    assertEquals(pizza, null);
  }

  /**
   * Tear down.
   *
   * @throws Exception
   *           the exception
   */
  @After
  public void tearDown() throws Exception {
    // Add additional tear down code here
  }

  /**
   * The main method.
   *
   * @param args
   *          the arguments
   */
  public static void main(String[] args) {
    new org.junit.runner.JUnitCore().run(ToppingServiceImplTest.class);
  }
}