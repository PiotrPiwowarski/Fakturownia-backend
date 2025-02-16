INSERT INTO USERS (first_name, last_name, phone_number, email, password, role)
VALUES
    ('Piotr', 'Piwowarski', '781975277', 'piotr@piwowarski-uniet.com',
     '$2y$10$fU0Z3J9Q9wfvN/L4xSgCteG9VAzTGwpj/FnlufWQmJ/oJeTkgF5WK', 'ADMIN'),  /* Admin1234! */
    ('Mirosław', 'Piwowarski', '691709533', 'uniet@op.pl',
     '$2y$10$dHDGIaSUsiw74xYqXtZHpu1QukA8eViGEcnFIz2cBr43aVTUf.anG', 'USER'),  /* Mirek1969! */
    ('admin', 'admin', '781975277', 'admin@gmail.com',
     '$2y$10$xzTdZGsPb1jV/T7CaOb6be3sxS/YnF4X.CfMVPRjJTyAziIPWaAWm', 'ADMIN');  /* admin */

INSERT INTO COMPANIES (name, street, building_number, post_code, city, nip, bank_name, account_number, user_id)
VALUES
    ('UNIET', 'Krakowska', '12', '32-600', 'Babice', '5491589392',
     'Bank PEKAO SA o/Oświęcim', '35124041551111000046351702', 2),

    ('PACCOR Polska sp. z o.o.', 'Budowlana', '6', '41-100', 'Siemianowice Śląskie',
     '5490022619', NULL, NULL, 2);

INSERT INTO INVOICES (invoice_number, date_of_issue, date_of_sale, originality, deadline_of_payment, payment_method, seller_company_id, buyer_company_id, user_id)
VALUES
    ('1/2025', '2025-02-10', '2025-02-10', 'ORIGINAL', '2025-03-10', 'CASH', 1, 2, 3),
    ('2/2025', '2025-02-11', '2025-02-11', 'COPY', '2025-03-11', 'CARD', 1, 2, 3),
    ('3/2025', '2025-02-12', '2025-02-12', 'ORIGINAL', '2025-03-12', 'TRANSFER', 1, 2, 3);

INSERT INTO INVOICE_POSITIONS (name, amount, unit_of_measure, unit_price, netto_value, vat_percent, vat_value, brutto_value, invoice_id)
VALUES
    ('Item 1', 10.00, 'KG', 50.00, 500.00, 23, 115.00, 615.00, 1),
    ('Item 2', 5.00, 'PCS', 20.00, 100.00, 23, 23.00, 123.00, 2);

-- Dodanie dwóch pozycji do trzeciej faktury
INSERT INTO INVOICE_POSITIONS (name, amount, unit_of_measure, unit_price, netto_value, vat_percent, vat_value, brutto_value, invoice_id)
VALUES
    ('Item 3', 2.00, 'L', 30.00, 60.00, 23, 13.80, 73.80, 3),
    ('Item 4', 3.00, 'KG', 40.00, 120.00, 23, 27.60, 147.60, 3);