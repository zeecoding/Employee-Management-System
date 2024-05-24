-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 24, 2024 at 03:25 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project3`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `username` varchar(20) NOT NULL,
  `name` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `sec_q` varchar(25) NOT NULL,
  `sec_ans` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`username`, `name`, `password`, `sec_q`, `sec_ans`) VALUES
('vidhin123', 'vidhin', '123', 'Your NickName?', '123'),
('admin', 'zee', 'admin', 'Your Lucky Number?', '3');

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `emp_id` varchar(20) NOT NULL,
  `first` varchar(10) NOT NULL,
  `second` varchar(10) NOT NULL,
  `Date` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`emp_id`, `first`, `second`, `Date`) VALUES
('101', 'Present', 'Present', 'Fri Sep 24 10:27:07 IST 2021'),
('102', 'Present', 'Leave', 'Sat Mar 09 18:47:18 PKT 2024'),
('104', 'Present', 'Absent', 'Sun Mar 10 12:10:11 PKT 2024'),
('105', 'Absent', 'Present', 'Fri May 24 09:45:01 PKT 2024');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `name` varchar(25) NOT NULL,
  `fname` varchar(30) NOT NULL,
  `age` int(3) NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(50) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `education` varchar(15) NOT NULL,
  `post` varchar(15) NOT NULL,
  `cnic` varchar(13) NOT NULL,
  `emp_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`name`, `fname`, `age`, `dob`, `address`, `phone`, `email`, `education`, `post`, `cnic`, `emp_id`) VALUES
('vidhinpatel', 'D', 20, '2021-09-23', 'malosan', '1236547891', 'v@v.com', 'B.tech', 'programer', '2147483647', 101),
('jeet', 'a', 20, '2002-05-15', 'visnagar', '1236547895', 'j@j.com', 'IT', 'hr', '2147483647', 102),
('Junaid', 'Ali Ahmed', 21, '2004-12-02', 'street#20', '03055569003', 'abcd@gmail.com', 'mphill', 'Salesman', '3830256531246', 104),
('ahmed', 'Javaid ahmed', 25, '2003-02-28', 'Street#30,lahore', '03568945425', 'aliahmed@gmail.com', 'BA', 'Accountant', '3830268952165', 105);

-- --------------------------------------------------------

--
-- Table structure for table `leaveapplications`
--

CREATE TABLE `leaveapplications` (
  `LeaveID` int(11) NOT NULL,
  `EmployeeID` int(11) NOT NULL,
  `LeaveType` varchar(50) NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  `Reason` text DEFAULT NULL,
  `ApplicationDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `Status` varchar(20) DEFAULT 'pending',
  `ApprovalDate` timestamp NULL DEFAULT NULL,
  `Comments` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `leaveapplications`
--

INSERT INTO `leaveapplications` (`LeaveID`, `EmployeeID`, `LeaveType`, `StartDate`, `EndDate`, `Reason`, `ApplicationDate`, `Status`, `ApprovalDate`, `Comments`) VALUES
(1, 104, 'casual', '2024-05-24', '2024-05-25', 'Family problem', '2024-05-24 03:49:41', 'approved', '2024-05-24 03:50:35', NULL),
(2, 105, 'casual', '2024-05-25', '2024-05-27', 'Emergency', '2024-05-24 04:54:07', 'approved', '2024-05-24 04:54:39', NULL),
(4, 102, 'short', '2024-05-24', '2024-05-24', 'urgent work', '2024-05-24 05:00:55', 'approved', '2024-05-24 05:01:35', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `leaveapprovals`
--

CREATE TABLE `leaveapprovals` (
  `ApprovalID` int(11) NOT NULL,
  `LeaveID` int(11) NOT NULL,
  `ApprovalStatus` varchar(20) NOT NULL,
  `ApprovalDate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `Comments` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `leaveapprovals`
--

INSERT INTO `leaveapprovals` (`ApprovalID`, `LeaveID`, `ApprovalStatus`, `ApprovalDate`, `Comments`) VALUES
(1, 2, 'approved', '2024-05-24 04:54:39', ''),
(2, 4, 'approved', '2024-05-24 05:01:35', 'approved ');

-- --------------------------------------------------------

--
-- Table structure for table `salary`
--

CREATE TABLE `salary` (
  `id` int(10) NOT NULL,
  `hra` decimal(12,2) NOT NULL,
  `da` decimal(12,2) NOT NULL,
  `med` decimal(12,2) NOT NULL,
  `pf` decimal(12,2) NOT NULL,
  `basic_salary` decimal(12,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `salary`
--

INSERT INTO `salary` (`id`, `hra`, `da`, `med`, `pf`, `basic_salary`) VALUES
(101, 1000.00, 1000.00, 1555.00, 1000.00, 10000.00),
(102, 84584.00, 55468.00, 55.00, 5425.00, 5458.00),
(104, 3600.00, 320.00, 1500.00, 750.00, 25600.00);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`emp_id`);

--
-- Indexes for table `leaveapplications`
--
ALTER TABLE `leaveapplications`
  ADD PRIMARY KEY (`LeaveID`),
  ADD KEY `EmployeeID` (`EmployeeID`);

--
-- Indexes for table `leaveapprovals`
--
ALTER TABLE `leaveapprovals`
  ADD PRIMARY KEY (`ApprovalID`),
  ADD KEY `LeaveID` (`LeaveID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `leaveapplications`
--
ALTER TABLE `leaveapplications`
  MODIFY `LeaveID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `leaveapprovals`
--
ALTER TABLE `leaveapprovals`
  MODIFY `ApprovalID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `leaveapplications`
--
ALTER TABLE `leaveapplications`
  ADD CONSTRAINT `leaveapplications_ibfk_1` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`emp_id`);

--
-- Constraints for table `leaveapprovals`
--
ALTER TABLE `leaveapprovals`
  ADD CONSTRAINT `leaveapprovals_ibfk_1` FOREIGN KEY (`LeaveID`) REFERENCES `leaveapplications` (`LeaveID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
