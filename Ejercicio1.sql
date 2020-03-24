-- Ejercicio 1
-- Obtener el nombre del menu de las ordenes con estado PAYMENT_CONFIRMED.
select menu_name from  menu where menu_id in (select menu_id from orders where order_status = "PAYMENT_CONFIRMED")