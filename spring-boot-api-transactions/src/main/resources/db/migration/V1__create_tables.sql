CREATE TABLE accounts (
      id INT NOT NULL AUTO_INCREMENT,
      name VARCHAR(50) NOT NULL,
      balance DECIMAL(10, 2) NOT NULL DEFAULT 0,
      PRIMARY KEY (id)
);