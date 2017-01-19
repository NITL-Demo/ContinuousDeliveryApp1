package com.niit.devcapsule.controller;

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
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import com.niit.devcapsule.domain.Base;
import com.niit.devcapsule.domain.Pizza;
import com.niit.devcapsule.domain.Topping;
import com.niit.devcapsule.service.PizzaService;

/**
 * The class <code>PizzaControllerTest</code> contains tests for the class
 * <code>{@link PizzaController}</code>.
 *
 * @author PSachdev
 * @version $Revision: 1.0 $
 */
public class PizzaControllerTest {
  PizzaService pizzaServlce;
  PizzaController fixture;

  /** The toppings. */
  Set<Topping> toppings = new HashSet<Topping>();

  /**
   * Perform pre-test initialization.
   *
   * @throws Exception
   *           if the initialization fails for some reason
   *
   */
  @Before
  public void setUp() throws Exception {
    fixture = new PizzaController();
    pizzaServlce = EasyMock.createNiceMock(PizzaService.class);
    fixture.pizzaService = pizzaServlce;

    // getPizzas
    List<Pizza> pizzas = new ArrayList<Pizza>();
    toppings.add(new Topping(1L, "Onion"));
    toppings.add(new Topping(2L, "Tomato"));
    pizzas.add(new Pizza(1L, "Veggie", new BigDecimal(102.00), new Base(1L, "Pan"), toppings));
    EasyMock.expect(pizzaServlce.findAll()).andReturn(pizzas);

    // addPizza
    final Capture<Pizza> pizzaCapturedAdd = new Capture<Pizza>();
    EasyMock.expect(pizzaServlce.addPizza(EasyMock.capture(pizzaCapturedAdd))).andAnswer(new IAnswer<Pizza>() {
      public Pizza answer() throws Throwable {
        pizzaCapturedAdd.getValue().setId(1L);
        return pizzaCapturedAdd.getValue();
      }
    });

    // updatePizza
    final Capture<Pizza> pizzaCapturedUpdate = new Capture<Pizza>();
    EasyMock.expect(pizzaServlce.updatePizza(EasyMock.capture(pizzaCapturedUpdate))).andAnswer(new IAnswer<Pizza>() {
      public Pizza answer() throws Throwable {
        return pizzaCapturedUpdate.getValue();
      }
    });

    Pizza findByIdPizza = new Pizza(1L, "Veggie", new BigDecimal(102.00), new Base(1L, "Pan"));

    EasyMock.expect(pizzaServlce.findById(1L)).andReturn(findByIdPizza).anyTimes();

    EasyMock.expect(pizzaServlce.findById(2L)).andReturn(null).anyTimes();

    EasyMock.replay(pizzaServlce);
  }

  /**
   * Test find all.
   *
   * @throws Exception
   *           the exception
   */
  @Test
  public void testFindAll() throws Exception {
    Iterable<Pizza> result = fixture.getPizzas();
    assertNotNull(result);
    assertEquals(result.iterator().next().getId().longValue(), 1L);
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
    pizza = fixture.savePizza(pizza, 1L);
    assertNotNull(pizza);
    assertEquals(pizza.getName(), "Veggie");
  }

  /**
   * Test saveNotFound.
   *
   * @throws Exception
   *           the exception
   */
  @Test(expected = ResourceNotFoundException.class)
  public void testSaveNotFound() throws Exception {
    Pizza pizza = new Pizza(2L, "Delight", new BigDecimal(102.00), new Base(1L, "Pan"));
    pizza = fixture.savePizza(pizza, 2L);
  }

  /**
   * Test add.
   *
   * @throws Exception
   *           the exception
   */
  @Test
  public void testAdd() throws Exception {
    Pizza pizza = new Pizza(1L, "Veggie", new BigDecimal(102.00), new Base(1L, "Pan"), toppings);
    pizza = fixture.addPizza(pizza);
    assertNotNull(pizza);
    assertEquals(pizza.getName(), "Veggie");
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
    new org.junit.runner.JUnitCore().run(PizzaControllerTest.class);
  }
}