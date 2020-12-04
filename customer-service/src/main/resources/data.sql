INSERT INTO bommscustomer.customers(id, cust_id, password, lastname, firstname, email, phone, birthday)
VALUES
        (1, 'test0001', 'password', 'Smith',  'Ann', 'ASmith@email.com', '999-999-9999', '1978-01-01'),
        (2, 'test0002', 'password', 'Jones', 'Joe', 'JJones@email.com', '999-999-9999', '1978-01-01');


INSERT INTO bommscustomer.addresses(id, street, city, state, zip, is_billing, is_shipping, customer_id )
VALUES
(1, '100 Main St', 'Anyplace', 'WA', '99999', true, false, 1),
(2, '200 Main St', 'Anyplace', 'WA', '99999', true, false, 2),
(3, '300 Main St', 'Anyplace', 'WA', '99999', false, true, 1),
(4, '400 Main St', 'Anyplace', 'WA', '99999', false, true, 2);

INSERT INTO bommscustomer.interests(id, interest, customer_id)
VALUES
(1, 'Java', 1),
(2, 'Spring', 1),
(3, 'Angular', 1),
(4, 'Java', 2),
(5, 'SQL', 2);
