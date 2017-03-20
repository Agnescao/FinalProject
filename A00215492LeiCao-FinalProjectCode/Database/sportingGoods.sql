-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema SportingGoods
-- -----------------------------------------------------
-- Schema used with the Sporting Good program
DROP SCHEMA IF EXISTS `SportingGoods` ;

-- -----------------------------------------------------
-- Schema SportingGoods
--
-- Schema used with the Sporting Good program
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SportingGoods` ;
USE `SportingGoods` ;

-- -----------------------------------------------------
-- Table `SportingGoods`.`Customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportingGoods`.`Customer` ;

CREATE TABLE IF NOT EXISTS `SportingGoods`.`Customer` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Phone` VARCHAR(45) NOT NULL,
  `Address` VARCHAR(45) NOT NULL,
  `City_region` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportingGoods`.`Category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportingGoods`.`Category` ;

CREATE TABLE IF NOT EXISTS `SportingGoods`.`Category` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportingGoods`.`Product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportingGoods`.`Product` ;

CREATE TABLE IF NOT EXISTS `SportingGoods`.`Product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Price` DECIMAL(5,2) NOT NULL,
  `Description` TINYTEXT NULL,
  `last_update` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `path` VARCHAR(45) NOT NULL,
  `Category_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Product_Category_idx` (`Category_id` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_Product_Category`
    FOREIGN KEY (`Category_id`)
    REFERENCES `SportingGoods`.`Category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportingGoods`.`Customer_order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportingGoods`.`Customer_order` ;

CREATE TABLE IF NOT EXISTS `SportingGoods`.`Customer_order` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Amount` DECIMAL(6,2) NOT NULL,
  `Date_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Confirmation_number` INT NOT NULL,
  `Customer_id` INT UNSIGNED NOT NULL,
  `Product_id` INT NOT NULL,
  UNIQUE INDEX `Confirmation_number_UNIQUE` (`Confirmation_number` ASC),
  INDEX `fk_Customer_order_Customer1_idx` (`Customer_id` ASC),
  PRIMARY KEY (`id`, `Product_id`),
  INDEX `fk_Customer_order_Product1_idx` (`Product_id` ASC),
  CONSTRAINT `fk_Customer_order_Customer1`
    FOREIGN KEY (`Customer_id`)
    REFERENCES `SportingGoods`.`Customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Customer_order_Product1`
    FOREIGN KEY (`Product_id`)
    REFERENCES `SportingGoods`.`Product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportingGoods`.`Cart`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportingGoods`.`Cart` ;

CREATE TABLE IF NOT EXISTS `SportingGoods`.`Cart` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportingGoods`.`Customer_Cart`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportingGoods`.`Customer_Cart` ;

CREATE TABLE IF NOT EXISTS `SportingGoods`.`Customer_Cart` (
  `Customer_id` INT UNSIGNED NOT NULL,
  `Cart_id` INT NOT NULL,
  PRIMARY KEY (`Customer_id`, `Cart_id`),
  INDEX `fk_Customer_Cart_Cart1_idx` (`Cart_id` ASC),
  CONSTRAINT `fk_Customer_Cart_Customer1`
    FOREIGN KEY (`Customer_id`)
    REFERENCES `SportingGoods`.`Customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Customer_Cart_Cart1`
    FOREIGN KEY (`Cart_id`)
    REFERENCES `SportingGoods`.`Cart` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportingGoods`.`Order_Cart`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportingGoods`.`Order_Cart` ;

CREATE TABLE IF NOT EXISTS `SportingGoods`.`Order_Cart` (
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportingGoods`.`comments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportingGoods`.`comments` ;

CREATE TABLE IF NOT EXISTS `SportingGoods`.`comments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `comments` TEXT NULL,
  `time` TIMESTAMP NOT NULL,
  `Customer_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`, `Customer_id`),
  INDEX `fk_comments_Customer1_idx` (`Customer_id` ASC),
  CONSTRAINT `fk_comments_Customer1`
    FOREIGN KEY (`Customer_id`)
    REFERENCES `SportingGoods`.`Customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SportingGoods`.`reply`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SportingGoods`.`reply` ;

CREATE TABLE IF NOT EXISTS `SportingGoods`.`reply` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `reply` TEXT NULL,
  `comments_id` INT NOT NULL,
  `comments_Customer_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`, `comments_id`, `comments_Customer_id`),
  INDEX `fk_reply_comments1_idx` (`comments_id` ASC, `comments_Customer_id` ASC),
  CONSTRAINT `fk_reply_comments1`
    FOREIGN KEY (`comments_id` , `comments_Customer_id`)
    REFERENCES `SportingGoods`.`comments` (`id` , `Customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
