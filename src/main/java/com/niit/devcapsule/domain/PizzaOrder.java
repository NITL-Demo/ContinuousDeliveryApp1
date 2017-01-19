package com.niit.devcapsule.domain;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

/**
 * The Class PizzaOrder.
 */
@Entity
public class PizzaOrder {

  /** The id. */
  @Id
  @GeneratedValue
  Long id;

  /** The pizzas. */
  @ManyToMany(targetEntity = com.niit.devcapsule.domain.Pizza.class, fetch = FetchType.LAZY)
  Set<Pizza> pizzas;

  /** The total price. */
  @NotNull
  BigDecimal totalPrice;

  /**
   * Instantiates a new pizza order.
   */
  public PizzaOrder() {
    super();
  }

  /**
   * Instantiates a new pizza order.
   *
   * @param id
   *          the id
   * @param pizzas
   *          the pizzas
   * @param totalPrice
   *          the total price
   */
  public PizzaOrder(Long id, Set<Pizza> pizzas, BigDecimal totalPrice) {
    this(pizzas, totalPrice);
    this.id = id;
  }

  /**
   * Instantiates a new pizza order.
   *
   * @param pizzas
   *          the pizzas
   * @param totalPrice
   *          the total price
   */
  public PizzaOrder(Set<Pizza> pizzas, BigDecimal totalPrice) {
    super();
    this.pizzas = pizzas;
    this.totalPrice = totalPrice;
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
   * Gets the total price.
   *
   * @return the total price
   */
  public BigDecimal getTotalPrice() {
    return totalPrice;
  }

  /**
   * Gets the pizzas.
   *
   * @return the pizzas
   */
  public Set<Pizza> getPizzas() {
    return pizzas;
  }

}
