CREATE TABLE role
(   id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(150) NOT NULL
);

CREATE TABLE user
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    role_id INT NOT NULL ,
    name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    FOREIGN KEY (role_id) REFERENCES role (id)
);

