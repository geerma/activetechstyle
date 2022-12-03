-- Database Queries by Kendall, Mike, and Geer

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
DROP TRIGGER IF EXISTS update_price_trigger;
DELIMITER $$
CREATE TRIGGER update_price_trigger  
BEFORE UPDATE
ON product
FOR EACH ROW
BEGIN
IF (NEW.price < 0) THEN
	SET NEW.price = ABS(NEW.price);
	END IF;
END$$
DELIMITER ;

UPDATE product
SET price = -99.99
WHERE id = 1001;

SELECT * FROM product WHERE id = 1001;

-- Part 7
DROP TRIGGER IF EXISTS delete_cart_trigger;
DELIMITER $$
CREATE TRIGGER delete_cart_trigger  
BEFORE DELETE
ON cart
FOR EACH ROW
BEGIN
		DELETE FROM cart_contents 
        WHERE cart_id = OLD.id;
END$$
DELIMITER ;

SELECT * FROM cart_contents WHERE cart_id=5052;

DELETE FROM cart
WHERE id = 5052;

SELECT * FROM cart_contents WHERE cart_id=5052;