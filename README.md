# javafx-dynamically-research.java
little project to create dynamically a selectAll button using javafx


# the database

-- --------------------------------------------------------
-- Hôte:                         127.0.0.1
-- Version du serveur:           5.7.33 - MySQL Community Server (GPL)
-- SE du serveur:                Win64
-- HeidiSQL Version:             12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Listage de la structure de la base pour testjpa
CREATE DATABASE IF NOT EXISTS `testjpa` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `testjpa`;

-- Listage de la structure de table testjpa. caractere
CREATE TABLE IF NOT EXISTS `caractere` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table testjpa.caractere : ~0 rows (environ)
DELETE FROM `caractere`;
INSERT INTO `caractere` (`ID`, `NAME`) VALUES
	(1, 'Forme des feuilles'),
	(2, 'Phyllotaxie des feuilles');

-- Listage de la structure de table testjpa. etat
CREATE TABLE IF NOT EXISTS `etat` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DETAILS` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `caractere_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ETAT_caractere_id` (`caractere_id`),
  CONSTRAINT `FK_ETAT_caractere_id` FOREIGN KEY (`caractere_id`) REFERENCES `caractere` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table testjpa.etat : ~13 rows (environ)
DELETE FROM `etat`;
INSERT INTO `etat` (`ID`, `DETAILS`, `NAME`, `caractere_id`) VALUES
	(1, NULL, 'verticillée', 2),
	(2, NULL, 'spiralée', 2),
	(3, NULL, 'groupée', 2),
	(4, NULL, 'cordée', 1),
	(5, NULL, 'oblongue', 1),
	(6, NULL, 'decussée', 2),
	(7, NULL, 'sagitée', 1),
	(8, NULL, 'spirualée', 1),
	(9, NULL, 'allongée', 1),
	(10, NULL, 'opposée', 2),
	(11, NULL, 'sub-opposée', 2),
	(12, NULL, 'alternée', 2),
	(13, NULL, 'filiforme', 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
