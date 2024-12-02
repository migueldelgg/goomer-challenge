CREATE TABLE category (
    id UUID PRIMARY KEY,
    name VARCHAR NOT NULL,
    product_id UUID NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_product_category FOREIGN KEY (product_id) REFERENCES product (id)
);