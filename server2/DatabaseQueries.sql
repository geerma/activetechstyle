-- Part 1
SHOW TABLES;

SELECT * FROM billing;
SELECT * FROM cart;
SELECT * FROM customer;
SELECT * FROM product;
SELECT * FROM cart_contents;

-- Part 2
SELECT C.name, C.email
FROM customer as C
WHERE C.id = 501;

-- Part 3
SELECT P.name, P.price
FROM product as P
WHERE P.price > 100
ORDER BY P.price ASC;

-- Part 4
SELECT P.name, P.price
FROM product as P
HAVING P.price>
(SELECT AVG(P.price)
FROM product as P
WHERE P.price > 100);

-- Part 5
SELECT C.name, B.card_number
FROM customer as C
JOIN billing as B
	ON c.billing_id = b.id;
    
-- Part 6
UPDATE customer
SET name = "Dan Shields"
WHERE id = 501;

-- Part 7
DELETE FROM cart_contents
WHERE cart_id = 5050;