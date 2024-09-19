1. SQL statements
a. List all the customer names who do not have any single order.

SELECT
c.contact_name,
COUNT(o.orderID) AS Orders
FROM
customer c
LEFT JOIN
Orders o ON c.customer_id = o.customer_id
GROUP BY
c.contact_name
HAVING
Orders = 0;

+---------------+--------+
| contact_name  | Orders |
+---------------+--------+
| Ryan Giggs    |      0 |
| Alex Ferguson |      0 |
+---------------+--------+
2 rows in set (0.01 sec)

c. For each customer, display the number of orders with the order date in the year of 1998.

SELECT c.contact_name AS ContactName,      
COUNT(*) AS Orders 
FROM Orders o JOIN customer c ON o.customer_id = c.customer_id 
WHERE o.order_date BETWEEN '1998-01-01' AND '1998-12-31' 
GROUP BY c.contact_name 
ORDER BY Orders DESC;
+--------------------+--------+
| ContactName        | Orders |
+--------------------+--------+
| Jose Pavarotti     |     13 |
| Maria Larsson      |      9 |
| Roland Mendel      |      9 |
| Elizabeth Lincoln  |      8 |
| Horst Kloss        |      8 |
| Felipe Izquierdo   |      7 |
| José Pedro Freyre  |      7 |
| Mario Pontes       |      7 |
| Carlos Hernández   |      6 |
| Laurence Lebihan   |      6 |
| David Koh          |      4 |
| William Chan       |      4 |
| Ben Goh            |      1 |
+--------------------+--------+
13 rows in set (0.01 sec)

