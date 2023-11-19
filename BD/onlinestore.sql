-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema onlinestore
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema onlinestore
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `onlinestore` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `onlinestore` ;

-- -----------------------------------------------------
-- Table `onlinestore`.`articulos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlinestore`.`articulos` (
  `id_articulo` INT NOT NULL,
  `descripcion` VARCHAR(100) NULL DEFAULT NULL,
  `pvp` FLOAT NULL DEFAULT NULL,
  `gastosenvio` FLOAT NULL DEFAULT NULL,
  `preparacion` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id_articulo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `onlinestore`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlinestore`.`clientes` (
  `id_cliente` VARCHAR(10) NOT NULL,
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `domicilio` VARCHAR(100) NULL DEFAULT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `tipoCliente` VARCHAR(45) NULL DEFAULT NULL,
  `calcAnual` FLOAT NULL DEFAULT NULL,
  `descuentoEnv` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`id_cliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `onlinestore`.`pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlinestore`.`pedidos` (
  `id_pedido` INT NOT NULL,
  `cliente` VARCHAR(45) NULL DEFAULT NULL,
  `articulo` VARCHAR(45) NULL DEFAULT NULL,
  `cantidad` INT NULL DEFAULT NULL,
  `fecha` DATE NULL DEFAULT NULL,
  `id_cliente` VARCHAR(10) NULL DEFAULT NULL,
  `id_articulo` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id_pedido`),
  INDEX `fk1_Pedidos_Articulos` (`id_articulo` ASC) VISIBLE,
  INDEX `fk2_Pedidos_Clientes` (`id_cliente` ASC) VISIBLE,
  CONSTRAINT `fk1_Pedidos_Articulos`
    FOREIGN KEY (`id_articulo`)
    REFERENCES `onlinestore`.`articulos` (`id_articulo`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk2_Pedidos_Clientes`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `onlinestore`.`clientes` (`id_cliente`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
