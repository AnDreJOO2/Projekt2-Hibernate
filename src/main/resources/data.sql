
# actors
INSERT INTO actor(age, name, surname) values (32,'Andrzej','Szczap');
INSERT INTO actor(age, name, surname) values (31,'Karol','Janicki');
INSERT INTO actor(age, name, surname) values (35,'Will','Smith');
INSERT INTO actor(age, name, surname) values (37,'Basia','Walewska');
INSERT INTO actor(age, name, surname) values (23,'Anna','Kujawa');
INSERT INTO actor(age, name, surname) values (65,'Bartosz','Joda');
INSERT INTO actor(age, name, surname) values (59,'Maja','Skatulska');
INSERT INTO actor(age, name, surname) values (42,'Tomasz','Kujawa');
INSERT INTO actor(age, name, surname) values (82,'Maciej','Kos');
INSERT INTO actor(age, name, surname) values (37,'Barbara','Derenowska');
INSERT INTO actor(age, name, surname) values (62,'Karolina','Janiak');

INSERT INTO director(age, name, surname) VALUES (50,'Karol', 'Maćkowski');
INSERT INTO director(age, name, surname) VALUES (45,'Basia', 'Andrzejewska');
INSERT INTO director(age, name, surname) VALUES (76,'Anna', 'Kowalczyk');

INSERT INTO film(minutes, name, released, director_id) VALUES (120, 'Władca Pierścieni Dwie Wieże', date('2022-12-5'),1);

INSERT INTO films_actors(film_id, actor_id) VALUES (1,1);
INSERT INTO films_actors(film_id, actor_id) VALUES (1,2);
INSERT INTO films_actors(film_id, actor_id) VALUES (1,3);