/*
 * 
 */
package com.niit.devcapsule.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.devcapsule.domain.Pizza;
import com.niit.devcapsule.service.PizzaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class PizzaController.
 */
@RestController
public class PizzaController {

   private static final Logger logger = LoggerFactory.getLogger(PizzaController.class);		
   
  /** The pizza service. */
  @Autowired
  PizzaService pizzaService;
  
  
  private static final String loggerMessage = "TrackingId:99a80896-35a4-468c-9ec3-b762ab161429|ClientId:99a80897-35a4-468c-9ec3-b762ab161429"+"|Transaction:{}" 
          + "|Price:{}" + "|PizzaName:{}" ; 

  private static final String[] logParameters = new String[6] ;

  /**
   * Gets the toppings.
   *
   * @return the toppings
   */
  @CrossOrigin(origins = "http://localhost:8000")
  @ApiOperation(value = "Get all the pizzas", response = Pizza.class, responseContainer = "List", produces = "application/json")
  @RequestMapping(value = "/pizzas", method = RequestMethod.GET)
  public Iterable<Pizza> getPizzas() {
	//logger.info("TrackingId:89a80896-35a4-468c-9ec3-b762ab161429|ClientId:89a80897-35a4-468c-9ec3-b762ab161429|Find All Pizzas");
	Iterable<Pizza> pizzaIterable = pizzaService.findAll();  
    return pizzaIterable;
  }

  /**
   * Gets the toppings.
   *
   * @param pizza
   *          the pizza
   * @return the toppings
   */
  @CrossOrigin(origins = "http://localhost:8000")
  @ApiOperation(value = "Add a new pizza", notes = "Correct ID and Name combinations for Toppings need to be provided.", response = Pizza.class, produces = "application/json")
  @RequestMapping(value = "/pizzas", method = RequestMethod.POST, consumes = "application/json")
  public Pizza addPizza(@ApiParam(value = "Pizza to be added", required = true) @RequestBody Pizza pizza) {
	//logger.info("TrackingId:99a80896-35a4-468c-9ec3-b762ab161429|ClientId:99a80897-35a4-468c-9ec3-b762ab161429|Pizza {} added ",pizza.getName());  
	     logParameters[0] = "Pizza Added";
	     logParameters[1] = pizza.getPrice().toString();
	     logParameters[2] = pizza.getName();
	    
		 
	     logger.info(loggerMessage, logParameters);  
	  
	  
    return pizzaService.addPizza(pizza);
  }

  /**
   * Save pizza.
   *
   * @param pizza
   *          the pizza
   * @param id
   *          the id
   * @return the pizza
   */
  @CrossOrigin(origins = "http://localhost:8000")
  @ApiOperation(value = "Save an existing pizza", response = Pizza.class, produces = "application/json")
  @RequestMapping(value = "/pizzas/{id}", method = RequestMethod.POST)
  public Pizza savePizza(@ApiParam(value = "Pizza to be saved", required = true) @RequestBody Pizza pizza,
      @ApiParam(value = "Id of the pizza to save", required = true) @PathVariable Long id) {
    pizza.setId(id);
    Pizza isItthere = pizzaService.findById(id);
	//logger.info("TrackingId:99a80896-35a4-468c-9ec3-b762ab161429|ClientId:99a80897-35a4-468c-9ec3-b762ab161429|Pizza Id {}",id);  
    if (isItthere == null) {
		//logger.info("TrackingId:99a80896-35a4-468c-9ec3-b762ab161429|ClientId:99a80897-35a4-468c-9ec3-b762ab161429|Pizza with Id {} not found",id);  
      throw new ResourceNotFoundException("Pizza with ID " + id + " not found");
    }
	//logger.info("TrackingId:99a80896-35a4-468c-9ec3-b762ab161429|ClientId:99a80897-35a4-468c-9ec3-b762ab161429|Pizza Id {} updated",id); 
    return pizzaService.updatePizza(pizza);
  }
}
