package com.niit.devcapsule.service;

import java.util.List;

import com.niit.devcapsule.domain.PizzaOrder;

/**
 * The Interface PizzaOrderService.
 */
public interface PizzaOrderService {

  /**
   * Find all.
   *
   * @return the list
   */
  List<PizzaOrder> findAll();

  /**
   * Adds the order.
   *
   * @param pizzaOrder
   *          the pizza order
   * @return the pizza order
   */
  PizzaOrder addOrder(PizzaOrder pizzaOrder);

  /**
   * Update order.
   *
   * @param pizzaOrder
   *          the pizza order
   * @return the pizza order
   */
  PizzaOrder updateOrder(PizzaOrder pizzaOrder);

  /**
   * Delete order.
   *
   * @param id
   *          the id
   */
  void deleteOrder(Long id);

  /**
   * Find by id.
   *
   * @param id
   *          the id
   * @return the pizza order
   */
  PizzaOrder findById(Long id);
}
