-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 25, 2018 at 02:45 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ebook`
--

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `accountno` varchar(30) NOT NULL,
  `pin` varchar(10) NOT NULL,
  `username` varchar(20) NOT NULL,
  `title` varchar(40) NOT NULL,
  `price` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`accountno`, `pin`, `username`, `title`, `price`) VALUES
('435645345655', '1234', 'rino', 'applied uml', 0),
('767676767676', '3454', 'rino', 'evs', 0),
('454545454545', '1234', 'rino', 'evs', 100),
('123456789123', '1234', 'rino', 'evs', 100),
('123456789123', '1234', 'rino', 'evs', 100),
('123456789123', '1234', 'rino', 'applied uml', 400),
('123456789123', '1234', 'rino', 'applied uml', 400),
('123456789123', '1234', 'rino', 'evs', 100),
('123456789123', '1234', 'prem', 'applied uml', 400),
('123456789123', '1234', 'sai_hari98', 'Applied UML', 400),
('123456789123', '1234', 'rino', 'applied uml', 400),
('123456789123', '1234', 'syed', 'applied uml', 400);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
