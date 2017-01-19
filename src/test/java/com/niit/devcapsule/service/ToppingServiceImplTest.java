package com.niit.devcapsule.service;

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

import com.niit.devcapsule.dao.ToppingDAO;
import com.niit.devcapsule.domain.Topping;

/**
 * The Class ToppingServiceImplTest.
 */
public class ToppingServiceImplTest {

  /** The topping dao. */
  ToppingDAO toppingDAO;

  /** The fixture. */
  ToppingServiceImpl fixture;

  /**
   * Sets the up.
   *
   * @throws Exception
   *           the exception
   */
  @Before
  public void setUp() throws Exception {
    fixture = new ToppingServiceImpl();
    toppingDAO = EasyMock.createNiceMock(ToppingDAO.class);
    fixture.toppingDao = toppingDAO;

    // findAll
    List<Topping> toppings = new ArrayList<Topping>();
    toppings.add(new Topping(1L, "Onion"));
    toppings.add(new Topping(2L, "Capsucum"));
    EasyMock.expect(toppingDAO.findAll()).andReturn(toppings);

    // findById
    EasyMock.expect(toppingDAO.findById(1L)).andReturn(toppings.get(0));

    // findByName
    EasyMock.expect(toppingDAO.findByName("Onion")).andReturn(toppings.get(0));

    // addTopping
    Capture<Topping> toppingCaptured = new Capture<Topping>();
    EasyMock.expect(toppingDAO.save(EasyMock.capture(toppingCaptured))).andAnswer(new IAnswer<Topping>() {
      public Topping answer() {
        toppingCaptured.getValue().setId(1L);
        return toppingCaptured.getValue();
      }
    });

    EasyMock.replay(toppingDAO);
  }

  /**
   * Test find all.
   *
   * @throws Exception
   *           the exception
   */
  @Test
  public void testFindAll() throws Exception {
    List<Topping> result = fixture.findAll();
    assertNotNull(result);
    assertEquals(result.size(), 2);
  }

  /**
   * Test find by id.
   *
   * @throws Exception
   *           the exception
   */
  @Test
  public void testFindById() throws Exception {
    Topping result = fixture.findById(1L);
    assertNotNull(result);
    assertEquals(result.getId().longValue(), 1L);
  }

  /**
   * Test find by name.
   *
   * @throws Exception
   *           the exception
   */
  @Test
  public void testFindByName() throws Exception {
    Topping result = fixture.findByName("Onion");
    assertNotNull(result);
    assertEquals(result.getName(), "Onion");
  }

  /**
   * Test add topping.
   *
   * @throws Exception
   *           the exception
   */
  @Test
  public void testAddTopping() throws Exception {
    Topping result = fixture.addTopping("Onion");
    assertNotNull(result);
    assertEquals(result.getName(), "Onion");
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