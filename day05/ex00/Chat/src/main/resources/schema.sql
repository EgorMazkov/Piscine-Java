drop schema if exists chat cascade;

create schema if not exists chat;

CREATE table if not exists chat.users
(
    id       serial primary key,
    login    varchar,
    password varchar
);

CREATE table if not exists chat.message
(
    id        serial primary key,
    author_id bigint,
    room_id   bigint,
    text      text,
    date_time timestamp default CURRENT_TIMESTAMP
);

CREATE table chat.chat_room
(
    id    serial primary key,
    name  varchar,
    owner bigint
);

CREATE table if not exists chat.users_chat_room
(
    id           serial primary key,
    chat_room_id bigint,
    users_id     bigint,
    foreign key (chat_room_id) references chat.chat_room,
    foreign key (users_id) references chat.users
    );
