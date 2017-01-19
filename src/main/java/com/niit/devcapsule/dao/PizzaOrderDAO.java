/*
 * 
 */
package com.niit.devcapsule.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niit.devcapsule.domain.PizzaOrder;

/**
 * The Interface PizzaDAO.
 */
public interface PizzaOrderDAO extends JpaRepository<PizzaOrder, Long> {
  /**
   * Find by id.
   *
   * @param id
   *          the id
   * @return the Pizza Order
   */
  PizzaOrder findById(Long id);
}
