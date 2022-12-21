CREATE TABLE IF NOT EXISTS ebdb.billing(
	id					bigint not null,
    card_number			bigint,
    cvc_number 			int,
    expiry_date 		date,
    primary key (id)
);
CREATE TABLE IF NOT EXISTS ebdb.cart(
	id 					bigint not null,
    purchase_date		date,
    status				varchar(255),
    total_pay			decimal(19,2),
    customer_id 		bigint,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS ebdb.cart_contents(
	cart_id 			bigint not null,
    product_id			bigint not null,
    primary key (cart_id, product_id)
);

CREATE TABLE IF NOT EXISTS ebdb.customer(
	id 					bigint not null,
	email 				varchar(255),
	name 				varchar(255),
	password 			varchar(255),
	billing_id 			bigint,
	primary key (id)
);

CREATE TABLE IF NOT EXISTS ebdb.product(
	id 					bigint not null,
	category 			varchar(255),
	description 		varchar(255),
	image 				varchar(255),
	name 				varchar(255),
	price 				decimal(19,2),
	rating 				double precision,
	stock_location 		varchar(255),
	stock_quantity 		integer,
	primary key (id)
);
