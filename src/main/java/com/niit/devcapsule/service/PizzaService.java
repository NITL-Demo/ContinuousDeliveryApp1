/*
 * 
 */
package com.niit.devcapsule.service;

import java.util.List;

import com.niit.devcapsule.domain.Pizza;

/**
 * The Interface PizzaService.
 */
public interface PizzaService {

  /**
   * Find all.
   *
   * @return the list
   */
  List<Pizza> findAll();

  /**
   * Adds the new pizza.
   *
   * @param pizza
   *          the pizza
   * @return the pizza
   */
  Pizza addPizza(Pizza pizza);

  /**
   * Update pizza.
   *
   * @param pizza
   *          the pizza
   * @return the pizza
   */
  Pizza updatePizza(Pizza pizza);

  /**
   * Find by id.
   *
   * @param id
   *          the id
   * @return the pizza
   */
  Pizza findById(Long id);
}
