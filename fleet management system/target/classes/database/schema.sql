CREATE TABLE vehicles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    status VARCHAR(50),
    latitude DOUBLE,
    longitude DOUBLE
);

CREATE TABLE routes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    start_location VARCHAR(100),
    end_location VARCHAR(100),
    distance DOUBLE
);

CREATE TABLE maintenance_records (
    id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_id INT,
    description VARCHAR(255),
    date DATE,
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(id)
);
