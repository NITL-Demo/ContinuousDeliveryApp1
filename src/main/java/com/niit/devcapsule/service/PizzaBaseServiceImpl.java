/*
 * 
 */
package com.niit.devcapsule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.devcapsule.dao.PizzaBaseDAO;
import com.niit.devcapsule.domain.Base;

/**
 * The Class PizzaBaseServiceImpl.
 */
@Component
public class PizzaBaseServiceImpl implements PizzaBaseService {

  /** The pizza base dao. */
  @Autowired
  PizzaBaseDAO pizzaBaseDao;

  /*
   * (non-Javadoc)
   * 
   * @see com.niit.devcapsule.service.PizzaBaseService#findAll()
   */
  @Override
  public List<Base> findAll() {
    return pizzaBaseDao.findAll();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.niit.devcapsule.service.PizzaBaseService#addBase(java.lang.String)
   */
  @Override
  public Base addBase(String name) {
    Base base = new Base(name);
    return pizzaBaseDao.save(base);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.niit.devcapsule.service.PizzaBaseService#findById(java.lang.Long)
   */
  @Override
  public Base findById(Long id) {
    return pizzaBaseDao.findById(id);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.niit.devcapsule.service.PizzaBaseService#findByName(java.lang.String)
   */
  @Override
  public Base findByName(String name) {
    return pizzaBaseDao.findByName(name);
  }
}
