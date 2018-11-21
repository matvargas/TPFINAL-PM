CREATE TABLE Speciality (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    type VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Doctor (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
    speciality VARCHAR (128),
    PRIMARY KEY (id),
    FOREIGN KEY (speciality) REFERENCES Speciality(type)
);

CREATE TABLE Patient (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Event_Type (
  id INTEGER NOT NULL AUTO_INCREMENT,
  type VARCHAR(128) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE Event (
  id INTEGER NOT NULL AUTO_INCREMENT,
  patient_associated INTEGER,
  doctor_associated INTEGER,
  equipment_associated INTEGER,
  type INTEGER NOT NULL,
  title VARCHAR(128) NOT NULL,
  beginDate VARCHAR(128) NOT NULL,
  endDate VARCHAR(128) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (type) REFERENCES Event_Type(id),
  FOREIGN KEY (patient_associated) REFERENCES Patient(id),
  FOREIGN KEY (doctor_associated) REFERENCES Doctor(id)
);