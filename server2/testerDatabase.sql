drop database if exists ensf607;
create database ensf607; -- Creates the new database

drop user if exists 'springuser'@'%';
flush privileges;
create user 'springuser'@'%' identified by 'asdfghjkl'; -- Creates the user
grant all on ensf607.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database

-- grant all on ensf607.* to 'postgress'@'localhost'; -- Gives all privileges to postgress

use ensf607;
SHOW TABLES;