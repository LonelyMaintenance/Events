-- MySQL Script generated by MySQL Workbench
-- Tue 01 Jan 2019 10:39:46 PM CET
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mygift
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mygift
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mygift` DEFAULT CHARACTER SET utf8 ;
USE `mygift` ;

-- -----------------------------------------------------
-- Table `mygift`.`giftGiver`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mygift`.`giftGiver` (
  `alias` VARCHAR(120) NOT NULL,
  PRIMARY KEY (`alias`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mygift`.`giftTaker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mygift`.`giftTaker` (
  `email` VARCHAR(120) NOT NULL,
  `moneyOnAccount` REAL NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `isAdmin` BIT NULL DEFAULT 0,
  `isInactive` BIT NULL DEFAULT 0,
  PRIMARY KEY (`email`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mygift`.`gift`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mygift`.`gift` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `amount` REAL NOT NULL,
  `activated` BIT NOT NULL DEFAULT 0,
  `giftTaker_email` VARCHAR(120) NOT NULL,
  `giftGiver_alias` VARCHAR(120) NOT NULL,
  PRIMARY KEY (`id`, `giftTaker_email`, `giftGiver_alias`),
  INDEX `fk_gift_giftTaker_idx` (`giftTaker_email` ASC),
  INDEX `fk_gift_giftGiver1_idx` (`giftGiver_alias` ASC),
  CONSTRAINT `fk_gift_giftTaker`
    FOREIGN KEY (`giftTaker_email`)
    REFERENCES `mygift`.`giftTaker` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_gift_giftGiver1`
    FOREIGN KEY (`giftGiver_alias`)
    REFERENCES `mygift`.`giftGiver` (`alias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;