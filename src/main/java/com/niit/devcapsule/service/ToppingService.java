/*
 * 
 */
package com.niit.devcapsule.service;

import java.util.List;

import com.niit.devcapsule.domain.Topping;

/**
 * The Interface ToppingService.
 */
public interface ToppingService {

  /**
   * Find all.
   *
   * @return the list
   */
  List<Topping> findAll();

  /**
   * Find by name.
   *
   * @param name
   *          the name
   * @return the topping
   */
  Topping findByName(String name);

  /**
   * Find by id.
   *
   * @param id
   *          the id
   * @return the topping
   */
  Topping findById(Long id);

  /**
   * Adds the topping.
   *
   * @param name
   *          the name
   * @return the topping
   */
  Topping addTopping(String name);
}
