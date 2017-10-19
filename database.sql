# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.6.37)
# Database: vat
# Generation Time: 2017-10-18 09:22:56 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE IF NOT EXISTS `vat`;

USE `vat`;


# Dump of table Shape
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Shape`;

CREATE TABLE `Shape` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(20) NOT NULL DEFAULT '',
  `radius` decimal(11,6) NOT NULL,
  `length` decimal(11,6) NOT NULL,
  `width` decimal(11,6) NOT NULL,
  `height` decimal(11,6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `Shape` (`id`, `type`, `radius`, `length`, `width`, `height`)
VALUES
  (1, 'Sphere', 4.000000, 0.000000, 0.000000, 0.000000),
  (2, 'Cylinder', 2.400000, 0.000000, 0.000000, 5.760000),
  (3, 'Cone', 34.300000, 0.000000, 0.000000, 1.090000),
  (4, 'RectangularPrism', 0.000000, 1.000000, 3.500000, 2.200000),
  (5, 'SquarePyramid', 0.000000, 1.400000, 0.000000, 4.700000);

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
