

INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');

              
INSERT INTO `test`.`banka` (`id`, `naziv`, `sredstva_banke`) VALUES ('1', 'Komercijalna', '15000');
INSERT INTO `test`.`banka` (`id`, `naziv`, `sredstva_banke`) VALUES ('2', 'Erste', '90000');
INSERT INTO `test`.`banka` (`id`, `naziv`, `sredstva_banke`) VALUES ('3', 'Postanska stedionica', '25000');


INSERT INTO `test`.`tip_racuna` (`id`, `naziv`, `provizija`, `banka_id`) VALUES ('1', 'Standard', '10', '1');
INSERT INTO `test`.`tip_racuna` (`id`, `naziv`, `provizija`, `banka_id`) VALUES ('2', 'Basic', '15', '2');
INSERT INTO `test`.`tip_racuna` (`id`, `naziv`, `provizija`, `banka_id`) VALUES ('3', 'Premium', '5', '3');


INSERT INTO `test`.`racun` (`id`, `broj_racuna`, `ime_prezime`, `jmbg`, `stanje_racuna`, `banka_id`, `tip_racuna_id`) VALUES ('1', '340-159263', 'Marko Markovic', '11223366554', '0', '1', '1');
INSERT INTO `test`.`racun` (`id`, `broj_racuna`, `ime_prezime`, `jmbg`, `stanje_racuna`, `banka_id`, `tip_racuna_id`) VALUES ('2', '150-159847', 'Suzana Milosevic', '15984723659', '3500', '1', '2');
INSERT INTO `test`.`racun` (`id`, `broj_racuna`, `ime_prezime`, `jmbg`, `stanje_racuna`, `banka_id`, `tip_racuna_id`) VALUES ('3', '280-351248', 'Kosta Petrovic', '15963254859', '10050', '3', '1');
INSERT INTO `test`.`racun` (`id`, `broj_racuna`, `ime_prezime`, `jmbg`, `stanje_racuna`, `banka_id`, `tip_racuna_id`) VALUES ('4', '740-253658', 'Ruzica Mitrovic', '12365478956', '7500', '2', '2');
INSERT INTO `test`.`racun` (`id`, `broj_racuna`, `ime_prezime`, `jmbg`, `stanje_racuna`, `banka_id`, `tip_racuna_id`) VALUES ('5', '190-255536', 'Tijana Pesic', '15962355852', '550000', '3', '3');


