CREATE TABLE COMPANIES
(
    id bigint primary key auto_increment,
    name varchar(255) not null,
    street varchar(255) not null,
    building_number varchar(255) not null,
    post_code varchar(255) not null,
    city varchar(255) not null,
    nip varchar(10) not null,
    bank_name varchar(255),
    account_number varchar(255),
    user_id bigint not null,
    FOREIGN KEY (user_id) REFERENCES USERS(id) ON DELETE CASCADE
);

CREATE TABLE INVOICES
(
    id bigint primary key auto_increment,
    date_of_issue date not null,
    date_of_sale date not null,
    originality enum('ORIGINAL', 'COPY'),
    payment_method enum('CASH', 'CARD', 'TRANSFER'),
    buyer_company_id bigint not null,
    seller_company_id bigint not null,
    user_id bigint not null
);

CREATE TABLE INVOICE_POSITIONS
(
    id bigint primary key auto_increment,
    name varchar(255) not null,
    amount decimal not null,
    unit_of_measure enum('L', 'KG', 'PCS') not null,
    unit_price decimal not null,
    netto_value decimal not null,
    vat_price integer not null,
    vat_value decimal not null,
    brutto_value decimal not null,
    invoice_id bigint not null
);

CREATE TABLE TOKENS
(
    id bigint primary key auto_increment,
    token varchar(255) not null,
    user_id bigint not null,
    FOREIGN KEY (user_id) REFERENCES USERS(id) ON DELETE CASCADE
);

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