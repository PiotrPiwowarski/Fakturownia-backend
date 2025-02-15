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