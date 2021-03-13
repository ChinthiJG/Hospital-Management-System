-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 15, 2020 at 08:22 AM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospital`
--

-- --------------------------------------------------------

--
-- Table structure for table `appoinment`
--

CREATE TABLE `appoinment` (
  `appoin_no` varchar(255) NOT NULL,
  `doctorname` varchar(255) NOT NULL,
  `patientname` varchar(255) NOT NULL,
  `room` int(100) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appoinment`
--

INSERT INTO `appoinment` (`appoin_no`, `doctorname`, `patientname`, `room`, `date`) VALUES
('CH001', 'DS003', 'PS001', 2, '2020-01-10');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `doctorno` varchar(255) NOT NULL,
  `doctorname` varchar(255) NOT NULL,
  `phone` int(11) NOT NULL,
  `address` varchar(255) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `city` varchar(255) NOT NULL,
  `specialization` varchar(255) NOT NULL,
  `qualification` varchar(255) NOT NULL,
  `roomno` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`doctorno`, `doctorname`, `phone`, `address`, `gender`, `city`, `specialization`, `qualification`, `roomno`) VALUES
('DS001', 'gvgfk', 1234, 'bbekbfk', 'fbfkq', 'bkfjk', 'fhf', 'bfb', 'gfgf'),
('DS002', 'kasun', 674645, 'hbbkgf', 'male', 'kirinda', 'mbbs', 'high', '22'),
('DS003', 'kamal', 714547126, 'matara', 'male', 'bdffd', 'fbhfj', 'hbfh', 'bhf'),
('DS004', 'jfghjkfgw', 473374777, 'gghf', 'gfi', 'kfnjgkn', 'gfjkgn', 'fjgkgnf', 'njng');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `patientno` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` int(11) NOT NULL,
  `address` varchar(255) NOT NULL,
  `gender` varchar(200) NOT NULL,
  `disease` varchar(255) NOT NULL,
  `wardno` varchar(255) NOT NULL,
  `bedno` varchar(255) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`patientno`, `name`, `phone`, `address`, `gender`, `disease`, `wardno`, `bedno`, `date`) VALUES
('PS001', 'kasun', 754925645, 'fbhfgf', 'male', 'no', '334', '232', '2020-01-03'),
('PS007', 'jsfio', 3786578, 'ghhh', 'yfg', 'fhf', 'fh', 'i', '2020-01-03'),
('PS008', 'uiyru', 4957, 'fjkhfjbf', 'male', 'fjknkb', '744', 'jb', '1970-01-01');

-- --------------------------------------------------------

--
-- Table structure for table `receptionist`
--

CREATE TABLE `receptionist` (
  `recep_no` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` int(11) NOT NULL,
  `address` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receptionist`
--

INSERT INTO `receptionist` (`recep_no`, `name`, `phone`, `address`, `gender`, `date`) VALUES
('RS001', 'kasun', 3684168, 'kiinda', 'male', '2020-01-08'),
('RS002', 'chinthaka', 6748524, 'hhhjghjrjhrk', 'male', '2020-01-08');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `utype` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `username`, `password`, `utype`) VALUES
(1, 'kasun', 'kkk', '123', 'Pharmacist'),
(2, 'chinthaka', 'chinthi', '123', 'Pharmacist'),
(3, 'jali', 'jali123', '2254', 'Pharmacist'),
(4, 'chinthaka', 'chinthi', '1234', 'Admin'),
(5, 'chinthaka', 'kasun', '2254', 'Doctor'),
(6, 'jaliya', 'jali', '1234', 'Doctor'),
(7, 'chinthaka', 'chinthaka', '1234', 'Receptionst'),
(8, 'chinthaka', 'chinthaka', '1234', 'Receptionist'),
(9, 'lukshan', 'lukshan', '1234', 'Receptionist'),
(10, 'lukshan', 'lukshan', '1234', 'Doctor'),
(11, 'kameera', 'kameera', '1234', 'Doctor'),
(12, 'kameera', 'kameera', '1234', 'Pharmacist'),
(13, 'kamal', 'kamal', '1234', 'Admin'),
(14, 'yasas', 'yasas', '1234', 'Doctor');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appoinment`
--
ALTER TABLE `appoinment`
  ADD PRIMARY KEY (`appoin_no`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`doctorno`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`patientno`);

--
-- Indexes for table `receptionist`
--
ALTER TABLE `receptionist`
  ADD PRIMARY KEY (`recep_no`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
