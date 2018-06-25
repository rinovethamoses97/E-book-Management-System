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
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `title` varchar(50) NOT NULL,
  `author` varchar(50) NOT NULL,
  `price` int(10) NOT NULL,
  `publication` varchar(50) NOT NULL,
  `sellerusername` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`title`, `author`, `price`, `publication`, `sellerusername`) VALUES
('Applied uml', 'larman', 400, 'technical publishers', 'swami'),
('pqt', 'balaji', 200, 'sri balaji', 'swami'),
('dsp', 'ramesh babu', 200, 'babu publishers', 'swami'),
('evs', 'louis', 100, 'sri tendral', 'swami'),
('computer networks', 'bruce d wayne', 400, 'scitech publication', 'swami'),
('a', 'b', 200, 'c', 'swami'),
('software engineering', 'larman', 100, 'pearson publication', 'swami'),
('pds', 'rama krishnar', 100, 'rama publication', 'swami'),
('networks', 'bruce', 200, 'sri warner publishers', 'rohith'),
('wireless', 'wayne', 200, 'sri george publishers', 'swami');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
