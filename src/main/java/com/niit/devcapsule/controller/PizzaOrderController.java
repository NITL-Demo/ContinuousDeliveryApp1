/*
 * 
 */
package com.niit.devcapsule.controller;

import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.devcapsule.domain.Pizza;
import com.niit.devcapsule.domain.PizzaOrder;
import com.niit.devcapsule.service.PizzaOrderService;
import com.niit.devcapsule.service.PizzaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * The Class PizzaOrderController.
 */
@RestController
public class PizzaOrderController {

  private static final Logger logger = LoggerFactory.getLogger(PizzaOrderController.class);

  /** The pizza order service. */
  @Autowired
  PizzaOrderService pizzaOrderService;
  
  @Autowired
  PizzaService pizzaService;
  

  private static final String loggerMessage = "TrackingId:99a80896-35a4-468c-9ec3-b762ab161429|ClientId:99a80897-35a4-468c-9ec3-b762ab161429"+"|Transaction:{}" 
          + "|Price:{}" + "|OrderNo:{}" + "|PizzaName:{}" + "|BaseName:{}"; 

  private String[] logParameters = new String[6] ;
  
  
  /**
   * Gets the pizza orders.
   *
   * @return the pizza orders
   */
  @CrossOrigin(origins = "http://localhost:8000")
  @ApiOperation(value = "Get all the orders", produces = "application/json", response = PizzaOrder.class, responseContainer = "List")
  @RequestMapping(value = "/orders", method = RequestMethod.GET)
  public Iterable<PizzaOrder> getPizzaOrders() {
	
	Iterable<PizzaOrder> pizzaOrderIterable = pizzaOrderService.findAll();
    return pizzaOrderIterable;
  }

  /**
   * Adds a new Pizza Order.
   *
   * @param pizzaOrder
   *          the pizza order
   * @return the pizza order
   */
  @CrossOrigin(origins = "http://localhost:8000")
  @ApiOperation(value = "Add a new order", response = PizzaOrder.class, produces = "application/json")
  @RequestMapping(value = "/orders", method = RequestMethod.POST, consumes = "application/json")
  public PizzaOrder addPizzaOrder(
      @ApiParam(value = "New pizza order to add", required = true) @RequestBody PizzaOrder pizzaOrder) {
		  
	
	
	PizzaOrder pizzaOrdered = pizzaOrderService.addOrder(pizzaOrder);
	
	Set<Pizza> pizzaOrderedList =  pizzaOrdered.getPizzas();
	
	try{
	    for(Pizza pizza : pizzaOrderedList){		
	    	 Pizza pizzaObj = pizzaService.findById(pizza.getId());
			 logParameters[0] = "Pizza Ordered";
		     logParameters[1] = String.valueOf(pizzaObj.getPrice());
		     logParameters[2] = String.valueOf(pizzaOrdered.getId()) ;
		     logParameters[3] = pizzaObj.getName();
		     logParameters[4] = pizzaObj.getBase().getName();
		    
			 
		     logger.info(loggerMessage, logParameters);  
		}
	}catch(Exception ex){
		ex.getMessage();
	}
	
     return pizzaOrder ;
  }

  /**
   * Save pizza order .
   *
   * @param pizzaOrder
   *          the pizza order
   * @param id
   *          the id
   * @return the pizza order
   */
  @CrossOrigin(origins = "http://localhost:8000")
  @ApiOperation(value = "Update a pizza order by ID", produces = "application/json", response = PizzaOrder.class)
  @RequestMapping(value = "/orders/{id}", method = RequestMethod.POST, consumes = "application/json")
  public PizzaOrder savePizzaOrder(
      @ApiParam(value = "Pizza order details to update. Id is passed separately.", required = true) @RequestBody PizzaOrder pizzaOrder,
      @ApiParam(value = "ID of the Pizza Order to update", required = true) @PathVariable Long id) {
    pizzaOrder.setId(id);
    PizzaOrder isItThere = pizzaOrderService.findById(id);
    if (isItThere == null) {
	  throw new ResourceNotFoundException("Order with id " + id + " not found");
	  
    }
	
    return pizzaOrderService.updateOrder(pizzaOrder);
  }

  /**
   * Delete a pizza order.
   *
   * @param id
   *          the id
   */
  @CrossOrigin(origins = "http://localhost:8000")
  @ApiOperation(value = "Delete an existing order by its ID")
  @RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
  public void deletePizzaOrder(@ApiParam(value = "ID of the pizza order to delete", required = true) @PathVariable Long id) {
    PizzaOrder isItThere = pizzaOrderService.findById(id);
	
    if (isItThere == null) {
	  throw new ResourceNotFoundException("Order with id " + id + " not found");
	  
    }
	
    pizzaOrderService.deleteOrder(id);
  }

}
