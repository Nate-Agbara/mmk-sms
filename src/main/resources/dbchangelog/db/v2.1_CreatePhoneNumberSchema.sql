CREATE TABLE mmk.phone_number (
  id INT NOT NULL AUTO_INCREMENT,
  number VARCHAR(40) NOT NULL,
  account_id INT NOT NULL,
  PRIMARY KEY (id));