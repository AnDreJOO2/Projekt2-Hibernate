# actors
INSERT INTO actor(age, name, surname)
values (32, 'Andrzej', 'Szczap');
INSERT INTO actor(age, name, surname)
values (31, 'Karol', 'Janicki');
INSERT INTO actor(age, name, surname)
values (35, 'Will', 'Smith');
INSERT INTO actor(age, name, surname)
values (37, 'Basia', 'Walewska');
INSERT INTO actor(age, name, surname)
values (23, 'Anna', 'Kujawa');
INSERT INTO actor(age, name, surname)
values (65, 'Bartosz', 'Joda');
INSERT INTO actor(age, name, surname)
values (59, 'Maja', 'Skatulska');
INSERT INTO actor(age, name, surname)
values (42, 'Tomasz', 'Kujawa');
INSERT INTO actor(age, name, surname)
values (82, 'Maciej', 'Kos');
INSERT INTO actor(age, name, surname)
values (37, 'Barbara', 'Derenowska');
INSERT INTO actor(age, name, surname)
values (62, 'Karolina', 'Janiak');

INSERT INTO director(age, name, surname)
VALUES (50, 'Karol', 'Maćkowski');
INSERT INTO director(age, name, surname)
VALUES (45, 'Basia', 'Andrzejewska');
INSERT INTO director(age, name, surname)
VALUES (76, 'Anna', 'Kowalczyk');

INSERT INTO film(minutes, name, released, director_id)
VALUES (120, 'Władca Pierścieni Dwie Wieże', date('2022-12-5'), 1);

INSERT INTO films_actors(film_id, actor_id)
VALUES (1, 1);
INSERT INTO films_actors(film_id, actor_id)
VALUES (1, 2);
INSERT INTO films_actors(film_id, actor_id)
VALUES (1, 3);

INSERT INTO film(minutes, name, released, director_id)
VALUES (180, 'Avatar', date('2013-2-11'), 2);

INSERT INTO films_actors(film_id, actor_id)
VALUES (2, 1);
INSERT INTO films_actors(film_id, actor_id)
VALUES (2, 6);
INSERT INTO films_actors(film_id, actor_id)
VALUES (2, 7);
INSERT INTO films_actors(film_id, actor_id)
VALUES (2, 10);
INSERT INTO films_actors(film_id, actor_id)
VALUES (2, 11);

INSERT INTO film(minutes, name, released, director_id)
VALUES (120, 'Szybcy i Wściekli', date('2010-6-23'), 3);

INSERT INTO films_actors(film_id, actor_id)
VALUES (3, 3);
INSERT INTO films_actors(film_id, actor_id)
VALUES (3, 4);
INSERT INTO films_actors(film_id, actor_id)
VALUES (3, 5);
INSERT INTO films_actors(film_id, actor_id)
VALUES (3, 6);

INSERT INTO film(minutes, name, released, director_id)
VALUES (150, 'Krzyżacy', date('2012-11-28'), 1);

INSERT INTO films_actors(film_id, actor_id)
VALUES (4, 2);
INSERT INTO films_actors(film_id, actor_id)
VALUES (4, 4);
INSERT INTO films_actors(film_id, actor_id)
VALUES (4, 5);
INSERT INTO films_actors(film_id, actor_id)
VALUES (4, 8);
INSERT INTO films_actors(film_id, actor_id)
VALUES (4, 9);

INSERT INTO film(minutes, name, released, director_id)
VALUES (160, 'Pulp Fiction', date('1999-1-16'), 2);

INSERT INTO films_actors(film_id, actor_id)
VALUES (5, 1);
INSERT INTO films_actors(film_id, actor_id)
VALUES (5, 5);
INSERT INTO films_actors(film_id, actor_id)
VALUES (5, 6);
INSERT INTO films_actors(film_id, actor_id)
VALUES (5, 8);
INSERT INTO films_actors(film_id, actor_id)
VALUES (5, 9);
INSERT INTO films_actors(film_id, actor_id)
VALUES (5, 10);
INSERT INTO films_actors(film_id, actor_id)
VALUES (5, 11);

INSERT INTO film(minutes, name, released, director_id)
VALUES (180, 'Fury', date('2015-9-10'), 1);

INSERT INTO films_actors(film_id, actor_id)
VALUES (6, 1);
INSERT INTO films_actors(film_id, actor_id)
VALUES (6, 2);
INSERT INTO films_actors(film_id, actor_id)
VALUES (6, 3);
INSERT INTO films_actors(film_id, actor_id)
VALUES (6, 4);
INSERT INTO films_actors(film_id, actor_id)
VALUES (6, 5);

INSERT INTO film(minutes, name, released, director_id)
VALUES (130, 'Smerfy', date('2017-11-22'), 3);

INSERT INTO films_actors(film_id, actor_id)
VALUES (7, 1);
INSERT INTO films_actors(film_id, actor_id)
VALUES (7, 6);
INSERT INTO films_actors(film_id, actor_id)
VALUES (7, 8);

