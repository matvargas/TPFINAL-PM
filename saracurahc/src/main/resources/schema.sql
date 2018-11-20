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