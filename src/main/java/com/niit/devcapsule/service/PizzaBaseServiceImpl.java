/*
 * 
 */
package com.niit.devcapsule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.devcapsule.dao.PizzaBaseDAO;
import com.niit.devcapsule.domain.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The Class PizzaBaseServiceImpl.
 */
@Component
public class PizzaBaseServiceImpl implements PizzaBaseService {
	
  private static final Logger logger = LoggerFactory.getLogger(PizzaBaseServiceImpl.class);	

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
    logger.info("TrackingId:99a80896-35a4-468c-9ec3-b762ab161429|ClientId:99a80897-35a4-468c-9ec3-b762ab161429|Find all Bases");
    return pizzaBaseDao.findAll();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.niit.devcapsule.service.PizzaBaseService#addBase(java.lang.String)
   */
  @Override
  public Base addBase(String name) {
	logger.info("TrackingId:99a80896-35a4-468c-9ec3-b762ab161429|ClientId:99a80897-35a4-468c-9ec3-b762ab161429|BaseName : {}  added", name);  
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
	logger.info("TrackingId:99a80896-35a4-468c-9ec3-b762ab161429|ClientId:99a80897-35a4-468c-9ec3-b762ab161429|Find Base By Id:: {}", id);  
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
	logger.info("TrackingId:99a80896-35a4-468c-9ec3-b762ab161429|ClientId:99a80897-35a4-468c-9ec3-b762ab161429|Find Base By Name:: {}", name);    
    return pizzaBaseDao.findByName(name);
  }
}