INSERT INTO cinema(city, name, number, street)
VALUES ('Warszawa', 'Helios', '1', 'Poznańska');

INSERT INTO room(air_conditioning, place_number, cinema_id)
VALUES (true, 100, 1);
INSERT INTO room(air_conditioning, place_number, cinema_id)
VALUES (true, 60, 1);
INSERT INTO room(air_conditioning, place_number, cinema_id)
VALUES (false, 60, 1);
INSERT INTO room(air_conditioning, place_number, cinema_id)
VALUES (true, 100, 1);

INSERT INTO cinema(city, name, number, street)
VALUES ('Poznań', 'Multikino', '10', 'Waleriańska');

INSERT INTO room(air_conditioning, place_number, cinema_id)
VALUES (true, 100, 2);
INSERT INTO room(air_conditioning, place_number, cinema_id)
VALUES (true, 80, 2);
INSERT INTO room(air_conditioning, place_number, cinema_id)
VALUES (true, 120, 2);

INSERT INTO cinema(city, name, number, street)
VALUES ('Szczacin', 'Dom kultury', '12A', '3 Maja');

INSERT INTO room(air_conditioning, place_number, cinema_id)
VALUES (true, 100, 3);
INSERT INTO room(air_conditioning, place_number, cinema_id)
VALUES (false, 100, 3);

INSERT INTO cinema(city, name, number, street)
VALUES ('Gdańsk', 'Helios', '13', 'Jana Matejki');

INSERT INTO room(air_conditioning, place_number, cinema_id)
VALUES (true, 100, 4);
INSERT INTO room(air_conditioning, place_number, cinema_id)
VALUES (true, 100, 4);
INSERT INTO room(air_conditioning, place_number, cinema_id)
VALUES (true, 120, 4);
INSERT INTO room(air_conditioning, place_number, cinema_id)
VALUES (true, 100, 4);
INSERT INTO room(air_conditioning, place_number, cinema_id)
VALUES (true, 100, 4);

INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2015-9-10'), 'PL', time('20:00:00'), 1, 1);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2015-9-11'), 'PL', time('21:00:00'), 1, 2);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2015-9-12'), 'PL', time('22:00:00'), 1, 3);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2015-9-13'), 'PL', time('23:00:00'), 1, 4);

INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2015-10-10'), 'PL', time('20:00:00'), 1, 1);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2015-11-10'), 'PL', time('15:00:00'), 1, 2);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2015-12-10'), 'PL', time('15:30:00'), 1, 3);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2015-12-10'), 'PL', time('16:00:00'), 1, 4);

INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2015-9-10'), 'PL', time('20:00:00'), 2, 5);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2015-9-11'), 'PL', time('21:00:00'), 2, 6);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2015-9-12'), 'PL', time('22:00:00'), 2, 7);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2015-9-13'), 'PL', time('23:00:00'), 2, 8);

INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2016-1-12'), 'PL', time('21:00:00'), 3, 9);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2016-1-13'), 'PL', time('11:30:00'), 3, 10);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2016-1-14'), 'PL', time('15:30:00'), 3, 11);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2016-1-15'), 'PL', time('16:00:00'), 3, 12);

INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2016-4-13'), 'PL', time('13:30:00'), 4, 12);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2016-5-14'), 'PL', time('14:30:00'), 4, 13);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2016-2-11'), 'PL', time('11:00:00'), 4, 13);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2016-3-12'), 'PL', time('12:30:00'), 4, 14);

INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2016-4-13'), 'PL', time('13:30:00'), 6, 10);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2016-5-14'), 'PL', time('14:30:00'), 6, 11);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2016-2-11'), 'PL', time('11:00:00'), 5, 13);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2016-3-12'), 'PL', time('12:30:00'), 5, 14);


INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2016-2-11'), 'PL', time('14:00:00'), 7, 1);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2016-3-12'), 'PL', time('15:30:00'), 7, 2);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2016-4-13'), 'PL', time('16:30:00'), 7, 3);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2016-5-14'), 'PL', time('17:30:00'), 7, 4);

INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2016-3-11'), 'PL', time('14:00:00'), 1, 1);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2016-4-12'), 'PL', time('15:30:00'), 2, 2);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2016-5-13'), 'PL', time('16:30:00'), 3, 3);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2016-6-14'), 'PL', time('17:30:00'), 4, 4);

INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2016-3-12'), 'PL', time('17:00:00'), 1, 1);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2016-4-13'), 'PL', time('18:30:00'), 2, 2);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2016-5-14'), 'PL', time('19:30:00'), 3, 3);
INSERT INTO seans(date_of_seans, language, start_time, film_id, room_id)
VALUES (date('2016-6-15'), 'PL', time('20:30:00'), 4, 4);
