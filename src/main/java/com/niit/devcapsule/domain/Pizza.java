/*
 * 
 */
package com.niit.devcapsule.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The Class Pizza.
 */
@Entity
public class Pizza {

  /** The id. */
  @Id
  @GeneratedValue
  Long id;

  /** The name. */
  @NotNull
  @Size(min = 2)
  String name;

  /** The price. */
  @NotNull
  BigDecimal price;

  /** The base. */
  @ManyToOne
  @NotNull
  Base base;

  /** The toppings. */
  @ManyToMany(targetEntity = com.niit.devcapsule.domain.Topping.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  Set<Topping> toppings = new HashSet<Topping>();

  /**
   * Instantiates a new pizza.
   */
  public Pizza() {
    super();
  }

  /**
   * Instantiates a new pizza.
   *
   * @param id
   *          the id
   * @param name
   *          the name
   * @param price
   *          the price
   * @param base
   *          the base
   */
  public Pizza(Long id, String name, BigDecimal price, Base base) {
    super();
    this.id = id;
    this.name = name;
    this.price = price;
    this.base = base;
  }

  /**
   * Instantiates a new pizza.
   *
   * @param id
   *          the id
   * @param name
   *          the name
   * @param price
   *          the price
   * @param base
   *          the base
   * @param toppings
   *          the toppings
   */
  public Pizza(Long id, String name, BigDecimal price, Base base, Set<Topping> toppings) {
    this(id, name, price, base);
    this.toppings = toppings;
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

  /**
   * Gets the price.
   *
   * @return the price
   */
  public BigDecimal getPrice() {
    return price;
  }

  /**
   * Sets the price.
   *
   * @param price
   *          the new price
   */
  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  /**
   * Gets the base.
   *
   * @return the base
   */
  public Base getBase() {
    return base;
  }

  /**
   * Sets the base.
   *
   * @param base
   *          the new base
   */
  public void setBase(Base base) {
    this.base = base;
  }

  /**
   * Gets the toppings.
   *
   * @return the toppings
   */
  public Set<Topping> getToppings() {
    return toppings;
  }

  /**
   * Sets the toppings.
   *
   * @param toppings
   *          the new toppings
   */
  public void setToppings(Set<Topping> toppings) {
    this.toppings = toppings;
  }

}
