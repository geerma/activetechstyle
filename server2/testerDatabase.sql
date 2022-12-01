drop database if exists ensf607;
create database ensf607; -- Creates the new database

drop user if exists 'springuser'@'%';
flush privileges;
create user 'springuser'@'%' identified by 'asdfghjkl'; -- Creates the user
grant all on ensf607.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database

-- grant all on ensf607.* to 'postgress'@'localhost'; -- Gives all privileges to postgress

use ensf607;
SHOW TABLES;

-- adding products into ensf607.product

INSERT INTO ensf607.product (id, name, category, rating, price, image, stock_quantity, stock_location, description)
VALUES 
    (1001, "White Shirt", "style", 5, 30.99, "https://d1flfk77wl2xk4.cloudfront.net/Assets/GalleryImage/57/666/L_g0136266657.jpg", 10, "Calgary", "Wear the coolest shirt you'll ever own."),
    (1002, "Black", "style", 5, 35.99, "https://d1flfk77wl2xk4.cloudfront.net/Assets/GalleryImage/58/666/L_g0136266658.jpg", 10, "Calgary", "Soft and fashionable shirt."),
    (1003, "Sweater Vest", "style", 5, 32.99, "https://d1flfk77wl2xk4.cloudfront.net/Assets/81/232/XXL_p0136823281.jpg", 10, "Calgary", "Extremely fashionable and warm sweater vest"),
    (1004, "Watch", "style", 5, 120.99, "https://royalwrist.pk/wp-content/uploads/2022/04/FS5276.jpg", 10, "Calgary", "This watch will get you compliments!"),
    (1005, "Ring", "style", 5, 30.99, "https://www.davidyurman.com/on/demandware.static/-/Library-Sites-DavidYurmanSharedLibrary/default/dwd0e94ff3/images/Mens/Categories/2022/HOLIDAY/2022_HOL_Mens_Rings_Hero_Mobile.jpg", 10, "Calgary", "A ring to rule them all.");