CREATE TABLE USERS
(
    id bigint primary key auto_increment,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    phone_number varchar(255) not null,
    email varchar(255) not null UNIQUE,
    password varchar(255) not null,
    role enum('ADMIN', 'USER')
);

CREATE TABLE COMPANIES
(
    id bigint primary key auto_increment,
    name varchar(255) not null,
    street varchar(255) not null,
    building_number varchar(10) not null,
    post_code varchar(255) not null,
    city varchar(255) not null,
    nip varchar(10) not null,
    bank_name varchar(255),
    account_number varchar(255) UNIQUE,
    user_id bigint not null,
    FOREIGN KEY (user_id) REFERENCES USERS(id) ON DELETE CASCADE
);

CREATE TABLE INVOICES
(
    id bigint primary key auto_increment,
    invoice_number varchar(255) not null,
    date_of_issue date not null,
    date_of_sale date not null,
    originality enum('ORIGINAL', 'COPY') not null,
    deadline_of_payment date not null,
    payment_method enum('CASH', 'CARD', 'TRANSFER') not null,
    buyer_company_id bigint not null,
    seller_company_id bigint not null,
    user_id bigint not null,
    FOREIGN KEY (buyer_company_id) REFERENCES COMPANIES(id),
    FOREIGN KEY (seller_company_id) REFERENCES COMPANIES(id),
    FOREIGN KEY (user_id) REFERENCES USERS(id)
);

CREATE TABLE INVOICE_POSITIONS
(
    id bigint primary key auto_increment,
    name varchar(255) not null,
    amount decimal(10,2) not null,
    unit_of_measure enum ('L', 'KG', 'PCS', 'THOUSAND_PCS') not null,
    unit_price decimal(10,2) not null,
    netto_value decimal(10,2) not null,
    vat_percent integer not null,
    vat_value decimal(10,2) not null,
    brutto_value decimal(10,2) not null,
    invoice_id bigint not null,
    FOREIGN KEY (invoice_id) REFERENCES INVOICES(id)
);

CREATE TABLE TOKENS
(
    id bigint primary key auto_increment,
    token varchar(255) not null UNIQUE,
    user_id bigint not null,
    FOREIGN KEY (user_id) REFERENCES USERS(id) ON DELETE CASCADE
);