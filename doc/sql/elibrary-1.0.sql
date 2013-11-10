SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


-- -----------------------------------------------------
-- Table `eLibrary`.`Owner`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eLibrary`.`Owner` ;

CREATE TABLE IF NOT EXISTS `eLibrary`.`Owner` (
  `ID` INT NULL AUTO_INCREMENT,
  `UserID` INT NULL,
  `BookID` INT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eLibrary`.`UserLibrary`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eLibrary`.`UserLibrary` ;

CREATE TABLE IF NOT EXISTS `eLibrary`.`UserLibrary` (
  `ID` INT NULL AUTO_INCREMENT,
  `UserID` INT NULL,
  `BookID` INT NULL,
  `IsReaded` TINYINT(1) NULL,
  `IsReviewed` TINYINT(1) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eLibrary`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eLibrary`.`User` ;

CREATE TABLE IF NOT EXISTS `eLibrary`.`User` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(40) NOT NULL,
  `LastName` VARCHAR(40) NOT NULL,
  `Email` VARCHAR(30) NOT NULL,
  `Password` VARCHAR(40) NOT NULL,
  `DateOfBirth` TIMESTAMP NOT NULL,
  `Avatar` VARCHAR(60) NULL,
  `RoleID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_User_Owner1`
    FOREIGN KEY (`ID`)
    REFERENCES `eLibrary`.`Owner` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_UserLibrary1`
    FOREIGN KEY (`ID`)
    REFERENCES `eLibrary`.`UserLibrary` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eLibrary`.`Role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eLibrary`.`Role` ;

CREATE TABLE IF NOT EXISTS `eLibrary`.`Role` (
  `ID` INT NOT NULL,
  `Role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_Role_User1`
    FOREIGN KEY (`ID`)
    REFERENCES `eLibrary`.`User` (`RoleID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eLibrary`.`Book`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eLibrary`.`Book` ;

CREATE TABLE IF NOT EXISTS `eLibrary`.`Book` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(500) NULL,
  `Author` VARCHAR(300) NULL,
  `Series` VARCHAR(200) NULL,
  `Edition` VARCHAR(50) NULL,
  `Publisher` VARCHAR(100) NULL,
  `Year` INT NULL,
  `Language` VARCHAR(2) NULL,
  `Identifier` VARCHAR(100) NULL,
  `Landscape` TINYINT(1) NULL,
  `Ocr` TINYINT(1) NULL,
  `Kromsated` TINYINT(1) NULL,
  `Color` TINYINT(1) NULL,
  `Bookmarks` TINYINT(1) NULL,
  `KromsatedByScanmagic` TINYINT(1) NULL,
  `Dpi` INT NULL,
  `Pages` INT NULL,
  `Extension` VARCHAR(5) NULL,
  `Filename` VARCHAR(1000) NULL,
  `Filesize` BIGINT NULL,
  `AbsolutePath` VARCHAR(300) NULL,
  `DownloadUrl` VARCHAR(300) NULL,
  `MD5` CHAR NULL,
  `TimeAdded` TIMESTAMP NOT NULL,
  `TimeLastModified` TIMESTAMP NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_Book_Owner1`
    FOREIGN KEY (`ID`)
    REFERENCES `eLibrary`.`Owner` (`BookID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Book_UserLibrary1`
    FOREIGN KEY (`ID`)
    REFERENCES `eLibrary`.`UserLibrary` (`BookID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
