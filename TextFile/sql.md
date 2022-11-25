DROP TABLE IF EXISTS persons;
DROP TABLE IF EXISTS contacts;
DROP TABLE IF EXISTS roles;

CREATE TABLE roles(
   role_id INT GENERATED ALWAYS AS IDENTITY,
   person_id INT,
   role_name VARCHAR(255) NOT NULL,
   PRIMARY KEY(role_id)
);

CREATE TABLE persons(
   person_id INT GENERATED ALWAYS AS IDENTITY,
   role_id INT,
   first_name VARCHAR(255) NOT NULL,
   middle_name VARCHAR(255) NOT NULL,
   last_name VARCHAR(255) NOT NULL,
   suffix VARCHAR(255),
   title VARCHAR(255) NOT NULL,
   street_no INT NOT NULL,
   barangay VARCHAR(255) NOT NULL,
   city VARCHAR(255) NOT NULL, 
   zipcode INT NOT NULL,
   PRIMARY KEY(person_id),
	CONSTRAINT fk_role
      FOREIGN KEY(role_id) 
	  REFERENCES roles(role_id)
);

ALTER TABLE roles
ADD CONSTRAINT fk_person
FOREIGN KEY (person_id) REFERENCES persons(person_id);

CREATE TABLE contacts(
   contact_id INT GENERATED ALWAYS AS IDENTITY,
   person_id INT,
   landline float NOT NULL,
   mobile_number float NOT NULL,
   email VARCHAR(100),
   PRIMARY KEY(contact_id),
	CONSTRAINT fk_person
      FOREIGN KEY(person_id) 
	  REFERENCES persons(person_id)
);
