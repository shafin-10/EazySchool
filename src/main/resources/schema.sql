use EazySchoolWebApp;

CREATE TABLE IF NOT EXISTS contact_msg (
  contact_id serial  PRIMARY KEY,
 name varchar(100) NOT NULL,
 mobile_num varchar(11) NOT NULL,
  email varchar(100) NOT NULL,
  subject varchar(100) NOT NULL,
 message varchar(500) NOT NULL,
  status varchar(10) NOT NULL,
 created_at TIMESTAMP NOT NULL,
  created_by varchar(50) NOT NULL,
 updated_at TIMESTAMP DEFAULT NULL,
  updated_by varchar(50) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS holidays (
  day varchar(20) NOT NULL,
  reason varchar(100) NOT NULL,
  type varchar(20) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  created_by varchar(50) NOT NULL,
  updated_at TIMESTAMP DEFAULT NULL,
  updated_by varchar(50) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS roles (
  role_id SERIAL PRIMARY KEY,
  role_name VARCHAR(50) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  created_by VARCHAR(50) NOT NULL,
  updated_at TIMESTAMP DEFAULT NULL,
  updated_by VARCHAR(50) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS address (
  address_id SERIAL PRIMARY KEY,
  address1 VARCHAR(200) NOT NULL,
  address2 VARCHAR(200) DEFAULT NULL,
  city VARCHAR(50) NOT NULL,
  state VARCHAR(50) NOT NULL,
  zip_code INT NOT NULL,
  created_at TIMESTAMP NOT NULL,
  created_by VARCHAR(50) NOT NULL,
  updated_at TIMESTAMP DEFAULT NULL,
  updated_by VARCHAR(50) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS person (
  person_id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(50) NOT NULL,
  mobile_number VARCHAR(20) NOT NULL,
  pwd VARCHAR(200) NOT NULL,
  role_id INT NOT NULL,
  address_id INT NULL,
  created_at TIMESTAMP NOT NULL,
  created_by VARCHAR(50) NOT NULL,
  updated_at TIMESTAMP DEFAULT NULL,
  updated_by VARCHAR(50) DEFAULT NULL,
  FOREIGN KEY (role_id) REFERENCES roles(role_id),
  FOREIGN KEY (address_id) REFERENCES address(address_id)
);
