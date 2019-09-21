-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema PRODUCCION_INDUSTRIAL
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema PRODUCCION_INDUSTRIAL
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `PRODUCCION_INDUSTRIAL` DEFAULT CHARACTER SET utf8 ;
USE `PRODUCCION_INDUSTRIAL` ;

-- -----------------------------------------------------
-- Table `PRODUCCION_INDUSTRIAL`.`ROL_USUARIO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCCION_INDUSTRIAL`.`ROL_USUARIO` ;

CREATE TABLE IF NOT EXISTS `PRODUCCION_INDUSTRIAL`.`ROL_USUARIO` (
  `id_rol` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_rol`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PRODUCCION_INDUSTRIAL`.`CARRERA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCCION_INDUSTRIAL`.`CARRERA` ;

CREATE TABLE IF NOT EXISTS `PRODUCCION_INDUSTRIAL`.`CARRERA` (
  `id_carrera` INT NOT NULL,
  `nombre_carrera` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_carrera`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PRODUCCION_INDUSTRIAL`.`USUARIO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCCION_INDUSTRIAL`.`USUARIO` ;

CREATE TABLE IF NOT EXISTS `PRODUCCION_INDUSTRIAL`.`USUARIO` (
  `carnet` INT NOT NULL,
  `nombre` VARCHAR(60) NOT NULL,
  `correo_electronico` VARCHAR(60) NOT NULL,
  `telefono` INT NOT NULL,
  `contrasenia` VARCHAR(400) NOT NULL,
  `estado` TINYINT(1) NULL,
  `id_rol` INT NOT NULL,
  `carrera_id` INT NOT NULL,
  PRIMARY KEY (`carnet`),
  INDEX `fk_USUARIO_ROL_USUARIO1_idx` (`id_rol` ASC),
  INDEX `fk_USUARIO_CARRERA1_idx` (`carrera_id` ASC),
  CONSTRAINT `fk_USUARIO_ROL_USUARIO1`
    FOREIGN KEY (`id_rol`)
    REFERENCES `PRODUCCION_INDUSTRIAL`.`ROL_USUARIO` (`id_rol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_USUARIO_CARRERA1`
    FOREIGN KEY (`carrera_id`)
    REFERENCES `PRODUCCION_INDUSTRIAL`.`CARRERA` (`id_carrera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PRODUCCION_INDUSTRIAL`.`INSUMO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCCION_INDUSTRIAL`.`INSUMO` ;

CREATE TABLE IF NOT EXISTS `PRODUCCION_INDUSTRIAL`.`INSUMO` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(60) NOT NULL,
  `fecha_caducidad` DATE NOT NULL,
  `fecha_ingreso` DATE NOT NULL,
  `costo` DOUBLE NOT NULL,
  `cantidad` DOUBLE NOT NULL,
  `disponibilidad` TINYINT(1) NOT NULL,
  `descripcion` TINYTEXT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PRODUCCION_INDUSTRIAL`.`MEDIDA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCCION_INDUSTRIAL`.`MEDIDA` ;

CREATE TABLE IF NOT EXISTS `PRODUCCION_INDUSTRIAL`.`MEDIDA` (
  `id_medida` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_medida`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PRODUCCION_INDUSTRIAL`.`MEDIDA_INSUMO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCCION_INDUSTRIAL`.`MEDIDA_INSUMO` ;

CREATE TABLE IF NOT EXISTS `PRODUCCION_INDUSTRIAL`.`MEDIDA_INSUMO` (
  `codigo_insumo` INT NOT NULL,
  `medida_id` INT NOT NULL,
  INDEX `fk_MEDIDA_INSUMO_INSUMO_idx` (`codigo_insumo` ASC),
  INDEX `fk_MEDIDA_INSUMO_MEDIDAS1_idx` (`medida_id` ASC),
  PRIMARY KEY (`codigo_insumo`, `medida_id`),
  CONSTRAINT `fk_MEDIDA_INSUMO_INSUMO`
    FOREIGN KEY (`codigo_insumo`)
    REFERENCES `PRODUCCION_INDUSTRIAL`.`INSUMO` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MEDIDA_INSUMO_MEDIDAS1`
    FOREIGN KEY (`medida_id`)
    REFERENCES `PRODUCCION_INDUSTRIAL`.`MEDIDA` (`id_medida`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PRODUCCION_INDUSTRIAL`.`PRODUCTO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCCION_INDUSTRIAL`.`PRODUCTO` ;

CREATE TABLE IF NOT EXISTS `PRODUCCION_INDUSTRIAL`.`PRODUCTO` (
  `id_producto` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` TINYTEXT NOT NULL,
  PRIMARY KEY (`id_producto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PRODUCCION_INDUSTRIAL`.`MODIFY_SUPPLY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCCION_INDUSTRIAL`.`MODIFY_SUPPLY` ;

CREATE TABLE IF NOT EXISTS `PRODUCCION_INDUSTRIAL`.`MODIFY_SUPPLY` (
  `id_modify_supply` INT NOT NULL AUTO_INCREMENT,
  `carnet_user` INT NOT NULL,
  `supply_id` INT NOT NULL,
  `modify_type` ENUM('POR_FALTANTE', 'POR_ROBO', 'ATRIBUTOS') NOT NULL,
  `cuantity` INT NOT NULL,
  `date` DATE NOT NULL,
  `note` MEDIUMTEXT NULL,
  INDEX `fk_INSUMO_USUARIO_USUARIO1_idx` (`carnet_user` ASC),
  INDEX `fk_INSUMO_USUARIO_INSUMO1_idx` (`supply_id` ASC),
  PRIMARY KEY (`id_modify_supply`),
  CONSTRAINT `fk_INSUMO_USUARIO_USUARIO1`
    FOREIGN KEY (`carnet_user`)
    REFERENCES `PRODUCCION_INDUSTRIAL`.`USUARIO` (`carnet`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_INSUMO_USUARIO_INSUMO1`
    FOREIGN KEY (`supply_id`)
    REFERENCES `PRODUCCION_INDUSTRIAL`.`INSUMO` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PRODUCCION_INDUSTRIAL`.`PRODUCCION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCCION_INDUSTRIAL`.`PRODUCCION` ;

CREATE TABLE IF NOT EXISTS `PRODUCCION_INDUSTRIAL`.`PRODUCCION` (
  `id_linea_produccion` INT NOT NULL,
  `nombre` VARCHAR(60) NOT NULL,
  `estado` TINYINT(1) NOT NULL,
  `unidades` INT NOT NULL,
  `calificacion` DOUBLE NULL,
  `precio_lote` DOUBLE NULL,
  `producto_id` INT NOT NULL,
  PRIMARY KEY (`id_linea_produccion`),
  INDEX `fk_LINEA_DE_PRODUCCION_PRODUCTO1_idx` (`producto_id` ASC),
  CONSTRAINT `fk_LINEA_DE_PRODUCCION_PRODUCTO1`
    FOREIGN KEY (`producto_id`)
    REFERENCES `PRODUCCION_INDUSTRIAL`.`PRODUCTO` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PRODUCCION_INDUSTRIAL`.`ETAPA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCCION_INDUSTRIAL`.`ETAPA` ;

CREATE TABLE IF NOT EXISTS `PRODUCCION_INDUSTRIAL`.`ETAPA` (
  `id_etapa` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` TINYTEXT NOT NULL,
  `linea_de_produccion_id` INT NOT NULL,
  `tiempo_minutos` INT NOT NULL,
  PRIMARY KEY (`id_etapa`),
  INDEX `fk_ETAPA_LINEA_DE_PRODUCCION1_idx` (`linea_de_produccion_id` ASC),
  CONSTRAINT `fk_ETAPA_LINEA_DE_PRODUCCION1`
    FOREIGN KEY (`linea_de_produccion_id`)
    REFERENCES `PRODUCCION_INDUSTRIAL`.`PRODUCCION` (`id_linea_produccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PRODUCCION_INDUSTRIAL`.`GROUP`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCCION_INDUSTRIAL`.`GROUP` ;

CREATE TABLE IF NOT EXISTS `PRODUCCION_INDUSTRIAL`.`GROUP` (
  `id_group` INT NOT NULL AUTO_INCREMENT,
  `information` MEDIUMTEXT NULL,
  `section` VARCHAR(2) NULL,
  PRIMARY KEY (`id_group`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PRODUCCION_INDUSTRIAL`.`HISTORY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCCION_INDUSTRIAL`.`HISTORY` ;

CREATE TABLE IF NOT EXISTS `PRODUCCION_INDUSTRIAL`.`HISTORY` (
  `history_id` INT NULL DEFAULT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NULL DEFAULT NULL,
  `total_cost` DOUBLE NULL,
  `batcheds_produced` INT NOT NULL,
  `is_active` TINYINT(1) NOT NULL DEFAULT 0,
  `production_id` INT NOT NULL,
  `group_id` INT NOT NULL,
  PRIMARY KEY (`history_id`),
  INDEX `fk_HISTORIAL_PRODUCCION1_idx` (`production_id` ASC),
  INDEX `fk_HISTORIAL_GRUPO1_idx` (`group_id` ASC),
  CONSTRAINT `fk_HISTORIAL_PRODUCCION1`
    FOREIGN KEY (`production_id`)
    REFERENCES `PRODUCCION_INDUSTRIAL`.`PRODUCCION` (`id_linea_produccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_HISTORIAL_GRUPO1`
    FOREIGN KEY (`group_id`)
    REFERENCES `PRODUCCION_INDUSTRIAL`.`GROUP` (`id_group`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PRODUCCION_INDUSTRIAL`.`PASO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCCION_INDUSTRIAL`.`PASO` ;

CREATE TABLE IF NOT EXISTS `PRODUCCION_INDUSTRIAL`.`PASO` (
  `id_paso` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` TINYTEXT NOT NULL,
  `etapa_id` INT NOT NULL,
  PRIMARY KEY (`id_paso`),
  INDEX `fk_PASO_ETAPA1_idx` (`etapa_id` ASC),
  CONSTRAINT `fk_PASO_ETAPA1`
    FOREIGN KEY (`etapa_id`)
    REFERENCES `PRODUCCION_INDUSTRIAL`.`ETAPA` (`id_etapa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PRODUCCION_INDUSTRIAL`.`COMENTARIO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCCION_INDUSTRIAL`.`COMENTARIO` ;

CREATE TABLE IF NOT EXISTS `PRODUCCION_INDUSTRIAL`.`COMENTARIO` (
  `id_comentario` INT NOT NULL,
  `texto` TINYTEXT NOT NULL,
  `paso_id` INT NOT NULL,
  PRIMARY KEY (`id_comentario`),
  INDEX `fk_COMENTARIO_PASO1_idx` (`paso_id` ASC),
  CONSTRAINT `fk_COMENTARIO_PASO1`
    FOREIGN KEY (`paso_id`)
    REFERENCES `PRODUCCION_INDUSTRIAL`.`PASO` (`id_paso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PRODUCCION_INDUSTRIAL`.`INSUMO_NECESARIO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCCION_INDUSTRIAL`.`INSUMO_NECESARIO` ;

CREATE TABLE IF NOT EXISTS `PRODUCCION_INDUSTRIAL`.`INSUMO_NECESARIO` (
  `id_insumo_necesario` INT NOT NULL,
  `id_linea_produccion` INT NOT NULL,
  `codigo_insumo` INT NOT NULL,
  PRIMARY KEY (`id_insumo_necesario`),
  INDEX `fk_INSUMOS_NECESARIOS_PRODUCCION1_idx` (`id_linea_produccion` ASC),
  INDEX `fk_INSUMOS_NECESARIOS_INSUMO1_idx` (`codigo_insumo` ASC),
  CONSTRAINT `fk_INSUMOS_NECESARIOS_PRODUCCION1`
    FOREIGN KEY (`id_linea_produccion`)
    REFERENCES `PRODUCCION_INDUSTRIAL`.`PRODUCCION` (`id_linea_produccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_INSUMOS_NECESARIOS_INSUMO1`
    FOREIGN KEY (`codigo_insumo`)
    REFERENCES `PRODUCCION_INDUSTRIAL`.`INSUMO` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PRODUCCION_INDUSTRIAL`.`GROUP_USER`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCCION_INDUSTRIAL`.`GROUP_USER` ;

CREATE TABLE IF NOT EXISTS `PRODUCCION_INDUSTRIAL`.`GROUP_USER` (
  `id_gruop_user` INT NOT NULL,
  `carnet_user` INT NOT NULL,
  `group_id` INT NOT NULL,
  `admission_date` DATE NOT NULL,
  PRIMARY KEY (`id_gruop_user`),
  INDEX `fk_GRUPO_USUARIO_USUARIO1_idx` (`carnet_user` ASC),
  INDEX `fk_GRUPO_USUARIO_GRUPO1_idx` (`group_id` ASC),
  CONSTRAINT `fk_GRUPO_USUARIO_USUARIO1`
    FOREIGN KEY (`carnet_user`)
    REFERENCES `PRODUCCION_INDUSTRIAL`.`USUARIO` (`carnet`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_GRUPO_USUARIO_GRUPO1`
    FOREIGN KEY (`group_id`)
    REFERENCES `PRODUCCION_INDUSTRIAL`.`GROUP` (`id_group`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
