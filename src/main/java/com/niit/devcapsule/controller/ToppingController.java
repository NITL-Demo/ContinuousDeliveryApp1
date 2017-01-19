/*
 * 
 */
package com.niit.devcapsule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.devcapsule.domain.Topping;
import com.niit.devcapsule.service.ToppingService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * The Class ToppingController.
 */
@RestController
public class ToppingController {

  /** The topping service. */
  @Autowired
  ToppingService toppingService;

  /**
   * Gets the toppings.
   *
   * @return the toppings
   */
  @CrossOrigin(origins = "http://localhost:8000")
  @ApiOperation(value = "Get all the toppings", response = Topping.class, responseContainer = "List", produces = "application/json")
  @RequestMapping(value = "/toppings", method = RequestMethod.GET)
  public Iterable<Topping> getToppings() {
    return toppingService.findAll();
  }

  /**
   * Gets the topping by name.
   *
   * @param name
   *          the name
   * @return the topping by name
   */
  @ApiOperation(value = "Get a topping by its name", response = Topping.class, produces = "application/json")
  @RequestMapping(value = "/toppings/{name}", method = RequestMethod.GET)
  public Topping getToppingByName(
      @ApiParam(value = "Name of the Topping to retrieve", required = true) @PathVariable String name) {
    Topping topping = toppingService.findByName(name);
    if (topping == null) {
      throw new ResourceNotFoundException("Topping with name " + name + " not found");
    }
    return topping;
  }

  /**
   * Adds the topping.
   *
   * @param topping
   *          the topping
   * @return the topping
   */
  @CrossOrigin(origins = "http://localhost:8000")
  @ApiOperation(value = "Add a new topping", notes = "ID to be left blank. Will be ignored if passed.", response = Topping.class, produces = "application/json")
  @RequestMapping(value = "/toppings", method = RequestMethod.POST, consumes = "application/json")
  public Topping addTopping(@ApiParam(value = "New topping to add", required = true) @RequestBody Topping topping) {
    return toppingService.addTopping(topping.getName());
  }
}
