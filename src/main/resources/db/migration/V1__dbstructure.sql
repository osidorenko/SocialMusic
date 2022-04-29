create table songs
(
    id      serial not null
        constraint songs_pkey
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
    id         serial not null
        constraint songsdata_pkey
            primary key,
    song_id    serial not null,
    author_id  serial not null,
    song_name  varchar(256),
    picture_id serial not null
);

alter table songs_data
    owner to music_admin;

create table posts
(
    id         serial not null
        constraint posts_pkey
            primary key,
    author_id  serial not null,
    message    varchar(500),
    picture_id serial not null,
    song_name  varchar(256),
    timestamp timestamp not null default current_timestamp
);

alter table posts
    owner to music_admin;

create table comments
(
    id        serial not null
        constraint comments_pkey
            primary key,
    post_id   serial not null,
    author_id serial not null,
    timestamp timestamp not null default current_timestamp,
    message   varchar(200),
    author    varchar(50)
);

alter table comments
    owner to music_admin;

create table users_data
(
    id         serial not null
        constraint users_data_pkey
            primary key,
    name       varchar(50),
    picture_id serial not null
);

alter table users_data
    owner to music_admin;

create table clients_data
(
    id        serial not null
        constraint clients_data_pkey
            primary key,
    user_id   serial not null,
    login     varchar(50),
    h_pass    varchar(50),
    is_online boolean
);

alter table clients_data
    owner to music_admin;

create table pictures
(
    id   serial not null
        constraint pictures_pkey
            primary key,
    name varchar(50)
);
