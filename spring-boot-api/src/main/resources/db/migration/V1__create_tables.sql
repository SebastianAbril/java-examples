CREATE TABLE customer
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE customer_order
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT         NOT NULL,
    product     VARCHAR(50) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);