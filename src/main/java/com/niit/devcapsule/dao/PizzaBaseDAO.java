/*
 * 
 */
package com.niit.devcapsule.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niit.devcapsule.domain.Base;

/**
 * The Interface PizzaBaseDAO.
 */
public interface PizzaBaseDAO extends JpaRepository<Base, Long> {

  /**
   * Find by id.
   *
   * @param id
   *          the id
   * @return the base
   */
  Base findById(Long id);

  /**
   * Find by name.
   *
   * @param name
   *          the name
   * @return the base
   */
  Base findByName(String name);
}
