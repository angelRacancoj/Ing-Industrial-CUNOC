-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema produccion_industrial
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `produccion_industrial` ;

-- -----------------------------------------------------
-- Schema produccion_industrial
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `produccion_industrial` ;
USE `produccion_industrial` ;

-- -----------------------------------------------------
-- Table `produccion_industrial`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `produccion_industrial`.`product` ;

CREATE TABLE IF NOT EXISTS `produccion_industrial`.`product` (
  `id_product` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` TINYTEXT NOT NULL,
  PRIMARY KEY (`id_product`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `produccion_industrial`.`production`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `produccion_industrial`.`production` ;

CREATE TABLE IF NOT EXISTS `produccion_industrial`.`production` (
  `id_production` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  `state` TINYINT(1) NOT NULL,
  `unity` INT(11) NOT NULL,
  `qualification` DOUBLE NULL DEFAULT NULL,
  `price_lot` DOUBLE NULL DEFAULT NULL,
  `creation_date` DATE NOT NULL,
  `description` TINYTEXT NULL,
  `product_id` INT(11) NULL,
  PRIMARY KEY (`id_production`),
  INDEX `fk_LINEA_DE_PRODUCCION_PRODUCTO1_idx` (`product_id` ASC),
  CONSTRAINT `fk_LINEA_DE_PRODUCCION_PRODUCTO1`
    FOREIGN KEY (`product_id`)
    REFERENCES `produccion_industrial`.`product` (`id_product`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `produccion_industrial`.`stage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `produccion_industrial`.`stage` ;

CREATE TABLE IF NOT EXISTS `produccion_industrial`.`stage` (
  `id_stage` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` TINYTEXT NOT NULL,
  `production_id` INT(11) NULL,
  PRIMARY KEY (`id_stage`),
  INDEX `fk_ETAPA_LINEA_DE_PRODUCCION1_idx` (`production_id` ASC),
  CONSTRAINT `fk_ETAPA_LINEA_DE_PRODUCCION1`
    FOREIGN KEY (`production_id`)
    REFERENCES `produccion_industrial`.`production` (`id_production`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `produccion_industrial`.`COMMENTARY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `produccion_industrial`.`COMMENTARY` ;

CREATE TABLE IF NOT EXISTS `produccion_industrial`.`COMMENTARY` (
  `id_commentary` INT(11) NOT NULL,
  `commentary` TINYTEXT NOT NULL,
  `stage_id` INT(11) NOT NULL,
  PRIMARY KEY (`id_commentary`),
  INDEX `fk_comentario_stage1_idx` (`stage_id` ASC),
  CONSTRAINT `fk_comentario_stage1`
    FOREIGN KEY (`stage_id`)
    REFERENCES `produccion_industrial`.`stage` (`id_stage`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `produccion_industrial`.`measure`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `produccion_industrial`.`measure` ;

CREATE TABLE IF NOT EXISTS `produccion_industrial`.`measure` (
  `id_measure` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id_measure`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `produccion_industrial`.`supply`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `produccion_industrial`.`supply` ;

CREATE TABLE IF NOT EXISTS `produccion_industrial`.`supply` (
  `code` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  `expiration_date` DATE NOT NULL,
  `date_of_admission` DATE NOT NULL,
  `cost` DOUBLE NOT NULL,
  `quantity` DOUBLE NOT NULL,
  `availability` TINYINT(1) NOT NULL,
  `description` TINYTEXT NULL DEFAULT NULL,
  `MEASURE_id_measure` INT(11) NOT NULL,
  PRIMARY KEY (`code`),
  INDEX `fk_SUPPLY_MEASURE1_idx` (`MEASURE_id_measure` ASC),
  CONSTRAINT `fk_SUPPLY_MEASURE1`
    FOREIGN KEY (`MEASURE_id_measure`)
    REFERENCES `produccion_industrial`.`measure` (`id_measure`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `produccion_industrial`.`step`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `produccion_industrial`.`step` ;

CREATE TABLE IF NOT EXISTS `produccion_industrial`.`step` (
  `id_step` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` TINYTEXT NOT NULL,
  `stage_id` INT(11) NULL,
  PRIMARY KEY (`id_step`),
  INDEX `fk_PASO_ETAPA1_idx` (`stage_id` ASC),
  CONSTRAINT `fk_PASO_ETAPA1`
    FOREIGN KEY (`stage_id`)
    REFERENCES `produccion_industrial`.`stage` (`id_stage`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `produccion_industrial`.`NECESSARY_SUPPLY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `produccion_industrial`.`NECESSARY_SUPPLY` ;

CREATE TABLE IF NOT EXISTS `produccion_industrial`.`NECESSARY_SUPPLY` (
  `id_necessary_supply` INT(11) NOT NULL,
  `step_id` INT(11) NOT NULL,
  `supply_code` INT(11) NOT NULL,
  PRIMARY KEY (`id_necessary_supply`),
  INDEX `fk_INSUMOS_NECESARIOS_INSUMO1_idx` (`supply_code` ASC),
  INDEX `fk_INSUMO_NECESARIO_PASO1_idx` (`step_id` ASC),
  CONSTRAINT `fk_INSUMOS_NECESARIOS_INSUMO1`
    FOREIGN KEY (`supply_code`)
    REFERENCES `produccion_industrial`.`supply` (`code`),
  CONSTRAINT `fk_INSUMO_NECESARIO_PASO1`
    FOREIGN KEY (`step_id`)
    REFERENCES `produccion_industrial`.`step` (`id_step`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `produccion_industrial`.`career`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `produccion_industrial`.`career` ;

CREATE TABLE IF NOT EXISTS `produccion_industrial`.`career` (
  `id_career` INT(11) NOT NULL,
  `name_career` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_career`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `produccion_industrial`.`group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `produccion_industrial`.`group` ;

CREATE TABLE IF NOT EXISTS `produccion_industrial`.`group` (
  `id_group` INT(11) NOT NULL AUTO_INCREMENT,
  `information` MEDIUMTEXT NULL DEFAULT NULL,
  `section` VARCHAR(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id_group`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `produccion_industrial`.`rol_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `produccion_industrial`.`rol_user` ;

CREATE TABLE IF NOT EXISTS `produccion_industrial`.`rol_user` (
  `id_rol` INT(11) NOT NULL,
  `name_rol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_rol`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `produccion_industrial`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `produccion_industrial`.`user` ;

CREATE TABLE IF NOT EXISTS `produccion_industrial`.`user` (
  `carnet` INT(11) NOT NULL,
  `name` VARCHAR(60) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `phone` INT(11) NOT NULL,
  `password` VARCHAR(400) NOT NULL,
  `state` TINYINT(1) NULL DEFAULT NULL,
  `id_rol` INT(11) NOT NULL,
  `id_career` INT(11) NOT NULL,
  PRIMARY KEY (`carnet`),
  INDEX `fk_USUARIO_ROL_USUARIO1_idx` (`id_rol` ASC),
  INDEX `fk_USUARIO_CARRERA1_idx` (`id_career` ASC),
  CONSTRAINT `fk_USUARIO_CARRERA1`
    FOREIGN KEY (`id_career`)
    REFERENCES `produccion_industrial`.`career` (`id_career`),
  CONSTRAINT `fk_USUARIO_ROL_USUARIO1`
    FOREIGN KEY (`id_rol`)
    REFERENCES `produccion_industrial`.`rol_user` (`id_rol`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `produccion_industrial`.`group_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `produccion_industrial`.`group_user` ;

CREATE TABLE IF NOT EXISTS `produccion_industrial`.`group_user` (
  `id_gruop_user` INT(11) NOT NULL,
  `group_id` INT(11) NOT NULL,
  `user_carnet` INT(11) NOT NULL,
  `admission_date` DATE NOT NULL,
  PRIMARY KEY (`id_gruop_user`),
  INDEX `fk_GRUPO_USUARIO_GRUPO1_idx` (`group_id` ASC),
  INDEX `fk_group_user_user1_idx` (`user_carnet` ASC),
  CONSTRAINT `fk_GRUPO_USUARIO_GRUPO1`
    FOREIGN KEY (`group_id`)
    REFERENCES `produccion_industrial`.`group` (`id_group`),
  CONSTRAINT `fk_group_user_user1`
    FOREIGN KEY (`user_carnet`)
    REFERENCES `produccion_industrial`.`user` (`carnet`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `produccion_industrial`.`history`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `produccion_industrial`.`history` ;

CREATE TABLE IF NOT EXISTS `produccion_industrial`.`history` (
  `history_id` INT(11) NOT NULL AUTO_INCREMENT,
  `start_date` DATE NOT NULL,
  `end_date` DATE NULL DEFAULT NULL,
  `total_cost` DOUBLE NULL DEFAULT NULL,
  `batcheds_produced` INT(11) NOT NULL,
  `is_active` TINYINT(1) NOT NULL DEFAULT '0',
  `group_id` INT(11) NOT NULL,
  `production_id` INT(11) NOT NULL,
  PRIMARY KEY (`history_id`),
  INDEX `fk_HISTORIAL_GRUPO1_idx` (`group_id` ASC),
  INDEX `fk_history_production1_idx` (`production_id` ASC),
  CONSTRAINT `fk_HISTORIAL_GRUPO1`
    FOREIGN KEY (`group_id`)
    REFERENCES `produccion_industrial`.`group` (`id_group`),
  CONSTRAINT `fk_history_production1`
    FOREIGN KEY (`production_id`)
    REFERENCES `produccion_industrial`.`production` (`id_production`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `produccion_industrial`.`modify_supply`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `produccion_industrial`.`modify_supply` ;

CREATE TABLE IF NOT EXISTS `produccion_industrial`.`modify_supply` (
  `id_modify_supply` INT(11) NOT NULL AUTO_INCREMENT,
  `carnet_user` INT(11) NOT NULL,
  `SUPPLY_code` INT(11) NOT NULL,
  `modify_type` ENUM('POR_FALTANTE', 'POR_ROBO', 'ATRIBUTOS') NOT NULL,
  `cuantity` INT(11) NOT NULL,
  `date` DATE NOT NULL,
  `note` MEDIUMTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id_modify_supply`),
  INDEX `fk_INSUMO_USUARIO_INSUMO1_idx` (`SUPPLY_code` ASC),
  INDEX `fk_modify_supply_user1_idx` (`carnet_user` ASC),
  CONSTRAINT `fk_INSUMO_USUARIO_INSUMO1`
    FOREIGN KEY (`SUPPLY_code`)
    REFERENCES `produccion_industrial`.`supply` (`code`),
  CONSTRAINT `fk_modify_supply_user1`
    FOREIGN KEY (`carnet_user`)
    REFERENCES `produccion_industrial`.`user` (`carnet`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
