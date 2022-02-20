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
    

    
