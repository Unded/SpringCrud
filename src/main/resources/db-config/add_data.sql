INSERT INTO contact (first_name, last_name, birth_date) VALUES ('Chris', 'Fisher', '1981-05-03');
INSERT INTO contact (first_name, last_name, birth_date) VALUES ('Mike', 'Adams', '1989-08-13');
INSERT INTO contact (first_name, last_name, birth_date) VALUES ('Tony', 'Belluchy', '1961-12-02');

INSERT INTO contact_tel_detail (contact_id, tel_type, tel_number) VALUES (1, 'Mobile', '1234567');
INSERT INTO contact_tel_detail (contact_id, tel_type, tel_number) VALUES (1, 'Home', '7654321');
INSERT INTO contact_tel_detail (contact_id, tel_type, tel_number) VALUES (2, 'Home', '3127465');

INSERT INTO hobby (hobby_id) VALUES ('Swimming');
INSERT INTO hobby (hobby_id) VALUES ('Jogging');
INSERT INTO hobby (hobby_id) VALUES ('Programming');
INSERT INTO hobby (hobby_id) VALUES ('Movies');
INSERT INTO hobby (hobby_id) VALUES ('Reading');

INSERT INTO contact_hobby_detail (contact_id, hobby_id) VALUES (1, 'Swimming');
INSERT INTO contact_hobby_detail (contact_id, hobby_id) VALUES (1, 'Movies');
INSERT INTO contact_hobby_detail (contact_id, hobby_id) VALUES (2, 'Swimming');