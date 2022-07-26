drop schema if exists chat cascade;

create schema if not exists chat;

CREATE table if not exists chat.user
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

CREATE table chat.chatroom
(
    id    serial primary key,
    name  varchar,
    owner bigint
);

CREATE table if not exists chat.users_chatroom
(
    id           serial primary key,
    chatroom_id bigint,
    users_id     bigint,
    foreign key (chatroom_id) references chat.chatroom,
    foreign key (users_id) references chat.user
    );
