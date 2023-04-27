CREATE TABLE sales VALUES(
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity_sold INT NOT NULL,
    date DATE,
    hour TIME,
    price DECIMAL (10,2),
    FOREIGN KEY(user_id) REFERENCES user(id),
    FOREIGN KEY(product_id) REFERENCES product(id),
);