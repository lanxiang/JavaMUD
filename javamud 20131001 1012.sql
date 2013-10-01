-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.44-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema javamud
--

CREATE DATABASE IF NOT EXISTS javamud;
USE javamud;

--
-- Definition of table `gebruiker`
--

DROP TABLE IF EXISTS `gebruiker`;
CREATE TABLE `gebruiker` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gebruiker`
--

/*!40000 ALTER TABLE `gebruiker` DISABLE KEYS */;
/*!40000 ALTER TABLE `gebruiker` ENABLE KEYS */;


--
-- Definition of table `item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `EigenaarId` int(10) unsigned NOT NULL,
  `PositieId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `ItemEigenaar` (`EigenaarId`),
  KEY `ItemPositie` (`PositieId`),
  CONSTRAINT `ItemEigenaar` FOREIGN KEY (`EigenaarId`) REFERENCES `karakter` (`Id`),
  CONSTRAINT `ItemPositie` FOREIGN KEY (`PositieId`) REFERENCES `lokatie` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

/*!40000 ALTER TABLE `item` DISABLE KEYS */;
/*!40000 ALTER TABLE `item` ENABLE KEYS */;


--
-- Definition of table `karakter`
--

DROP TABLE IF EXISTS `karakter`;
CREATE TABLE `karakter` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `GebruikerId` int(10) unsigned NOT NULL,
  `LokatieId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `KarakterGebruiker` (`GebruikerId`),
  KEY `KarakterLokatie` (`LokatieId`),
  CONSTRAINT `KarakterLokatie` FOREIGN KEY (`LokatieId`) REFERENCES `lokatie` (`Id`),
  CONSTRAINT `KarakterGebruiker` FOREIGN KEY (`GebruikerId`) REFERENCES `gebruiker` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `karakter`
--

/*!40000 ALTER TABLE `karakter` DISABLE KEYS */;
/*!40000 ALTER TABLE `karakter` ENABLE KEYS */;


--
-- Definition of table `lokatie`
--

DROP TABLE IF EXISTS `lokatie`;
CREATE TABLE `lokatie` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Beschrijving` varchar(140) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lokatie`
--

/*!40000 ALTER TABLE `lokatie` DISABLE KEYS */;
/*!40000 ALTER TABLE `lokatie` ENABLE KEYS */;


--
-- Definition of table `lokatiebestemmingen`
--

DROP TABLE IF EXISTS `lokatiebestemmingen`;
CREATE TABLE `lokatiebestemmingen` (
  `LokatieId` int(10) unsigned NOT NULL,
  `BestemmingId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`LokatieId`,`BestemmingId`),
  KEY `BestemmingKey` (`BestemmingId`),
  CONSTRAINT `LokatieKey` FOREIGN KEY (`LokatieId`) REFERENCES `lokatie` (`Id`),
  CONSTRAINT `BestemmingKey` FOREIGN KEY (`BestemmingId`) REFERENCES `lokatie` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lokatiebestemmingen`
--

/*!40000 ALTER TABLE `lokatiebestemmingen` DISABLE KEYS */;
/*!40000 ALTER TABLE `lokatiebestemmingen` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
