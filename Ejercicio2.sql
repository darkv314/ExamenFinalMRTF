-- Ejercicio 2
-- Mostrar los nombres de los clientes donde su tarjeta de credito termine en la palabra 'ton'
select first_name from customer where customer_id in (SELECT distinct customer_id from payment_details where SUBSTRING(card_holder_name, char_length(card_holder_name)-2 , 3) = "ton")