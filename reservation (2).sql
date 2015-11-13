-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 13, 2015 at 03:06 AM
-- Server version: 10.0.17-MariaDB
-- PHP Version: 5.5.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `reservation`
--

-- --------------------------------------------------------

--
-- Table structure for table `building`
--

CREATE TABLE `building` (
  `b_id` int(10) NOT NULL,
  `b_name` varchar(50) NOT NULL,
  `b_location` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `building`
--

INSERT INTO `building` (`b_id`, `b_name`, `b_location`) VALUES
(1, 'Building A', 'A'),
(2, 'Building B', 'B'),
(3, 'Building C', 'C'),
(4, 'Building D', 'D'),
(5, 'Building E', 'E'),
(6, 'King Brunei Building', 'World'),
(7, 'Center Tower Building', 'Siam'),
(8, 'Design Square Tower', 'Sea'),
(9, 'New Tech Tower', 'AB'),
(10, 'Enterprise Space Craft', 'Space');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `r_id` int(10) NOT NULL,
  `r_no` varchar(20) NOT NULL,
  `r_name` varchar(50) NOT NULL,
  `r_seat` int(10) NOT NULL,
  `r_bid` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`r_id`, `r_no`, `r_name`, `r_seat`, `r_bid`) VALUES
(1, '222', 'Activity Room', 33, 1),
(2, '223', 'Meeting Room', 15, 1),
(3, '401', 'Bit & Bytes', 500, 2),
(4, '405', 'Paradise', 200, 2),
(5, '333', 'Grand Paradise', 500, 3),
(6, '335', 'Paradise Hall', 3000, 3),
(7, '678', 'Computer Lab', 100, 4),
(8, '789', 'Grand Balloon', 3000, 4),
(10, '111', 'Training Room', 200, 5),
(11, '3133', 'Glass Room A', 5, 4),
(12, '3134', 'Glass Room B', 5, 4),
(13, '3135', 'Glass Room C', 5, 4),
(14, '212224', 'Frozen Room', 2, 6),
(15, '474', 'Meeting Room 474', 50, 3),
(16, '666', 'Satan Room', 666, 3),
(17, '123', 'Ragnarok', 50, 5),
(18, '11', 'Secret Room', 9, 7),
(19, '1', 'Room A', 20, 8),
(20, '2', 'Room B', 30, 7),
(21, '7', 'Room 7', 30, 7),
(22, '5', 'Grand Canyon Room', 200, 8),
(23, '2146', 'Meeting Room', 50, 9),
(24, '1', 'Land&Mark', 700, 10);

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `s_id` int(10) NOT NULL,
  `s_rid` int(10) NOT NULL,
  `s_bid` int(10) NOT NULL,
  `s_sdate` varchar(20) NOT NULL,
  `s_edate` varchar(20) NOT NULL,
  `s_uname` varchar(50) NOT NULL,
  `s_status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `schedule`
--

INSERT INTO `schedule` (`s_id`, `s_rid`, `s_bid`, `s_sdate`, `s_edate`, `s_uname`, `s_status`) VALUES
(1, 1, 1, '2015-11-12', '2015-11-14', 'Dara', 'Unavailable'),
(2, 2, 2, '2015-11-15', '2015-11-17', 'Daraiing', 'Unavailable'),
(4, 8, 4, ' 2015-11-17', '2015-11-17', 'daraiing', 'Unavailable'),
(5, 3, 3, '2015-11-14', '2015-11-14', 'Darathorn', 'Unavailable'),
(6, 3, 2, ' 2015-11-17', '2015-11-17', 'daraiing', 'Unavailable'),
(8, 1, 1, '2015-11-11', '2015-11-11', 'kn', 'Unavailable'),
(13, 1, 0, '2015-11-15', '2015-11-15', 'dara', 'Unavailable'),
(14, 2, 0, '2015-11-11', '2015-11-11', 'dara', 'Unavailable'),
(15, 1, 0, '2015-11-16', '2015-11-16', 'kn', 'Unavailable'),
(16, 6, 0, '2015-11-12', '2015-11-15', 'jay', 'Unavailable'),
(17, 1, 0, '2015-11-27', '2015-11-30', 'jay', 'Unavailable'),
(18, 2, 0, '2015-11-23', '2015-11-30', 'jay', 'Unavailable'),
(19, 4, 0, '2015-11-12', '2015-12-12', 'jay', 'Unavailable'),
(21, 14, 0, '2015-11-12', '2015-11-15', 'anakin', 'Unavailable'),
(22, 24, 0, '2015-11-13', '2015-11-20', 'BankInwZa007', 'Unavailable'),
(23, 14, 0, '2015-11-16', '2015-11-17', 'Prayut', 'Unavailable'),
(24, 22, 0, '2015-11-22', '2015-11-31', 'BankInwZa007', 'Unavailable'),
(25, 14, 0, '2015-11-18', '2015-11-19', 'BankInwZa007', 'Unavailable');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `building`
--
ALTER TABLE `building`
  ADD PRIMARY KEY (`b_id`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`r_id`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`s_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `building`
--
ALTER TABLE `building`
  MODIFY `b_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `r_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `schedule`
--
ALTER TABLE `schedule`
  MODIFY `s_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
