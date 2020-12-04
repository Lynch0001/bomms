

create table customers
(
    id        bigint       not null
        primary key,
    birthday  date         null,
    cust_id   varchar(255) null,
    email     varchar(255) null,
    firstname varchar(255) null,
    lastname  varchar(255) null,
    password  varchar(255) null,
    phone     varchar(255) null
)
    engine = MyISAM;
