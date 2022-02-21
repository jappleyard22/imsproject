DROP SCHEMA `imsproject`;

CREATE SCHEMA IF NOT EXISTS `imsproject`;

USE `imsproject`;

CREATE TABLE IF NOT EXISTS `imsproject`.`customers`(
    `cust_id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`cust_id`)
);

CREATE TABLE IF NOT EXISTS`imsproject`.`items`(
	`item_id` INT(11) NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(40) DEFAULT NULL,
    `price` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`item_id`)
); 

CREATE TABLE IF NOT EXISTS`imsproject`.`orders`(
	`order_id` INT(11) NOT NULL AUTO_INCREMENT,
    `fk_cust_id` INT(11) NOT NULL,
    PRIMARY KEY (`order_id`),
    FOREIGN KEY (`fk_cust_id`)
		REFERENCES `imsproject`.`customers` (`cust_id`) ON DELETE CASCADE,
        `price` DOUBLE
	);
    
CREATE TABLE IF NOT EXISTS `imsproject`.`order_items` (
	`fk_order_id` INT NOT NULL,
    `fk_item_id` INT NOT NULL,
    CONSTRAINT `fk_order_items_1` FOREIGN KEY (`fk_order_id`)
		REFERENCES `imsproject`.`orders` (`order_id`) ON DELETE CASCADE,
	CONSTRAINT `order_items_2` FOREIGN KEY (`fk_item_id`)
		REFERENCES `imsproject`.`items` (`item_id`) ON DELETE CASCADE
	);
    
    

    
