/*
 * 
 */
package com.niit.devcapsule.service;

import java.util.List;

import com.niit.devcapsule.domain.Base;

/**
 * The Interface PizzaBaseService.
 */
public interface PizzaBaseService {
  /**
   * Method findAll.
   * 
   * @return List<Base>
   */
  List<Base> findAll();

  /**
   * Method findByName.
   * 
   * @param name
   *          String
   * @return Base
   */
  Base findByName(String name);

  /**
   * Method findById.
   * 
   * @param id
   *          Long
   * @return Base
   */
  Base findById(Long id);

  /**
   * Method addBase.
   * 
   * @param name
   *          String
   * @return Base
   */
  Base addBase(String name);
}
