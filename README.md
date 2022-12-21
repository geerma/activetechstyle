# Project: Active Tech Style
## By: Geer Ma, Kendall Reed, Mohamad Ebrahimi

## Steps to Run

- Start a local mySQL server and populate the database (use testerDatabase.sql and run the "INSERT INTO ensf607.product" lines only), then run the Assignment6Application.java to start the server. See next bullet for more information on starting the local mySQL server.

- NOTES: If it is the first time running the server, you would need to create a user. Run the following code within MySQL workbench.
```
drop database if exists ensf607;
create database ensf607; -- Creates the new database

-- drop user if exists 'springuser'@'%';
-- flush privileges;
create user 'springuser'@'%' identified by 'asdfghjkl'; -- Creates the user
grant all on ensf607.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database

-- grant all on ensf607.* to 'postgress'@'localhost'; -- Gives all privileges to postgress

use ensf607;
```

Afterwords, you simply need to populate the database past entry 16:
```
INSERT INTO ensf607.product (id, name, category, rating, price, image, stock_quantity, stock_location, description)
VALUES 
    (1001, "White Shirt", "style", 5, 30.99, "https://d1flfk77wl2xk4.cloudfront.net/Assets/GalleryImage/57/666/L_g0136266657.jpg", 10, "Calgary", "Wear the coolest shirt you'll ever own."),
    (1002, "Black", "style", 5, 35.99, "https://d1flfk77wl2xk4.cloudfront.net/Assets/GalleryImage/58/666/L_g0136266658.jpg", 10, "Calgary", "Soft and fashionable shirt."),
    ...
    ...
*** Execute the values to be inserted as well***
 ```

- Then cd into client and type

```npm install```

```npm run dev```
