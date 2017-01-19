package com.niit.devcapsule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.devcapsule.dao.PizzaOrderDAO;
import com.niit.devcapsule.domain.PizzaOrder;

/**
 * The Class PizzaOrderServiceImpl.
 */
@Component
public class PizzaOrderServiceImpl implements PizzaOrderService {

  /** The pizza order dao. */
  @Autowired
  PizzaOrderDAO pizzaOrderDAO;

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.niit.devcapsule.service.PizzaOrderService#addOrder(com.niit.devcapsule.
   * domain.PizzaOrder)
   */
  @Override
  public PizzaOrder addOrder(PizzaOrder pizzaOrder) {
    return pizzaOrderDAO.save(pizzaOrder);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.niit.devcapsule.service.PizzaOrderService#deleteOrder(java.lang.Long)
   */
  @Override
  public void deleteOrder(Long id) {
    pizzaOrderDAO.delete(id);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.niit.devcapsule.service.PizzaOrderService#findAll()
   */
  @Override
  public List<PizzaOrder> findAll() {
    return pizzaOrderDAO.findAll();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.niit.devcapsule.service.PizzaOrderService#updateOrder(com.niit.
   * devcapsule.domain.PizzaOrder)
   */
  @Override
  public PizzaOrder updateOrder(PizzaOrder pizzaOrder) {
    return pizzaOrderDAO.save(pizzaOrder);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.niit.devcapsule.service.PizzaOrderService#findById(java.lang.Long)
   */
  @Override
  public PizzaOrder findById(Long id) {
    return pizzaOrderDAO.findById(id);
  }
}
