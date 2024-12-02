CREATE TABLE product (
    id UUID PRIMARY KEY,
    name VARCHAR NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    photo VARCHAR,
    restaurant_id UUID NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_restaurant_product FOREIGN KEY (restaurant_id) REFERENCES restaurant (id)
);