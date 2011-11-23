-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 23, 2011 at 01:52 AM
-- Server version: 5.1.44
-- PHP Version: 5.3.1

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `Address`
--

DROP TABLE IF EXISTS `Address`;
CREATE TABLE IF NOT EXISTS `Address` (
  `idAddress` int(11) NOT NULL AUTO_INCREMENT,
  `street` varchar(256) DEFAULT NULL,
  `city` varchar(45) DEFAULT 'Coimbra',
  `postalcode` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT 'Portugal',
  PRIMARY KEY (`idAddress`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COMMENT='Moradas' AUTO_INCREMENT=2 ;

--
-- Dumping data for table `Address`
--

INSERT INTO `Address` (`idAddress`, `street`, `city`, `postalcode`, `country`) VALUES
(1, 'RUA DAQUI', 'COIMBRA', '3000-228', 'PORTUGAL');

-- --------------------------------------------------------

--
-- Table structure for table `Book`
--

DROP TABLE IF EXISTS `Book`;
CREATE TABLE IF NOT EXISTS `Book` (
  `ISBN` varchar(45) NOT NULL,
  `author` varchar(45) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `numberofcopies` int(11) DEFAULT NULL,
  PRIMARY KEY (`ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Book`
--


-- --------------------------------------------------------

--
-- Table structure for table `Reservation`
--

DROP TABLE IF EXISTS `Reservation`;
CREATE TABLE IF NOT EXISTS `Reservation` (
  `idReservation` int(11) NOT NULL AUTO_INCREMENT,
  `startdate` varchar(45) DEFAULT NULL,
  `enddate` varchar(45) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `book` varchar(45) DEFAULT NULL,
  `n_copies` int(11) NOT NULL DEFAULT '1' COMMENT 'Número de cópias do livro',
  PRIMARY KEY (`idReservation`),
  KEY `idUser` (`user`),
  KEY `ISBN` (`book`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `Reservation`
--


-- --------------------------------------------------------

--
-- Table structure for table `Review`
--

DROP TABLE IF EXISTS `Review`;
CREATE TABLE IF NOT EXISTS `Review` (
  `idReview` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `book_ISBN` varchar(45) DEFAULT NULL,
  `messagebody` varchar(1024) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  PRIMARY KEY (`idReview`),
  KEY `idUser2` (`user_id`),
  KEY `ISBN2` (`book_ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `Review`
--


-- --------------------------------------------------------

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
CREATE TABLE IF NOT EXISTS `User` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `md5_pass` varchar(45) DEFAULT NULL,
  `doornumber` varchar(45) DEFAULT NULL,
  `addr` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT '0',
  `expires` varchar(45) DEFAULT '11/11/11',
  PRIMARY KEY (`idUser`),
  KEY `idAddress` (`addr`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COMMENT='Library Users' AUTO_INCREMENT=2 ;

--
-- Dumping data for table `User`
--

INSERT INTO `User` (`idUser`, `name`, `login`, `email`, `md5_pass`, `doornumber`, `addr`, `type`, `expires`) VALUES
(1, 'ZE MANEL', 'admin', 'zemanel@gmail.com', '21232f297a57a5a743894a0e4a801fc3', '25', 1, 0, '12/12/2020');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Reservation`
--
ALTER TABLE `Reservation`
  ADD CONSTRAINT `idUser` FOREIGN KEY (`user`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ISBN` FOREIGN KEY (`book`) REFERENCES `book` (`ISBN`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Review`
--
ALTER TABLE `Review`
  ADD CONSTRAINT `idUser2` FOREIGN KEY (`user_id`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ISBN2` FOREIGN KEY (`book_ISBN`) REFERENCES `book` (`ISBN`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `User`
--
ALTER TABLE `User`
  ADD CONSTRAINT `idAddress` FOREIGN KEY (`addr`) REFERENCES `address` (`idAddress`) ON DELETE NO ACTION ON UPDATE NO ACTION;
SET FOREIGN_KEY_CHECKS=1;
