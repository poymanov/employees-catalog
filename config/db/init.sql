create table employees
(
    id serial not null
        constraint table_name_pk
            primary key,
    first_name varchar(45),
    last_name varchar(45),
    email varchar(45)
);

create unique index employees_id_uindex
    on employees (id);

ALTER SEQUENCE employees_id_seq RESTART WITH 6;