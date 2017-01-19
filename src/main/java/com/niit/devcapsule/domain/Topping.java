/*
 * 
 */
package com.niit.devcapsule.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The Class Topping.
 */
@Entity
public class Topping {

  /** The id. */
  @Id
  @GeneratedValue
  Long id;

  /** The name. */
  @NotNull
  @Size(min = 2)
  String name;

  /**
   * Instantiates a new topping.
   */
  public Topping() {
    super();
  }

  /**
   * Instantiates a new topping.
   *
   * @param id
   *          the id
   * @param name
   *          the name
   */
  public Topping(Long id, String name) {
    super();
    this.id = id;
    this.name = name;
  }

  /**
   * Instantiates a new topping.
   *
   * @param id
   *          the id
   */
  public Topping(Long id) {
    super();
    this.id = id;
  }

  /**
   * Instantiates a new topping.
   *
   * @param name
   *          the name
   */
  public Topping(String name) {
    super();
    this.name = name;
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id
   *          the new id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   *
   * @param name
   *          the new name
   */
  public void setName(String name) {
    this.name = name;
  }

}
