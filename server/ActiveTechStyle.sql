
DROP DATABASE IF EXISTS ACTIVETECHSTYLE;
CREATE DATABASE ACTIVETECHSTYLE; 
USE ACTIVETECHSTYLE;


DROP TABLE IF EXISTS CATEGORY;
CREATE TABLE CATEGORY (
	CategoryName					varchar(30)	not null,
	CategoryID			        integer not null,
	PRIMARY KEY (CategoryID)
);

INSERT INTO CATEGORY (CategoryName, CategoryID)
VALUES
('Active', '1') ,
('Tech', '2') ,
('Style', '3') ;



DROP TABLE IF EXISTS PRODUCT;
CREATE TABLE PRODUCT (
	ProductName				varchar(30)	not null,
	ProductID			    integer not null,
    Category				integer,
    Rating					integer,
    Price					double not null,
    Image                   varchar(50) not null,
    StockQuantity           integer not null,
	StockLocation			varchar(50) not null,
	PRIMARY KEY (ProductID),
    FOREIGN Key (Category) REFERENCES CATEGORY (CategoryID)
);

INSERT INTO PRODUCT (ProductName, ProductID, Category, Rating, Price, Image, StockQuantity, StockLocation)
VALUES
('Google Pixle 7', '234789', '1', '4', '649.99', '...', '10', 'AB T2N 1N4') ,
('MacBook Pro 14', '124869', '1', '5', '1599.99', '...', '8', 'AB T2N 1N4') ,
('Beats Solo', '157257', '1', '4', '249.99', '...', '15', 'AB T2N 1N4') ;



DROP TABLE IF EXISTS BILLING;
CREATE TABLE BILLING (
	CardNumber	        		varbinary(16) not null,
	CVCNumber     			    integer not null,
    ExpirayMonth				integer not null,
	ExpirayYear				    integer not null CHECK(ExpirayYear>22),
    PRIMARY KEY (CardNumber)
);

INSERT INTO BILLING (CardNumber, CVCNumber, ExpirayMonth, ExpirayYear)
VALUES
('0123456701234567', '123', '02', '25') ;



DROP TABLE IF EXISTS CUSTOMER;
CREATE TABLE CUSTOMER (
	CustomerName			varchar(30)	not null,
	CustomerID			    integer not null,
    Email				    varchar(50) not null Unique,
    Password            	varchar(10) not null,
    Card                    varbinary(16),
	PRIMARY KEY (CustomerID),
    FOREIGN Key (Card) REFERENCES BILLING (CardNumber)
);

INSERT INTO CUSTOMER (CustomerName, CustomerID, Email, Password, Card)
VALUES
('mike ebrahimi', '234789', 'mike223@ucalgary.ca', 'uys#@42', '0123456701234567') ;



DROP TABLE IF EXISTS PURCHASEHISTORY;
CREATE TABLE PURCHASEHISTORY (
	PurchaseID	        		integer	not null,
	TotalPayed     			    double not null,
    PurchaseDate				date not null,
	ProductID	                integer not null,
    Buyer                       integer,
    PRIMARY KEY (PurchaseID),
    FOREIGN Key (Buyer) REFERENCES CUSTOMER (CustomerID)
);

INSERT INTO PURCHASEHISTORY (PurchaseID, TotalPayed, PurchaseDate, ProductID, Buyer)
VALUES
('54', '700.56', '2022-09-15', '234789', '234789') ,
('55', '352.52', '2022-09-15', '124869', '234789') ;






