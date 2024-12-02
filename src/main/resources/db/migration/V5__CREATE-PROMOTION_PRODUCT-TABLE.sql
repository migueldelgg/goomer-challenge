CREATE TABLE promotion_product (
    id UUID PRIMARY KEY,
    product_id UUID NOT NULL,
    description VARCHAR,
    promotional_price DECIMAL(10, 2) NOT NULL,
    dayofweek VARCHAR NOT NULL,
    start TIME NOT NULL,
    duration INTEGER NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_product_promotion FOREIGN KEY (product_id) REFERENCES product (id)
);