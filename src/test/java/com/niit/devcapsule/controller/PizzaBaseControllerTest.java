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

import com.niit.devcapsule.domain.Base;
import com.niit.devcapsule.service.PizzaBaseService;

/**
 * The class <code>PizzaBaseControllerTest</code> contains tests for the class
 * <code>{@link PizzaBaseController}</code>.
 *
 * @author PSachdev
 * @version $Revision: 1.0 $
 */
public class PizzaBaseControllerTest {

  PizzaBaseService baseService;
  PizzaBaseController fixture;

  /**
   * Perform pre-test initialization.
   *
   * @throws Exception
   *           if the initialization fails for some reason
   *
   */
  @Before
  public void setUp() throws Exception {
    fixture = new PizzaBaseController();
    baseService = EasyMock.createNiceMock(PizzaBaseService.class);
    fixture.pizzaBaseService = baseService;

    // Addbase
    final Capture<String> baseNameAdd = new Capture<String>();
    EasyMock.expect(baseService.addBase(EasyMock.capture(baseNameAdd))).andAnswer(new IAnswer<Base>() {
      public Base answer() {
        Base baseReturned = new Base(1L, baseNameAdd.getValue());
        return baseReturned;
      }
    });

    // getBases
    List<Base> bases = new ArrayList<Base>();
    bases.add(new Base(1L, "Pan"));
    bases.add(new Base(2L, "Thin Crust"));
    EasyMock.expect(baseService.findAll()).andReturn(bases);

    // findByName
    final Capture<String> baseNameFindByName = new Capture<String>();
    EasyMock.expect(baseService.findByName(EasyMock.capture(baseNameFindByName))).andAnswer(new IAnswer<Base>() {
      public Base answer() {
        if (baseNameFindByName.getValue().equals("Pan")) {
          Base baseReturned = new Base(1L, baseNameFindByName.getValue());
          return baseReturned;
        } else {
          return null;
        }
      }
    });

    EasyMock.replay(baseService);
  }

  /**
   * Run the Base addBase(Base) method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testAddBase() throws Exception {
    Base base = new Base("Pan");
    Base result = fixture.addBase(base);
    assertNotNull(result);
    assertEquals(result.getId().longValue(), 1L);
    assertEquals(result.getName(), "Pan");
  }

  /**
   * Run the Base getBaseByName(String) method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testGetBaseByName() throws Exception {
    Base result = fixture.getBaseByName("Pan");
    assertNotNull(result);
    assertEquals(result.getId().longValue(), 1L);
    assertEquals(result.getName(), "Pan");
  }

  /**
   * Run the Base getBaseByNameNotFound(String) method test.
   *
   * @throws Exception
   *
   */
  @Test(expected = ResourceNotFoundException.class)
  public void testGetBaseByNameNotFound() {
    Base result = fixture.getBaseByName("Pan2");
  }

  /**
   * Run the Iterable<Base> getBases() method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testGetBases() throws Exception {
    Iterable<Base> result = fixture.getBases();
    assertNotNull(result);
    assertEquals(result.iterator().next().getName(), "Pan");
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