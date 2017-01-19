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

import com.niit.devcapsule.dao.PizzaOrderDAO;
import com.niit.devcapsule.domain.Base;
import com.niit.devcapsule.domain.Pizza;
import com.niit.devcapsule.domain.PizzaOrder;
import com.niit.devcapsule.domain.Topping;

public class PizzaOrderServiceImplTest {

  PizzaOrderDAO pizzaOrderDAO;

  PizzaOrderServiceImpl fixture;

  /**
   * Sets the up.
   *
   * @throws Exception
   *           the exception
   */
  @Before
  public void setUp() throws Exception {
    fixture = new PizzaOrderServiceImpl();
    pizzaOrderDAO = EasyMock.createNiceMock(PizzaOrderDAO.class);
    fixture.pizzaOrderDAO = pizzaOrderDAO;

    // getOrders
    Set<Pizza> pizzas = new HashSet<Pizza>();
    Set<Topping> toppings = new HashSet<Topping>();
    toppings.add(new Topping(1L, "Onion"));
    toppings.add(new Topping(2L, "Capsucum"));
    pizzas.add(new Pizza(1L, "Veggie", new BigDecimal(102.00), new Base(1L, "Pan"), toppings));
    List<PizzaOrder> orders = new ArrayList<PizzaOrder>();
    PizzaOrder newOrder = new PizzaOrder(1L, pizzas, new BigDecimal(1020));
    orders.add(newOrder);
    EasyMock.expect(pizzaOrderDAO.findAll()).andReturn(orders);

    // addOrder
    final Capture<PizzaOrder> pizzaOrderCapturedAdd = new Capture<PizzaOrder>();
    EasyMock.expect(pizzaOrderDAO.save(EasyMock.capture(pizzaOrderCapturedAdd))).andAnswer(new IAnswer<PizzaOrder>() {
      public PizzaOrder answer() throws Throwable {
        pizzaOrderCapturedAdd.getValue().setId(1L);
        return pizzaOrderCapturedAdd.getValue();
      }
    });

    EasyMock.expect(pizzaOrderDAO.findById(1L)).andReturn(newOrder).anyTimes();

    EasyMock.expect(pizzaOrderDAO.findById(2L)).andReturn(null).anyTimes();

    EasyMock.replay(pizzaOrderDAO);
  }

  /**
   * Test get orders.
   *
   * @throws Exception
   *           the exception
   */
  @Test
  public void testGetOrders() throws Exception {
    Iterable<PizzaOrder> result = fixture.findAll();
    assertNotNull(result);
    assertEquals(result.iterator().next().getId().longValue(), 1L);
  }

  /**
   * Test add.
   *
   * @throws Exception
   *           the exception
   */
  @Test
  public void testAdd() throws Exception {
    Set<Pizza> pizzas = new HashSet<Pizza>();
    Pizza pizza = new Pizza();
    pizza.setId(1L);
    pizzas.add(pizza);
    PizzaOrder order = new PizzaOrder(pizzas, new BigDecimal(1020));
    order = fixture.addOrder(order);
    assertNotNull(order);
    assertEquals(order.getId().longValue(), 1L);
  }

  /**
   * Test save.
   *
   * @throws Exception
   *           the exception
   */
  @Test
  public void testSave() throws Exception {
    Set<Topping> toppings = new HashSet<Topping>();
    toppings.add(new Topping(1L, "Onion"));
    toppings.add(new Topping(2L, "Capsucum"));
    Pizza pizza = new Pizza(1L, "Veggie", new BigDecimal(102.00), new Base(1L, "Pan"), toppings);
    Set<Pizza> pizzas = new HashSet<Pizza>();
    pizzas.add(pizza);
    pizzas.add(pizza);
    pizzas.add(pizza);
    PizzaOrder order = new PizzaOrder(1L, pizzas, new BigDecimal(1020));
    order = fixture.updateOrder(order);
    assertNotNull(order);
    assertEquals(order.getTotalPrice().longValue(), 1020);
  }

  /**
   * Test findById.
   *
   * @throws Exception
   *           the exception
   */
  @Test
  public void testFindById() throws Exception {
    PizzaOrder order = fixture.findById(1L);
    assertNotNull(order);
    assertEquals(order.getTotalPrice().longValue(), 1020);
    fixture.deleteOrder(1L);
  }

  /**
   * Test findByIdNotFound.
   *
   * @throws Exception
   *           the exception
   */
  @Test
  public void testFindByIdNotFound() throws Exception {
    PizzaOrder order = fixture.findById(2L);
    assertEquals(order, null);
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
    new org.junit.runner.JUnitCore().run(PizzaOrderServiceImplTest.class);
  }
}