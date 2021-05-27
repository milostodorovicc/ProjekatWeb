INSERT INTO CLANFITNESCENTRA(korisnickoime, lozinka, ime, prezime, telefon, email, datumrodjenja, uloga) VALUES ('jovana', 'jovic','Jovana','Jovic','064545','jojo@gmail.com','1995-03-14','CLANFITNESCENTRA');

INSERT INTO CLANFITNESCENTRA(korisnickoime, lozinka, ime, prezime, telefon, email, datumrodjenja, uloga) VALUES ('avon', 'barksdale','Avon','Barksdale','063745','aaaa@gmail.com','1992-08-3', 'CLANFITNESCENTRA');
INSERT INTO CLANFITNESCENTRA(korisnickoime, lozinka, ime, prezime, telefon, email, datumrodjenja, uloga) VALUES ('stan', 'marsh','Stan','Marsh','062804','ssss@gmail.com','2004-07-25','CLANFITNESCENTRA');
INSERT INTO FITNESSCENTAR(naziv, adresa, brojtelefonacentrale, email) VALUES('EDUFIT','Branka Bajica','343567','edu@ssss.com');
INSERT INTO FITNESSCENTAR(naziv, adresa, brojtelefonacentrale, email) VALUES('SINERGY','Joakima Vujica','897521','sin@ssss.com');

INSERT INTO TRENING(naziv,opis,tip,trajanje ) VALUES('Vecernji','Trcanje','Kardio',30);
INSERT INTO TRENING(naziv,opis,tip,trajanje ) VALUES('Jutarnji','Istezanje','Zagrevanje',15);
INSERT INTO TRENING(naziv,opis,tip,trajanje) VALUES('Popodnevni','Teretana','Ruke',60);

INSERT INTO ADMINISTRATOR(korisnickoime, lozinka, ime, prezime, telefon, email, datumrodjenja, uloga) VALUES ('milos', 'todorovic','Milos','Todorovic','063098','mmm@gmail.com','1998-06-30','ADMINISTRATOR');




INSERT INTO SALA(kapacitet, oznaka, fitnesscentar_id) VALUES('20','300',1);
INSERT INTO SALA(kapacitet, oznaka, fitnesscentar_id) VALUES('40','310',2);
INSERT INTO SALA(kapacitet, oznaka, fitnesscentar_id) VALUES('60','320',1);
INSERT INTO SALA(kapacitet, oznaka, fitnesscentar_id) VALUES('80','330',1);
INSERT INTO SALA(kapacitet, oznaka, fitnesscentar_id) VALUES('100','340',2);

INSERT INTO TRENER(korisnickoime, lozinka, ime, prezime, telefon, email, datumrodjenja, uloga, prosecnaocena, fitnesscentar_id, aktivan) VALUES ('alex', 'ferguson','Alex','Ferguson','063467','aaaa@gmail.com','1945-03-1','TRENER','8.5',1, false);
INSERT INTO TRENER(korisnickoime, lozinka, ime, prezime, telefon, email, datumrodjenja, uloga, prosecnaocena, fitnesscentar_id, aktivan) VALUES ('jurgeen', 'klop','Jurgen','Klop','061987','jjjj@gmail.com','1965-07-1','TRENER','6.2',1, false);
INSERT INTO TRENER(korisnickoime, lozinka, ime, prezime, telefon, email, datumrodjenja, uloga, prosecnaocena,fitnesscentar_id, aktivan) VALUES ('pep', 'guardiola','Pep','Guardiola','065467','pep@gmail.com','1970-03-1','TRENER','7.5',2, true);
INSERT INTO TRENER(korisnickoime, lozinka, ime, prezime, telefon, email, datumrodjenja, uloga, prosecnaocena,fitnesscentar_id, aktivan) VALUES ('marian', 'vajda','Marian','Vajda','063456','marianvjd@gmail.com','1965-03-1','TRENER','8.5',2, false);


INSERT INTO TERMIN(datum, cena, brojprijavljenihclanova, trening_id, sala_id, trener_id, fitnesscentar_id) VALUES('2021-05-25 21:40:00', '350', '2', 2, 1,1,1 );
INSERT INTO TERMIN(datum, cena, brojprijavljenihclanova, trening_id, sala_id, trener_id, fitnesscentar_id) VALUES('2021-05-25 22:40:00', '500', '5', 1, 3,2,1 );
INSERT INTO TERMIN(datum, cena, brojprijavljenihclanova, trening_id, sala_id, trener_id, fitnesscentar_id) VALUES('2021-05-25 11:40:00', '350', '2', 2, 5,3,2 );
INSERT INTO TERMIN(datum, cena, brojprijavljenihclanova, trening_id, sala_id, trener_id, fitnesscentar_id) VALUES('2021-05-26 11:40:00', '350', '2', 3, 5,4,2 );
INSERT INTO ODRADJENTRENING(clan_id, termin_id) VALUES(1,1);
INSERT INTO ODRADJENTRENING(clan_id, termin_id) VALUES(2,3);
INSERT INTO ODRADJENTRENING(clan_id, termin_id) VALUES(3,2);
INSERT INTO REZERVISANTRENING(clan_id, termin_id) VALUES(1,2);
INSERT INTO REZERVISANTRENING(clan_id, termin_id) VALUES(2,1);
INSERT INTO OCENJENTRENING(termin_id, ocena, clan_id) VALUES(1,'9',1);
INSERT INTO OCENJENTRENING(termin_id, ocena, clan_id) VALUES(2, '7',3);
INSERT INTO OCENJENTRENING(termin_id, ocena, clan_id) VALUES(3, '8',2);
