package com.niit.devcapsule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.devcapsule.dao.PizzaOrderDAO;
import com.niit.devcapsule.domain.PizzaOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class PizzaOrderServiceImpl.
 */
@Component
public class PizzaOrderServiceImpl implements PizzaOrderService {
	
  private static final Logger logger = LoggerFactory.getLogger(PizzaOrderServiceImpl.class);	

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
	logger.info("TrackingId:89a80896-35a4-468c-9ec3-b762ab161429|ClientId:89a80897-35a4-468c-9ec3-b762ab161429|Pizza OrderID: {} added",pizzaOrder.getId());	    
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
	logger.info("TrackingId:89a80896-35a4-468c-9ec3-b762ab161429|ClientId:89a80897-35a4-468c-9ec3-b762ab161429|Pizza OrderID: {} deleted",id);	  
    pizzaOrderDAO.delete(id);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.niit.devcapsule.service.PizzaOrderService#findAll()
   */
  @Override
  public List<PizzaOrder> findAll() {
	//logger.info("TrackingId:89a80896-35a4-468c-9ec3-b762ab161429|ClientId:89a80897-35a4-468c-9ec3-b762ab161429|Find all Ordered Pizza");  
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
	logger.info("TrackingId:89a80896-35a4-468c-9ec3-b762ab161429|ClientId:89a80897-35a4-468c-9ec3-b762ab161429|Pizza OrderID: {} updated",pizzaOrder.getId());	  
    return pizzaOrderDAO.save(pizzaOrder);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.niit.devcapsule.service.PizzaOrderService#findById(java.lang.Long)
   */
  @Override
  public PizzaOrder findById(Long id) {
	logger.info("TrackingId:89a80896-35a4-468c-9ec3-b762ab161429|ClientId:89a80897-35a4-468c-9ec3-b762ab161429|Find Pizza OrderID: {} ",id);	  
    return pizzaOrderDAO.findById(id);
  }
}
