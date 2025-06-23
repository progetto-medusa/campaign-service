CREATE TABLE IF NOT EXISTS campaign (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL,
    is_private BOOLEAN,
    password VARCHAR(50),
    description VARCHAR(500) NOT NULL,
    rule_version VARCHAR(20) NOT NULL,
    update_date VARCHAR(100) NOT NULL,
    insert_date VARCHAR(30) NOT NULL,
    application_id VARCHAR(30)
);