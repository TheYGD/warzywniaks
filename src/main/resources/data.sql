INSERT INTO public.users (role,id,email,first_name, last_name,login,password,phone_number)
VALUES
    (4, 1, 'jankowalski@gmail.com', 'Jan', 'Kowalski', 'jankowalski@gmail.com', '12345', '123456789'),
    (4, 2, 'adamnowak@gmail.com', 'Adam', 'Nowak', 'adamnowak@gmail.com', '12345', '345367654'),
    (4, 3, 'kamilkowalski@gmail.com', 'Kamil', 'Kowalski', 'kamilkowalski@gmail.com', '12345', '686543563'),
    (3, 4, 'annanowak@gmail.com', 'Anna', 'Nowak', 'annanowak_management', '12345', '353686868'),
    (2, 5, 'jankowalski@gmail.com', 'Jan', 'Kowalski', 'jankowalski_employee', '12345', '354678654');

INSERT INTO public.categories (id, name) VALUES
(1, 'Diary'),
(2, 'Fruits'),
(3, 'Vegetables'),
(4, 'Other'),
(5, 'Clothing');


INSERT INTO public.products (price, category_id, id, image_url, name, number) VALUES
(2.30, 1, 1, '', 'Milk', 'A213E'),
(0.40, 2, 2, '', 'Orange', 'D34F1'),
(0.35, 3, 3, '', 'Cucumber', 'FRTV2'),
(0.25, 2, 4, '', 'Apple', 'FG435'),
(0.10, 4, 5, '', 'Eggs ', 'FD34F');

INSERT INTO public.payment_details (id,date,status,external_id) VALUES
(1,'2024-01-01',0,'CCC12341F');

INSERT INTO public.delivery_details (id,status,external_id) VALUES
(1,1,'FFF31242');


INSERT INTO public.orders (id,delivery_id,payment_id,user_id,address,order_status) VALUES
(1,1,1,1,'addres',0);


INSERT INTO public.ordered_products (amount, order_id, product_id) VALUES
(10,1,1),
(3,1,2),
(4,1,3),
(8,1,4);