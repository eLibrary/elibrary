SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `elibrary` ;
CREATE SCHEMA IF NOT EXISTS `elibrary` DEFAULT CHARACTER SET utf8 ;
USE `elibrary` ;

-- -----------------------------------------------------
-- Table `elibrary`.`book`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `elibrary`.`book` ;

CREATE TABLE IF NOT EXISTS `elibrary`.`book` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(500) NULL DEFAULT NULL,
  `Author` VARCHAR(300) NULL DEFAULT NULL,
  `Series` VARCHAR(200) NULL DEFAULT NULL,
  `Edition` VARCHAR(50) NULL DEFAULT NULL,
  `Publisher` VARCHAR(100) NULL DEFAULT NULL,
  `Year` INT(11) NULL DEFAULT NULL,
  `Language` VARCHAR(20) NULL DEFAULT NULL,
  `Identifier` VARCHAR(100) NULL DEFAULT NULL,
  `Landscape` TINYINT(1) NULL DEFAULT NULL,
  `Ocr` TINYINT(1) NULL DEFAULT NULL,
  `Kromsated` TINYINT(1) NULL DEFAULT NULL,
  `Color` TINYINT(1) NULL DEFAULT NULL,
  `Bookmarks` TINYINT(1) NULL DEFAULT NULL,
  `KromsatedByScanmagic` TINYINT(1) NULL DEFAULT NULL,
  `Dpi` INT(11) NULL DEFAULT NULL,
  `Pages` INT(11) NULL DEFAULT NULL,
  `Extension` VARCHAR(5) NULL DEFAULT NULL,
  `Filename` VARCHAR(1000) NULL DEFAULT NULL,
  `Filesize` BIGINT(20) NULL DEFAULT NULL,
  `AbsolutePath` VARCHAR(300) NULL DEFAULT NULL,
  `DownloadUrl` VARCHAR(300) NULL DEFAULT NULL,
  `MD5` VARCHAR(200) NULL DEFAULT NULL,
  `SearchString` VARCHAR(500) NULL DEFAULT NULL,
  `TimeAdded` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `TimeLastModified` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `elibrary`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `elibrary`.`user` ;

CREATE TABLE IF NOT EXISTS `elibrary`.`user` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(40) NOT NULL,
  `LastName` VARCHAR(40) NOT NULL,
  `Email` VARCHAR(30) NOT NULL,
  `Password` VARCHAR(40) NOT NULL,
  `DateOfBirth` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Avatar` VARCHAR(60) NULL DEFAULT NULL,
  `RoleID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `role_id_idx` (`RoleID` ASC),
  CONSTRAINT `user_role_id`
    FOREIGN KEY (`RoleID`)
    REFERENCES `elibrary`.`role` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `elibrary`.`owner`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `elibrary`.`owner` ;

CREATE TABLE IF NOT EXISTS `elibrary`.`owner` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `UserID` INT(11) NULL DEFAULT NULL,
  `BookID` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `user_id_idx` (`UserID` ASC),
  INDEX `book_id_idx` (`BookID` ASC),
  CONSTRAINT `user_owner_id`
    FOREIGN KEY (`UserID`)
    REFERENCES `elibrary`.`user` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `book_owner_id`
    FOREIGN KEY (`BookID`)
    REFERENCES `elibrary`.`book` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `elibrary`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `elibrary`.`role` ;

CREATE TABLE IF NOT EXISTS `elibrary`.`role` (
  `ID` INT(11) NOT NULL,
  `Role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `elibrary`.`userlibrary`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `elibrary`.`userlibrary` ;

CREATE TABLE IF NOT EXISTS `elibrary`.`userlibrary` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `UserID` INT(11) NULL DEFAULT NULL,
  `BookID` INT(11) NULL DEFAULT NULL,
  `IsReaded` TINYINT(1) NULL DEFAULT NULL,
  `IsReviewed` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `user_id_idx` (`UserID` ASC),
  INDEX `book_id_idx` (`BookID` ASC),
  CONSTRAINT `user_lib_id`
    FOREIGN KEY (`UserID`)
    REFERENCES `elibrary`.`user` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `book_lib_id`
    FOREIGN KEY (`BookID`)
    REFERENCES `elibrary`.`book` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
