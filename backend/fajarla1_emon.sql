-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 30, 2021 at 02:07 PM
-- Server version: 10.3.32-MariaDB
-- PHP Version: 7.3.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fajarla1_emon`
--

-- --------------------------------------------------------

--
-- Table structure for table `src_raw_data`
--

CREATE TABLE `src_raw_data` (
  `id` int(11) NOT NULL,
  `r` smallint(6) NOT NULL DEFAULT 0,
  `s` smallint(6) NOT NULL DEFAULT 0,
  `t` smallint(6) NOT NULL DEFAULT 0,
  `temperature` int(3) NOT NULL,
  `humidity` int(3) NOT NULL,
  `ctime` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `src_raw_data_api`
--

CREATE TABLE `src_raw_data_api` (
  `r` smallint(6) NOT NULL DEFAULT 0,
  `s` smallint(6) NOT NULL DEFAULT 0,
  `t` smallint(6) NOT NULL DEFAULT 0,
  `temperature` int(3) NOT NULL DEFAULT 0,
  `humidity` int(3) NOT NULL DEFAULT 0
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `src_raw_data`
--
ALTER TABLE `src_raw_data`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `src_raw_data`
--
ALTER TABLE `src_raw_data`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
