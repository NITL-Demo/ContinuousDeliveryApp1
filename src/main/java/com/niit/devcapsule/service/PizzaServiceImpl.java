/*
 * 
 */
package com.niit.devcapsule.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.devcapsule.dao.PizzaDAO;
import com.niit.devcapsule.domain.Pizza;
import com.niit.devcapsule.domain.Topping;

/**
 * The Class PizzaServiceImpl.
 */
@Component
@Transactional
public class PizzaServiceImpl implements PizzaService {

  /** The pizza dao. */
  @Autowired
  PizzaDAO pizzaDao;

  /*
   * (non-Javadoc)
   * 
   * @see com.niit.devcapsule.service.PizzaService#findAll()
   */
  @Override
  public List<Pizza> findAll() {
    return pizzaDao.findAll();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.niit.devcapsule.service.PizzaService#addNewPizza(com.niit.devcapsule.
   * domain.Pizza)
   */
  @Override
  public Pizza addPizza(Pizza pizza) {
    Set<Topping> toppings = new HashSet<Topping>(pizza.getToppings());
    pizza.setToppings(null);
    Pizza pizzaSaved = pizzaDao.save(pizza);
    if (toppings != null && !toppings.isEmpty()) {
      pizzaSaved.setToppings(toppings);
      pizzaSaved = pizzaDao.save(pizzaSaved);
    }
    return pizzaSaved;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.niit.devcapsule.service.PizzaService#updatePizza(com.niit.devcapsule.
   * domain.Pizza)
   */
  @Override
  public Pizza updatePizza(Pizza pizza) {
    return pizzaDao.save(pizza);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.niit.devcapsule.service.PizzaService#findById(java.lang.Long)
   */
  @Override
  public Pizza findById(Long id) {
    return pizzaDao.findById(id);
  }

}
