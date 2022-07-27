drop schema if exists shop cascade;

create schema shop;

CREATE table if not exists shop.products
(
    identifier INTEGER,
    names varchar(40),
    prime INTEGER
);
