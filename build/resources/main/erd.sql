-- Creating Products table
CREATE TABLE products (
    id INT PRIMARY KEY,
    Size VARCHAR(50),
    color VARCHAR(50),
    price DECIMAL(10, 2),
    stock_quantity INT,
    image VARCHAR(255),
    attributes TEXT
);

-- Creating Customers table
CREATE TABLE customers (
    id INT PRIMARY KEY,
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    name VARCHAR(100),
    dob DATE
);

-- Creating CustomerProduct table (for the many-to-many relationship between Customers and Products)
CREATE TABLE customer_product (
    id INT PRIMARY KEY,
    id INT,
    id INT,
    FOREIGN KEY (ProductId) REFERENCES Products (ProductId),
    FOREIGN KEY (CustomerId) REFERENCES Customers (CustomerId)
);

-- Creating Orders table
CREATE TABLE orders (
    id INT PRIMARY KEY,
    total_price DECIMAL(10, 2),
    total_product_quantity INT,
    date DATE,
    delivery_type VARCHAR(50)
);

-- Creating ProductOrder table (for the many-to-many relationship between Products and Orders)
CREATE TABLE product_order (
    id INT PRIMARY KEY,
    id INT,
    id INT,
    FOREIGN KEY (ProductId) REFERENCES Products (ProductId),
    FOREIGN KEY (OrderId) REFERENCES Orders (OrdersId)
);