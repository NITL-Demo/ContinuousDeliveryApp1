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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class PizzaServiceImpl.
 */
@Component
@Transactional
public class PizzaServiceImpl implements PizzaService {
	
  private static final Logger logger = LoggerFactory.getLogger(PizzaServiceImpl.class);			

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
	//logger.info("TrackingId:89a80896-35a4-468c-9ec3-b762ab161429|ClientId:89a80897-35a4-468c-9ec3-b762ab161429|Find All Pizzas");  
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
	logger.info("TrackingId:99a80896-35a4-468c-9ec3-b762ab161429|ClientId:99a80897-35a4-468c-9ec3-b762ab161429|Pizza {} added ",pizza.getName());  
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
	  logger.info("TrackingId:99a80896-35a4-468c-9ec3-b762ab161429|ClientId:99a80897-35a4-468c-9ec3-b762ab161429|Pizza Id {} updated",pizza.getId());  
    return pizzaDao.save(pizza);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.niit.devcapsule.service.PizzaService#findById(java.lang.Long)
   */
  @Override
  public Pizza findById(Long id) {
	  logger.info("TrackingId:99a80896-35a4-468c-9ec3-b762ab161429|ClientId:99a80897-35a4-468c-9ec3-b762ab161429|Pizza Id {}",id);  
    return pizzaDao.findById(id);
  }

}
