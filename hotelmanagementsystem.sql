-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 01, 2022 at 10:35 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotelmanagementsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminlogin`
--

CREATE TABLE `adminlogin` (
  `id` int(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `adminlogin`
--

INSERT INTO `adminlogin` (`id`, `username`, `password`) VALUES
(1, 'manish', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE `driver` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `Image` varchar(255) NOT NULL,
  `numberplate` varchar(255) NOT NULL,
  `contact` varchar(255) NOT NULL,
  `shift` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`id`, `name`, `address`, `gender`, `Image`, `numberplate`, `contact`, `shift`) VALUES
(1, 'shayam bahadur', '20', 'male', 'toyata', 'sfad', '1234567890', 'Morning'),
(2, 'Hari Bahadur', '25', 'male', 'Toyata', 'Ba-20-PA-3322', '9860213456', 'Day'),
(3, 'david ', '27', 'male', 'bord', '1234ere2', '1234567890', 'Morning'),
(4, 'sivaram', '39', 'male', 'browse', '123456', '1234567890', 'Morning'),
(5, 'ms dhoni', '23', 'male', 'browse', '123456', '1234567890', 'Morning'),
(6, 'ertgasdfg123', '23', 'male', '', '12345', '2345123456', 'Morning'),
(7, 'qwerty', '45', 'male', '', '123456', '123456723456', 'Morning'),
(8, 'Gopal Thakur', 'nayabazzar', 'male', 'C:UsersShadowDocumentsEr-diagram.drawio', 'ba-02 kha 2524', '9860484848', 'Morning'),
(9, 'David Becam', 'america', 'male', 'C:UsersShadowDesktophoteliconsadmin1.png', 'Ba-75-pa 3443', '9860905050', 'Night'),
(10, 'Harka Sompan', 'Dharan', 'male', 'C:UsersShadowDesktophotel298057723_561266585795076_238255332194530890_n.jpg', 'Dha-12-Ja-2345', '9869696969', 'Day');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `job` varchar(255) NOT NULL,
  `salary` int(255) NOT NULL,
  `contact` int(255) NOT NULL,
  `Image` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `name`, `address`, `gender`, `job`, `salary`, `contact`, `Image`, `email`) VALUES
(1, 'ram Bhadur', 'napaltar', 'Male', 'Manager', 40000, 1234567890, '', 'ram@gmail.com'),
(2, 'shyam thapa', 'gongabu', 'Male', 'Accountant', 25000, 2147483647, '', 'shyam@gmail.com'),
(3, 'Govinda thapa', 'Rampur', 'Male', 'Accountant', 45000, 2147483647, 'C:UsersShadowDesktophoteliconscleanroom.jpg', 'Govinda@gmail.com'),
(4, 'Hari Khadka', 'Buspark', 'Male', 'Manager', 50000, 2147483647, 'C:UsersShadowDesktophotellinkedin-sales-solutions-pAtA8xe_iVM-unsplash.jpg', 'Harke@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `guest`
--

CREATE TABLE `guest` (
  `g_id` int(11) NOT NULL,
  `id` varchar(255) NOT NULL,
  `identity` varchar(255) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Gender` varchar(20) NOT NULL,
  `Contact` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `RoomAllocation` int(255) NOT NULL,
  `Time` varchar(255) NOT NULL,
  `Deposite` varchar(255) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `guest`
--

INSERT INTO `guest` (`g_id`, `id`, `identity`, `Name`, `Gender`, `Contact`, `Address`, `RoomAllocation`, `Time`, `Deposite`, `status`) VALUES
(1, 'Citizenship', '5431267', 'Ram Bahadur Karki', 'Male', '9841234565', 'nepalgunj', 1004, 'Thu Aug 18 22:33:01 NPT 2022', '1000', 0),
(2, 'Citizenship', '1234567890', 'gyandra malla', 'Male', '9850040402', 'gongabu', 0, 'Thu Aug 25 18:10:37 NPT 2022', '', 0),
(3, 'Citizenship', '1234543', 'Sita kumari', 'Female', '9838484838', 'vedetar', 1004, 'Sun Aug 28 18:27:26 NPT 2022', '400', 0),
(4, 'Citizenship', 'C:UsersShadowDesktophoteliconsAddRoomButton.png', 'Sompal Kami', 'Male', '9830300303', 'maharajgunj', 1004, 'Tue Aug 30 16:53:58 NPT 2022', '500', 1),
(5, 'Driving License', 'C:UsersShadowDesktophotelhqdefault.jpg', 'Yan Bahadur Thapa', 'Male', '9841014418', 'Lakanpur', 1005, 'Tue Aug 30 19:38:43 NPT 2022', '600', 1);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `id` int(11) NOT NULL,
  `roomNumber` varchar(255) NOT NULL,
  `available` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `price` varchar(255) NOT NULL,
  `bed_type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`id`, `roomNumber`, `available`, `status`, `price`, `bed_type`) VALUES
(1, '1001', 'Occupied', 'Clean', '1000', 'Single '),
(2, '1002', 'Occupied', 'Clean', '2000', 'Double'),
(3, '1003', 'Occupied', 'Clean', '2000', 'Double'),
(4, '1004', 'Occupied', 'Clean', '1000', 'Single '),
(5, '1005', 'Occupied', 'Clean', '1000', 'Single '),
(6, '1006', 'Available', 'Clean', '2000', 'Double'),
(7, '1007', 'Available', 'Clean', '2500', 'Double');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `id` int(255) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Gender` varchar(255) NOT NULL,
  `Image` varchar(255) NOT NULL,
  `Salarly` int(255) NOT NULL,
  `Contact` int(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`id`, `Name`, `Address`, `Gender`, `Image`, `Salarly`, `Contact`, `Email`, `username`, `password`) VALUES
(1, '', '', '', '', 0, 0, '', '[ram]', '[12345]'),
(2, '', '', '', '', 0, 0, '', 'shyam', '12345'),
(3, 'dsvf ', 'sdgvcx', 'Male', '', 1234, 1234567890, 'sdgzefd', 'asdfghjkl', '12345'),
(4, 'manish pathak', 'gongabu', 'Male', '', 50000, 2147483647, 'manish@gmail.com', 'manish', '12345'),
(5, 'Ram thapa', 'nepaltar', 'Male', '', 50000, 2147483647, 'ram@gmain.com', 'ram', '12345'),
(6, 'Sompal kami', 'tinkune', 'Male', '', 23000, 986049494, 'sompal@gmial.com', 'sompal', '12345'),
(7, 'Anisha Gurung', 'Gokarna', 'Female', 'C:UsersShadowDesktophoteliconscheckout.png', 40000, 2147483647, 'Anisha@gmail.com', 'Anish123', '12345'),
(8, 'Srinkha Khatiwoda', 'Baluwataar', 'Male', 'C:UsersShadowDesktophotel63727667.jfif.crdownload', 50000, 2147483647, 'srinkhala@gmail.com', 'srinkhala123', '12345');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adminlogin`
--
ALTER TABLE `adminlogin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `driver`
--
ALTER TABLE `driver`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `guest`
--
ALTER TABLE `guest`
  ADD PRIMARY KEY (`g_id`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adminlogin`
--
ALTER TABLE `adminlogin`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `driver`
--
ALTER TABLE `driver`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `guest`
--
ALTER TABLE `guest`
  MODIFY `g_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
