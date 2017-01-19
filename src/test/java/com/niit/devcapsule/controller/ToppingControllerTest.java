package com.niit.devcapsule.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.Capture;
import org.easymock.EasyMock;
import org.easymock.IAnswer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import com.niit.devcapsule.domain.Topping;
import com.niit.devcapsule.service.ToppingService;

/**
 * The class <code>ToppingControllerTest</code> contains tests for the class
 * <code>{@link ToppingController}</code>.
 *
 * @author PSachdev
 * @version $Revision: 1.0 $
 */
public class ToppingControllerTest {
  ToppingService toppingService;
  ToppingController fixture;

  /**
   * Perform pre-test initialization.
   *
   * @throws Exception
   *           if the initialization fails for some reason
   *
   */
  @Before
  public void setUp() throws Exception {
    fixture = new ToppingController();
    toppingService = EasyMock.createNiceMock(ToppingService.class);
    fixture.toppingService = toppingService;

    // Addbase
    final Capture<String> toppingNameAdd = new Capture<String>();
    EasyMock.expect(toppingService.addTopping(EasyMock.capture(toppingNameAdd))).andAnswer(new IAnswer<Topping>() {
      public Topping answer() {
        Topping toppingReturned = new Topping(1L, toppingNameAdd.getValue());
        return toppingReturned;
      }
    });

    // getBases
    List<Topping> toppings = new ArrayList<Topping>();
    toppings.add(new Topping(1L, "Onion"));
    toppings.add(new Topping(2L, "Tomato"));
    EasyMock.expect(toppingService.findAll()).andReturn(toppings).anyTimes();

    // findByName
    final Capture<String> toppingFindByName = new Capture<String>();
    EasyMock.expect(toppingService.findByName(EasyMock.capture(toppingFindByName))).andAnswer(new IAnswer<Topping>() {
      public Topping answer() {
        if (toppingFindByName.getValue().equals("Onion")) {
          Topping toppingReturned = new Topping(1L, toppingFindByName.getValue());
          return toppingReturned;
        } else {
          return null;
        }
      }
    }).anyTimes();

    EasyMock.replay(toppingService);
  }

  /**
   * Run the Base addBase(Base) method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testAddTopping() throws Exception {
    Topping topping = new Topping("Onion");
    Topping result = fixture.addTopping(topping);
    assertNotNull(result);
    assertEquals(result.getId().longValue(), 1L);
    assertEquals(result.getName(), "Onion");
  }

  /**
   * Run the Base getBaseByName(String) method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testGetToppingByName() throws Exception {
    Topping result = fixture.getToppingByName("Onion");
    assertNotNull(result);
    assertEquals(result.getId().longValue(), 1L);
    assertEquals(result.getName(), "Onion");
  }

  /**
   * Run the Base getBaseByNameNotFound(String) method test.
   *
   * @throws Exception
   *
   */
  @Test(expected = ResourceNotFoundException.class)
  public void testGetToppingByNameNotFound() throws Exception {
    Topping result = fixture.getToppingByName("MarsTopping");
  }

  /**
   * Run the Iterable<Base> getBases() method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testGetToppings() throws Exception {
    Iterable<Topping> result = fixture.getToppings();
    assertNotNull(result);
    assertEquals(result.iterator().next().getName(), "Onion");
  }

  /**
   * Launch the test.
   *
   * @param args
   *          the command line arguments
   *
   */
  public static void main(String[] args) {
    new org.junit.runner.JUnitCore().run(PizzaBaseControllerTest.class);
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