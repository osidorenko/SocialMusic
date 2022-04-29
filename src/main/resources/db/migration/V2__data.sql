INSERT INTO public.users_data (id, name, picture_id) VALUES (2, 'Nirvana', 1);
INSERT INTO clients_data (id, user_id, login, h_pass, is_online) VALUES (2, 2, 'nirvana', md5('123'), false);
--INSERT INTO clients_data (id, user_id, login, h_pass, is_online) VALUES (2, 2, 'nirvana', concat('{MD5}',md5('123')), false);
INSERT INTO public.users_data (id, name, picture_id) VALUES (3, 'alexs', 12);
INSERT INTO public.users_data (id, name, picture_id) VALUES (4, 'olegsidor538', 13);
INSERT INTO public.users_data (id, name, picture_id) VALUES (6, 'TESTUSER1', 25);


INSERT INTO public.pictures (id, name) VALUES (9, 'tosongMetallica.png');
INSERT INTO public.pictures (id, name) VALUES (12, 'defAvatar1.png');
INSERT INTO public.pictures (id, name) VALUES (13, 'defAvatar1.png');
INSERT INTO public.pictures (id, name) VALUES (3, 'defAvatar1.png');
INSERT INTO public.pictures (id, name) VALUES (1, 'defAvatar1.png');
INSERT INTO public.pictures (id, name) VALUES (23, 'defAvatar2.png');
INSERT INTO public.pictures (id, name) VALUES (25, 'defAvatar2.png');
INSERT INTO public.pictures (id, name) VALUES (16, 'content.png');
INSERT INTO public.pictures (id, name) VALUES (18, '');

INSERT INTO public.posts (id, author_id, message, picture_id, song_name, timestamp) VALUES (1, 2, 'Nirvana new song listen every one SONG: Something in the way AUTHOR:Nirvana ', 16, 'Something in the way', current_timestamp);
INSERT INTO public.posts (id, author_id, message, picture_id, song_name, timestamp) VALUES (10, 2, 'ANOTHER Some post....!!!!!!!!!!!!!!', 16, 'Something in the way', current_timestamp );
INSERT INTO public.posts (id, author_id, message, picture_id, song_name, timestamp) VALUES (6, 2, 'Helloo post)))', 18, 'ATL', current_timestamp);
INSERT INTO public.posts (id, author_id, message, picture_id, song_name, timestamp) VALUES (8, 2, 'ANOTHER Some post....with Picture', 16, '', current_timestamp);

INSERT INTO public.songs (id, name, author, lasting, raiting, gengre) VALUES (1, 'Something in the way...', 'Nirvana', 2.5, 3.5, 'Rock');
INSERT INTO public.songs (id, name, author, lasting, raiting, gengre) VALUES (42, 'Something in the way...', 'Nirvana', 2.5, 3.5, 'Rock');
INSERT INTO public.songs (id, name, author, lasting, raiting, gengre) VALUES (44, null, null, null, null, null);
INSERT INTO public.songs (id, name, author, lasting, raiting, gengre) VALUES (43, '��� �᭮', 'ATL', 2.5, 3.5, 'RAP');

INSERT INTO public.songs_data (id, song_id, author_id, song_name, picture_id) VALUES (14, 1, 2, 'Something in the way.mp3', 1);
INSERT INTO public.songs_data (id, song_id, author_id, song_name, picture_id) VALUES (15, 43, 3, 'ATL.mp3', 1);
