-- MySQL Script generated by MySQL Workbench
-- Fri 11 Jan 2019 12:10:40 PM CET
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema eventDb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema eventDb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `eventDb` DEFAULT CHARACTER SET utf8 ;
USE `eventDb` ;

-- -----------------------------------------------------
-- Table `eventDb`.`event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eventDb`.`event` (
  `idEvent` INT NOT NULL AUTO_INCREMENT,
  `eventName` VARCHAR(120) NOT NULL,
  `date` VARCHAR(45) NOT NULL,
  `location` VARCHAR(120) NOT NULL,
  `price` REAL NOT NULL,
  `availableSeats` INT NOT NULL,
  `isCancelled` BIT NULL DEFAULT 0,
  PRIMARY KEY (`idEvent`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eventDb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eventDb`.`user` (
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `email` VARCHAR(120) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `isAdmin` BIT NULL DEFAULT 0,
  `isInactive` BIT NULL DEFAULT 0,
  PRIMARY KEY (`email`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eventDb`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eventDb`.`ticket` (
  `idTicket` INT NOT NULL AUTO_INCREMENT,
  `user_email` VARCHAR(120) NOT NULL,
  `event_idEvent` INT NOT NULL,
  PRIMARY KEY (`idTicket`, `user_email`, `event_idEvent`),
  INDEX `fk_ticket_user1_idx` (`user_email` ASC),
  INDEX `fk_ticket_event1_idx` (`event_idEvent` ASC),
  CONSTRAINT `fk_ticket_user1`
    FOREIGN KEY (`user_email`)
    REFERENCES `eventDb`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_event1`
    FOREIGN KEY (`event_idEvent`)
    REFERENCES `eventDb`.`event` (`idEvent`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
