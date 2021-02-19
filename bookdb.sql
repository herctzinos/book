create table author
(
    id            int auto_increment
        primary key,
    date_of_birth date         null,
    email         varchar(255) null,
    first_name    varchar(255) not null,
    last_name     varchar(255) not null
);




create table publisher
(
    id        int auto_increment
        primary key,
    address   varchar(255) default 'empty' null,
    name      varchar(255)                 not null,
    telephone varchar(255) default 'empty' null
);


create table book
(
    book_id       int auto_increment
        primary key,
    creation_date date                         null,
    description   varchar(255) default 'empty' null,
    ISBN          varchar(13)                  not null,
    title         varchar(255)                 not null,
    author_id     int                          null,
    publisher_id  int                          null,
    constraint book_author_id_fk
        foreign key (author_id) references author (id),
    constraint book_publisher_id_fk
        foreign key (publisher_id) references publisher (id)
);

