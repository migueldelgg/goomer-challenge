CREATE TABLE shift (
    id UUID PRIMARY KEY,
    dayofweek VARCHAR NOT NULL,
    start TIME NOT NULL,
    duration INTEGER NOT NULL,
    restaurant_id UUID NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_restaurant_shift FOREIGN KEY (restaurant_id) REFERENCES restaurant (id)
);