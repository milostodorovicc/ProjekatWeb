INSERT INTO CLANFITNESCENTRA(korisnickoime, lozinka, ime, prezime, telefon, email, datumrodjenja, uloga) VALUES ('jovana', 'jovic','Jovana','Jovic','064545','jojo@gmail.com','1995-03-14','CLANFITNESCENTRA');

INSERT INTO CLANFITNESCENTRA(korisnickoime, lozinka, ime, prezime, telefon, email, datumrodjenja, uloga) VALUES ('avon', 'barksdale','Avon','Barksdale','063745','aaaa@gmail.com','1992-08-3', 'CLANFITNESCENTRA');
INSERT INTO CLANFITNESCENTRA(korisnickoime, lozinka, ime, prezime, telefon, email, datumrodjenja, uloga) VALUES ('stan', 'marsh','Stan','Marsh','062804','ssss@gmail.com','2004-07-25','CLANFITNESCENTRA');
INSERT INTO FITNESSCENTAR(naziv, adresa, brojtelefonacentrale, email, aktivan) VALUES('EDUFIT','Branka Bajica','343567','edu@ssss.com', TRUE);
INSERT INTO FITNESSCENTAR(naziv, adresa, brojtelefonacentrale, email, aktivan) VALUES('SINERGY','Joakima Vujica','897521','sin@ssss.com', TRUE);

INSERT INTO TRENING(naziv,opis,tip,trajanje ) VALUES('Vecernji','Trcanje','Kardio',30);
INSERT INTO TRENING(naziv,opis,tip,trajanje ) VALUES('Jutarnji','Istezanje','Zagrevanje',15);
INSERT INTO TRENING(naziv,opis,tip,trajanje) VALUES('Popodnevni','Teretana','Ruke',60);

INSERT INTO ADMINISTRATOR(korisnickoime, lozinka, ime, prezime, telefon, email, datumrodjenja, uloga) VALUES ('milos', 'todorovic','Milos','Todorovic','063098','mmm@gmail.com','1998-06-30','ADMINISTRATOR');




INSERT INTO SALA(kapacitet, oznaka, fitnesscentar_id,aktivan) VALUES('20','300',1, TRUE);
INSERT INTO SALA(kapacitet, oznaka, fitnesscentar_id,aktivan) VALUES('40','310',2, TRUE);
INSERT INTO SALA(kapacitet, oznaka, fitnesscentar_id,aktivan) VALUES('60','320',1, TRUE);
INSERT INTO SALA(kapacitet, oznaka, fitnesscentar_id, aktivan) VALUES('80','330',1, TRUE);
INSERT INTO SALA(kapacitet, oznaka, fitnesscentar_id, aktivan) VALUES('100','340',2, TRUE);

INSERT INTO TRENER(korisnickoime, lozinka, ime, prezime, telefon, email, datumrodjenja, uloga, prosecnaocena, fitnesscentar_id, aktivan, n) VALUES ('alex', 'ferguson','Alex','Ferguson','063467','aaaa@gmail.com','1945-03-1','TRENER','8.0',1, false,1);
INSERT INTO TRENER(korisnickoime, lozinka, ime, prezime, telefon, email, datumrodjenja, uloga, prosecnaocena, fitnesscentar_id, aktivan, n) VALUES ('jurgeen', 'klop','Jurgen','Klop','061987','jjjj@gmail.com','1965-07-1','TRENER','8.0',1, false,1);
INSERT INTO TRENER(korisnickoime, lozinka, ime, prezime, telefon, email, datumrodjenja, uloga, prosecnaocena,fitnesscentar_id, aktivan, n) VALUES ('pep', 'guardiola','Pep','Guardiola','065467','pep@gmail.com','1970-03-1','TRENER','5.0',2, true,1);
INSERT INTO TRENER(korisnickoime, lozinka, ime, prezime, telefon, email, datumrodjenja, uloga, prosecnaocena,fitnesscentar_id, aktivan, n) VALUES ('marian', 'vajda','Marian','Vajda','063456','marianvjd@gmail.com','1965-03-1','TRENER','6.0',2, false,1);


INSERT INTO TERMIN(datum, cena, brojprijavljenihclanova, trening_id, sala_id, trener_id, fitnesscentar_id, aktivan) VALUES('2021-06-25T21:40:00', '350', '2', 2, 1,1,1, TRUE );
INSERT INTO TERMIN(datum, cena, brojprijavljenihclanova, trening_id, sala_id, trener_id, fitnesscentar_id, aktivan) VALUES('2021-06-26T22:40:00', '500', '5', 1, 3,2,1, TRUE );
INSERT INTO TERMIN(datum, cena, brojprijavljenihclanova, trening_id, sala_id, trener_id, fitnesscentar_id, aktivan) VALUES('2021-07-24T11:30:00', '350', '2', 2, 5,3,2, TRUE );
INSERT INTO TERMIN(datum, cena, brojprijavljenihclanova, trening_id, sala_id, trener_id, fitnesscentar_id, aktivan) VALUES('2021-07-26T11:40:00', '350', '2', 3, 5,4,2, TRUE );
INSERT INTO TERMIN(datum, cena, brojprijavljenihclanova, trening_id, sala_id, trener_id, fitnesscentar_id, aktivan) VALUES('2021-06-12T11:30:00', '350', '4', 2, 5,3,1, TRUE );
INSERT INTO TERMIN(datum, cena, brojprijavljenihclanova, trening_id, sala_id, trener_id, fitnesscentar_id, aktivan) VALUES('2021-06-21T11:40:00', '350', '5', 3, 5,4,2, TRUE );

INSERT INTO ODRADJENTRENING(clan_id, termin_id) VALUES(1,1);
INSERT INTO ODRADJENTRENING(clan_id, termin_id) VALUES(1,2);
INSERT INTO ODRADJENTRENING(clan_id, termin_id) VALUES(2,1);
INSERT INTO ODRADJENTRENING(clan_id, termin_id) VALUES(2,2);
INSERT INTO ODRADJENTRENING(clan_id, termin_id) VALUES(3,2);
INSERT INTO ODRADJENTRENING(clan_id, termin_id) VALUES(3,1);
INSERT INTO ODRADJENTRENING(clan_id, termin_id) VALUES(1,5);
INSERT INTO ODRADJENTRENING(clan_id, termin_id) VALUES(2,6);


INSERT INTO REZERVISANTRENING(clan_id, termin_id) VALUES(1,3);
INSERT INTO REZERVISANTRENING(clan_id, termin_id) VALUES(2,3);
INSERT INTO OCENJENTRENING(termin_id, ocena, clan_id) VALUES(1,'9' ,1);
INSERT INTO OCENJENTRENING(termin_id, ocena, clan_id) VALUES(2,'8' ,2);
INSERT INTO OCENJENTRENING(termin_id, ocena, clan_id) VALUES(1,'7',3);
INSERT INTO OCENJENTRENING(termin_id, ocena, clan_id) VALUES(2,NULL ,1);
INSERT INTO OCENJENTRENING(termin_id, ocena, clan_id) VALUES(1,NULL ,2);
INSERT INTO OCENJENTRENING(termin_id, ocena, clan_id) VALUES(2,NULL,3);
INSERT INTO OCENJENTRENING(termin_id, ocena, clan_id) VALUES(5,'5' ,1);
INSERT INTO OCENJENTRENING(termin_id, ocena, clan_id) VALUES(6,'6',2);


