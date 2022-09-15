drop  table if exists cars;
CREATE table cars (
    id integer primary key,
    uuid VARCHAR(36),
    vendor VARCHAR(20) not null,
    model VARCHAR(20) not null ,
    year integer,
    owner VARCHAR(30) not null
);
drop sequence if exists cars_sequence;
CREATE SEQUENCE cars_sequence;

drop table if exists owners;
CREATE table if not exists owners (
  id integer primary key,
  name VARCHAR(20) not null,
  surname VARCHAR(20) not null,
  age integer,
  sex VARCHAR(1)
);

drop sequence if exists owners_sequence;
CREATE SEQUENCE owners_sequence;