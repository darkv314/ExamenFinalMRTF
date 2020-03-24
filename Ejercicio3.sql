-- Ejercicio 3
-- Contar el numero de pagos con efectivo del cliente max
select count(id) as nP from payment where payment_type = "CASH_ON_DELIVERY" and order_id in (select order_id from orders where customer_id in (select customer_id from customer where first_name = "max"))