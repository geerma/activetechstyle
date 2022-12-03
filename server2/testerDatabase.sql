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
    (1001, "White Shirt", "style", 5, 40.99, "https://d1flfk77wl2xk4.cloudfront.net/Assets/GalleryImage/57/666/L_g0136266657.jpg", 10, "Calgary", "Wear the coolest shirt you'll ever own."),
    (1002, "Black Shirt", "style", 5, 84.99, "https://d1flfk77wl2xk4.cloudfront.net/Assets/GalleryImage/58/666/L_g0136266658.jpg", 10, "Calgary", "Soft and fashionable shirt."),
    (1003, "Sweater Vest", "style", 5, 45.99, "https://d1flfk77wl2xk4.cloudfront.net/Assets/81/232/XXL_p0136823281.jpg", 10, "Calgary", "Extremely fashionable and warm sweater vest."),
    (1004, "Beige Shirt", "style", 5, 89.99, "https://i.pinimg.com/originals/d2/ac/28/d2ac280b586d89fece41a562ae542b9e.jpg", 10, "Calgary", "Beige outfit for all your basic needs."),
    (1005, "Brown Coat", "style", 5, 300.99, "https://lh3.googleusercontent.com/SLMYuajlazF279dcoA4LHdkxKf6FuJ7KXbGnKJRiwH_dxI3OHcqxm9FG-OpMffXgoTmXw2MfZtPVzoY4GVkETXNtskWe-EyuxQ=w780-nu-rj-l80-e365", 10, "Calgary", "Brown coat that is warm and very fashionable."),
    (1006, "Watch", "style", 5, 160.99, "https://royalwrist.pk/wp-content/uploads/2022/04/FS5276.jpg", 10, "Calgary", "This watch will get you compliments!"),
    (1007, "Ring", "style", 5, 40.99, "https://www.davidyurman.com/on/demandware.static/-/Library-Sites-DavidYurmanSharedLibrary/default/dwd0e94ff3/images/Mens/Categories/2022/HOLIDAY/2022_HOL_Mens_Rings_Hero_Mobile.jpg", 10, "Calgary", "A ring to rule them all."),
    
	(1201, "Apple Mac-pro", "tech", 5, 2199.99, "https://multimedia.bbycastatic.ca/multimedia/products/500x500/157/15776/15776877.jpg", 10, "Vancouver", "Product with groundbreaking performance and amazing battery life."),
	(1202, "Google Pixel 7", "tech", 4.9, 649.99, "https://multimedia.bbycastatic.ca/multimedia/products/500x500/164/16494/16494357.jpg", 10, "Calgary", "The photo you imagined in just a tap away."),
   	(1203, "Microsoft surface", "tech", 4.7, 769.99, "https://multimedia.bbycastatic.ca/multimedia/products/500x500/161/16157/16157710.jpg", 10, "Calgary", "Boasting a powerful 11th generation Intel processor with a 4.2GHz processor speed."),
	(1204, "Samsung Galaxy S21", "tech", 4.6, 639.99, "https://multimedia.bbycastatic.ca/multimedia/products/500x500/164/16448/16448342.jpg", 10, "Calgary", "HyperFast processing speeds that lets you multitask seamlessly."),
	(1205, "ASUS ROG Strix", "tech", 4.8, 1299.99, "https://multimedia.bbycastatic.ca/multimedia/products/500x500/159/15961/15961321.jpg", 10, "Calgary", "Game with a new level of speed and graphics."),

    (1101, "Raptors NBA Jersey", "active", 4.7, 249.99, "https://images.footballfanatics.com/toronto-raptors/mens-mitchell-and-ness-vince-carter-purple-toronto-raptors-big-and-tall-hardwood-classics-jersey_pi3278000_ff_3278320-7f047507839c54a18579_full.jpg?_hv=2&w=340", 13, "Toronto", "Rep the 6ix!"),
    (1102, "Flames NHL Jersey", "active", 4.9, 239.99, "https://i5.walmartimages.com/asr/2c3944c4-2b8b-41d8-9cc7-ea0e1074dfcb.65dbee65027584706680df2b1c99932b.jpeg?odnHeight=450&odnWidth=450&odnBg=ffffff", 10, "Calgary", "Blasty makes his return with this beautiful jersey."),
	(1103, "Flames NHL Sweater", "active", 5, 109.99, "https://i5.walmartimages.com/asr/ce7109bc-c7a9-44af-8fa6-09d0b342ba86_1.a955d797a604ee5a214283283ff9ad8b.jpeg?odnHeight=180&odnWidth=180&odnBg=ffffff", 10, "Calgary", "Enjoy the holidays with a wonderful Flames Chrsitmas sweater!"),
	(1104, "Trailblazers NBA Jersey", "active", 4.2, 239.99, "https://static.nike.com/a/images/t_default/4a5c31ed-c90b-4d06-a3da-132f8f55e53b/portland-trail-blazers-association-edition-2022-23-dri-fit-nba-swingman-jersey-gP6N5x.png", 10, "Portland", "Rip city has never looked so good.");
    
