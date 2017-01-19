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

import com.niit.devcapsule.dao.PizzaBaseDAO;
import com.niit.devcapsule.domain.Base;

/**
 * The class <code>PizzaBaseServiceImplTest</code> contains tests for the class
 * <code>{@link PizzaBaseServiceImpl}</code>.
 *
 * @author PSachdev
 * @version $Revision: 1.0 $
 */
public class PizzaBaseServiceImplTest {

  /** The base dao. */
  PizzaBaseDAO baseDAO;

  /** The fixture. */
  PizzaBaseServiceImpl fixture;

  /**
   * Sets the up.
   *
   * @throws Exception
   *           the exception
   */
  @Before
  public void setUp() throws Exception {
    fixture = new PizzaBaseServiceImpl();
    baseDAO = EasyMock.createNiceMock(PizzaBaseDAO.class);
    fixture.pizzaBaseDao = baseDAO;

    // findAll
    List<Base> bases = new ArrayList<Base>();
    bases.add(new Base(1L, "Pan"));
    bases.add(new Base(2L, "Thin Crust"));
    EasyMock.expect(baseDAO.findAll()).andReturn(bases);

    // findById
    EasyMock.expect(baseDAO.findById(1L)).andReturn(bases.get(0)).anyTimes();

    // findByName
    EasyMock.expect(baseDAO.findByName("Pan")).andReturn(bases.get(0));

    // addBase
    final Capture<Base> baseCaptured = new Capture<Base>();
    EasyMock.expect(baseDAO.save(EasyMock.capture(baseCaptured))).andAnswer(new IAnswer<Base>() {
      public Base answer() {
        baseCaptured.getValue().setId(1L);
        return baseCaptured.getValue();
      }
    });

    EasyMock.replay(baseDAO);
  }

  /**
   * Test find all.
   *
   * @throws Exception
   *           the exception
   */
  @Test
  public void testFindAll() throws Exception {
    List<Base> result = fixture.findAll();
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
    Base result = fixture.findById(1L);
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
    Base result = fixture.findByName("Pan");
    assertNotNull(result);
    assertEquals(result.getName(), "Pan");
  }

  /**
   * Test add base.
   *
   * @throws Exception
   *           the exception
   */
  @Test
  public void testAddBase() throws Exception {
    Base result = fixture.addBase("Pan");
    assertNotNull(result);
    assertEquals(result.getName(), "Pan");
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