CREATE TABLE Tulaj (
	id int NOT NULL AUTO_INCREMENT,
	nev varchar(50) NOT NULL,
    cim varchar(100) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE Auto (
	id int NOT NULL AUTO_INCREMENT,
    rendszam varchar(7) NOT NULL,
    tipus varchar(50) NOT NULL,
    tulaj_id int NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT FK_TulajID FOREIGN KEY (tulaj_id) REFERENCES Tulaj(id)    
);

CREATE TABLE Muhely (
	id int NOT NULL AUTO_INCREMENT,
	nev varchar(50) NOT NULL,
    cim varchar(100) NOT NULL,
    kapacitas int NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE Szerelo (
	id int NOT NULL AUTO_INCREMENT,
	nev varchar(50) NOT NULL,
    muhely_id int NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT FK_MuhelyID FOREIGN KEY (muhely_id) REFERENCES Muhely(id) 
);

CREATE TABLE Szereles (
	id int NOT NULL AUTO_INCREMENT,
    auto_id int NOT NULL,
    muhely_id int NOT NULL,
    szerelo_id int NOT NULL,
    ar int NOT NULL,
    statusz tinyint,
    fizetve boolean,
    PRIMARY KEY(id),
    CONSTRAINT FK_SzerelesAutoID FOREIGN KEY (auto_id) REFERENCES Auto(id),
    CONSTRAINT FK_SzerelesMuhelyID FOREIGN KEY (muhely_id) REFERENCES Muhely(id),
    CONSTRAINT FK_SzerelesSzereloID FOREIGN KEY (szerelo_id) REFERENCES Szerelo(id)
);

INSERT INTO Tulaj (nev, cim)
VALUES ("Szabó Géza", "4024 Debrecen, Tóth Árpád utca 14"),
("Vass Tamás", "7940 Szentlôrinc Agip u. 97."),
("Pethe Bálint", "4085 Tedej Hegyalja út 88."),
("Szegedi Boldizsár", "9422 Harka Wesselényi u. 16."),
("Szathmár Jenci", "7800 Kisharsány Piroska u. 20."),
("Gyarmati Csanád", "7538 Kálmáncsa Eötvös út 23.");

INSERT INTO Auto (rendszam, tipus, tulaj_id)
VALUES ("ABC-123", "Opel Astra", 1),
("ABC-123", "Opel Astra", 1),
("JFP-452", "Audi A4", 2),
("SDG-341", "Skoda Octavia", 1),
("BGF-345", "Ford Mondeo", 3),
("VBN-324", "Citroen C3", 3),
("IUR-789", "Peugeot 3008", 4),
("LJG-572", "Honda Civic", 5),
("BXE-914", "Seat Ibiza", 6),
("TPG-492", "Renault Twingo", 6);

INSERT INTO Muhely
(nev, cim, kapacitas)
VALUES ("Madád szervíz", "2322 Makád Erzsébet krt. 32.", 10),
("Bonyhád autó center", "7187 Bonyhád Tas vezér u. 71.", 15);

INSERT INTO Szerelo
(nev, muhely_id)
VALUES ("Lackó Ladomér", 1),
("Lovas Ozsvát", 1),
("Seress Kund", 2),
("Sultész Tarján", 2),
("Sárközi Péter", 1);

INSERT INTO Szereles
(auto_id, muhely_id, szerelo_id, ar, statusz, fizetve)
VALUES (1, 1, 1, 240000, 0, 0),
(3, 2, 3, 200000, 0, 0),
(5, 1, 2, 140000, 0, 0);


