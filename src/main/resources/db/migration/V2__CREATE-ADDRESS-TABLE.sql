CREATE TABLE address (
    id UUID PRIMARY KEY,
    address VARCHAR NOT NULL,
    addressComplement VARCHAR,
    city VARCHAR NOT NULL,
    state VARCHAR NOT NULL,
    country VARCHAR NOT NULL,
    zipcode VARCHAR NOT NULL,
    restaurant_id UUID UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_restaurant_address FOREIGN KEY (restaurant_id) REFERENCES restaurant (id)
);