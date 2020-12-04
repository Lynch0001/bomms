DROP TABLE IF EXISTS customers;

DROP TABLE IF EXISTS addresses;

DROP TABLE IF EXISTS interests;

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


create table addresses
(
    id bigint not null
        primary key,
    city varchar(255) null,
    state varchar(255) null,
    street varchar(255) null,
    zip varchar(255) null,
    is_billing bit null,
    is_shipping bit null,
    customer_id bigint not null
)
    engine=MyISAM;

create index FKhrpf5e8dwasvdc5cticysrt2k
    on addresses (customer_id);

create table interests
(
    id bigint not null
        primary key,
    interest varchar(255) null,
    customer_id bigint not null
)
    engine=MyISAM;

create index FKa561uy0lupq9jj0ylmoor25ul
    on interests (customer_id);

