create table clients_data
(
    id        serial
        primary key,
    user_id   serial,
    login     varchar(50),
    h_pass    varchar(50),
    is_online boolean
);

alter table clients_data
    owner to music_admin;

create table comments
(
    id        serial
        primary key,
    post_id   serial,
    author_id serial,
    timestamp timestamp default CURRENT_TIMESTAMP not null,
    message   varchar(200),
    author    varchar(50)
);


create table likes_m2m_post
(

    author_id serial,
    post_id   serial,
    li        serial

);

alter table likes_m2m_post
    owner to music_admin;

create table likes_m2m_song
(

    author_id    serial,
    song_data_id serial
);

alter table likes_m2m_song
    owner to music_admin;



create table posts
(
    id         serial
        primary key,
    author_id  serial,
    message    varchar(500),
    picture_id serial,
    song_name  varchar(256),
    timestamp  timestamp default CURRENT_TIMESTAMP not null
);

alter table posts
    owner to music_admin;


create table songs
(
    id      serial
        primary key,
    name    varchar(50),
    author  varchar(50),
    lasting numeric,
    raiting numeric,
    gengre  varchar(30)
);

alter table songs
    owner to music_admin;


create table songs_data
(
    id         serial
        constraint songsdata_pkey
            primary key,
    song_id    serial,
    author_id  serial,
    song_name  varchar(256),
    picture_id serial
);

alter table songs_data
    owner to music_admin;

create table songs_m2m_post
(
    post_id      serial,
    song_data_id serial
);

alter table songs_m2m_post
    owner to music_admin;

create table users_data
(
    id         serial
        primary key,
    name       varchar(50),
    picture_id serial
);

alter table users_data
    owner to music_admin;

create table pictures
(
    id   serial
        primary key,
    name varchar(50)
);
