/*
 * 
 */
package com.niit.devcapsule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.devcapsule.dao.ToppingDAO;
import com.niit.devcapsule.domain.Topping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class ToppingServiceImpl.
 */
@Component
public class ToppingServiceImpl implements ToppingService {

  private static final Logger logger = LoggerFactory.getLogger(ToppingServiceImpl.class);	

 
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
	logger.info("TrackingId:99a80896-35a4-468c-9ec3-b762ab161429|ClientId:99a80897-35a4-468c-9ec3-b762ab161429|Topping {} saved" , name);
    return toppingDao.save(topping);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.niit.devcapsule.service.ToppingService#findAll()
   */
  @Override
  public List<Topping> findAll() {
    //logger.info("TrackingId:99a80896-35a4-468c-9ec3-b762ab161429|ClientId:99a80897-35a4-468c-9ec3-b762ab161429|Find all Toppings");
    return toppingDao.findAll();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.niit.devcapsule.service.ToppingService#findById(java.lang.Long)
   */
  @Override
  public Topping findById(Long id) {
	logger.info("TrackingId:99a80896-35a4-468c-9ec3-b762ab161429|ClientId:99a80897-35a4-468c-9ec3-b762ab161429|Find Toppings By Id: {}",id);
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
	logger.info("TrackingId:99a80896-35a4-468c-9ec3-b762ab161429|ClientId:99a80897-35a4-468c-9ec3-b762ab161429|Find Toppings By Name: {}",name);
    return toppingDao.findByName(name);
  }
}
