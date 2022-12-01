drop database if exists ensf607;
create database ensf607; -- Creates the new database

-- drop user if exists 'springuser'@'%';
-- flush privileges;
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
    (1005, "Ring", "style", 5, 30.99, "https://www.davidyurman.com/on/demandware.static/-/Library-Sites-DavidYurmanSharedLibrary/default/dwd0e94ff3/images/Mens/Categories/2022/HOLIDAY/2022_HOL_Mens_Rings_Hero_Mobile.jpg", 10, "Calgary", "A ring to rule them all."),
    
    (1101, "Raptors NBA Jersey", "active", 4.7, 249.99, "https://images.footballfanatics.com/toronto-raptors/mens-mitchell-and-ness-vince-carter-purple-toronto-raptors-big-and-tall-hardwood-classics-jersey_pi3278000_ff_3278320-7f047507839c54a18579_full.jpg?_hv=2&w=340", 13, "Toronto", "Rep the 6ix!"),
    (1102, "Flames NHL Jersey", "active", 4.9, 239.99, "https://i5.walmartimages.com/asr/2c3944c4-2b8b-41d8-9cc7-ea0e1074dfcb.65dbee65027584706680df2b1c99932b.jpeg?odnHeight=450&odnWidth=450&odnBg=ffffff", 10, "Calgary", "Blasty makes his return with this beautiful jersey."),
	(1103, "Flames NHL Sweater", "active", 5, 109.99, "https://i5.walmartimages.com/asr/ce7109bc-c7a9-44af-8fa6-09d0b342ba86_1.a955d797a604ee5a214283283ff9ad8b.jpeg?odnHeight=180&odnWidth=180&odnBg=ffffff", 10, "Calgary", "Enjoy the holidays with a wonderful Flames Chrsitmas sweater!"),
	(1104, "Trailblazers NBA Jersey", "active", 4.2, 239.99, "https://static.nike.com/a/images/t_default/4a5c31ed-c90b-4d06-a3da-132f8f55e53b/portland-trail-blazers-association-edition-2022-23-dri-fit-nba-swingman-jersey-gP6N5x.png", 10, "Portland", "Rip city has never looked so good.");