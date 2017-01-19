INSERT INTO base(id, name)
     VALUES (1, 'Pan');

INSERT INTO base(id, name)
     VALUES (2, 'Thick');

INSERT INTO base(id, name)
     VALUES (3, 'Crusty');

INSERT INTO base(id, name)
     VALUES (4, 'Normal');

INSERT INTO base(id, name)
     VALUES (5, 'Cheesy');

COMMIT;


INSERT INTO topping(id, name)
     VALUES (1, 'Onion');

INSERT INTO topping(id, name)
     VALUES (2, 'Capsicum');

INSERT INTO topping(id, name)
     VALUES (3, 'Jalapenos');

INSERT INTO topping(id, name)
     VALUES (4, 'Tomato');

INSERT INTO topping(id, name)
     VALUES (5, 'Olives');

COMMIT;

INSERT INTO pizza(id,
                  name,
                  price,
                  base_id)
     VALUES (1,
             'Veggie Delight',
             1234.00,
             1);

INSERT INTO pizza(id,
                  name,
                  price,
                  base_id)
     VALUES (2,
             'Veggie Supreme',
             2234.00,
             2);

INSERT INTO pizza(id,
                  name,
                  price,
                  base_id)
     VALUES (3,
             'Veggie Excellent',
             1500.00,
             3);

INSERT INTO pizza(id,
                  name,
                  price,
                  base_id)
     VALUES (4,
             'Veggie Simple',
             534.00,
             2);

COMMIT;

INSERT INTO pizza_toppings(pizza_id, toppings_id)
     VALUES (1, 1);

INSERT INTO pizza_toppings(pizza_id, toppings_id)
     VALUES (2, 1);

INSERT INTO pizza_toppings(pizza_id, toppings_id)
     VALUES (3, 1);

INSERT INTO pizza_toppings(pizza_id, toppings_id)
     VALUES (4, 1);

INSERT INTO pizza_toppings(pizza_id, toppings_id)
     VALUES (2, 2);

COMMIT;

INSERT INTO pizza_order(id, total_price)
     VALUES (1, 1234.00);

INSERT INTO pizza_order(id, total_price)
     VALUES (2, 1234.00);

INSERT INTO pizza_order(id, total_price)
     VALUES (3, 1234.00);

INSERT INTO pizza_order(id, total_price)
     VALUES (4, 1234.00);

INSERT INTO pizza_order(id, total_price)
     VALUES (5, 2234.00);

COMMIT;

INSERT INTO pizza_order_pizzas(pizza_order_id, pizzas_id)
     VALUES (1, 1);

INSERT INTO pizza_order_pizzas(pizza_order_id, pizzas_id)
     VALUES (2, 1);

INSERT INTO pizza_order_pizzas(pizza_order_id, pizzas_id)
     VALUES (3, 1);

INSERT INTO pizza_order_pizzas(pizza_order_id, pizzas_id)
     VALUES (4, 1);

INSERT INTO pizza_order_pizzas(pizza_order_id, pizzas_id)
     VALUES (5, 1);

COMMIT;

