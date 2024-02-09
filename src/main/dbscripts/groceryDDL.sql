create database grocery;
use grocery;
#drop table grocery_item;
CREATE TABLE grocery_item (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    price DOUBLE,
    quantity INT,
    PRIMARY KEY (id)
);
CREATE TABLE order_history (
    order_id BIGINT NOT NULL AUTO_INCREMENT,
    total_amount DOUBLE,
    PRIMARY KEY (order_id)
);

CREATE TABLE grocery_order (
    id BIGINT NOT NULL AUTO_INCREMENT,
    item_id BIGINT,
    quantity INT,
    order_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (item_id) REFERENCES grocery_item(id),
    FOREIGN KEY (order_id) REFERENCES order_history(order_id)
);
commit;

#show tables;
select * from grocery_item;
select * from grocery_order;
select * from order_history;