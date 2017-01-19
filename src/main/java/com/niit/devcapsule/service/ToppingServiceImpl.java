/*
 * 
 */
package com.niit.devcapsule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.devcapsule.dao.ToppingDAO;
import com.niit.devcapsule.domain.Topping;

/**
 * The Class ToppingServiceImpl.
 */
@Component
public class ToppingServiceImpl implements ToppingService {

  /** The topping dao. */
  @Autowired
  ToppingDAO toppingDao;

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.niit.devcapsule.service.ToppingService#addTopping(java.lang.String)
   */
  @Override
  public Topping addTopping(String name) {
    Topping topping = new Topping(name);
    return toppingDao.save(topping);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.niit.devcapsule.service.ToppingService#findAll()
   */
  @Override
  public List<Topping> findAll() {
    return toppingDao.findAll();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.niit.devcapsule.service.ToppingService#findById(java.lang.Long)
   */
  @Override
  public Topping findById(Long id) {
    return toppingDao.findById(id);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.niit.devcapsule.service.ToppingService#findByName(java.lang.String)
   */
  @Override
  public Topping findByName(String name) {
    return toppingDao.findByName(name);
  }
}
