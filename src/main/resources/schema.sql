CREATE TABLE USERS
(
    id bigint primary key auto_increment,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    phone_number varchar(255),
    email varchar(255) not null,
    password varchar(255) not null,
    role enum('ADMIN', 'USER') not null
);

CREATE TABLE COMPANIES
(
    id bigint primary key auto_increment,
    company_name varchar(255) not null,
    street varchar(255) not null,
    building_number varchar(255) not null,
    post_code varchar(255) not null,
    city varchar(255) not null,
    nip varchar(255) not null,
    bank_name varchar(255),
    bank_account_number varchar(255),
    user_id bigint not null,
    FOREIGN KEY (user_id) REFERENCES USERS(id) ON DELETE CASCADE
);

CREATE TABLE TOKENS
(
    id bigint primary key auto_increment,
    token varchar(255) not null,
    user_id bigint not null,
    FOREIGN KEY (user_id) REFERENCES USERS(id) ON DELETE CASCADE
);