CREATE TABLE USERS
(
    id bigint primary key auto_increment,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    phone_number varchar(255),
    email varchar(255) not null UNIQUE,
    password varchar(255) not null,
    role varchar(10) not null CHECK (role IN ('ADMIN', 'USER'))
);

CREATE TABLE COMPANIES
(
    id bigint primary key auto_increment,
    name varchar(255) not null,
    street varchar(255) not null,
    building_number varchar(10) not null,
    post_code varchar(255) not null,
    city varchar(255) not null,
    nip varchar(10) not null UNIQUE,
    bank_name varchar(255),
    account_number varchar(255) UNIQUE,
    user_id bigint not null,
    FOREIGN KEY (user_id) REFERENCES USERS(id) ON DELETE CASCADE
);

CREATE TABLE INVOICES
(
    id bigint primary key auto_increment,
    date_of_issue date not null,
    date_of_sale date not null,
    originality varchar(10) CHECK (originality IN ('ORIGINAL', 'COPY')),
    payment_method varchar(10) CHECK (payment_method IN ('CASH', 'CARD', 'TRANSFER')),
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
    unit_of_measure varchar(10) not null CHECK (unit_of_measure IN ('L', 'KG', 'PCS')),
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