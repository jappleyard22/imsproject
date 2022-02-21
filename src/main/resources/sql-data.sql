INSERT INTO `customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `items` (`item_name`, `price`) VALUES ('bowl', 10);
INSERT INTO `items` (`item_name`, `price`) VALUES ('dish', 5);
INSERT INTO `orders` (`fk_cust_id`, `price`) VALUES (1, 15);
INSERT INTO `order_items` (`fk_order_id`, `fk_item_id`) VALUES (1, 1);
INSERT INTO `order_items` (`fk_order_id`, `fk_item_id`) VALUES (1, 2);

