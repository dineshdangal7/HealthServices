-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 27, 2023 at 07:53 AM
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
-- Database: `healthservice_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `d_id` int(11) NOT NULL,
  `dc_id` int(11) NOT NULL,
  `d_name` varchar(50) NOT NULL,
  `d_address` varchar(50) NOT NULL,
  `d_experience` int(11) NOT NULL,
  `d_contact` text NOT NULL,
  `d_fee` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`d_id`, `dc_id`, `d_name`, `d_address`, `d_experience`, `d_contact`, `d_fee`) VALUES
(11, 3, 'Prof. Dr. Umid Kumar Shrestha, MD, PhD', 'Nepal Mediciti Hospital‬- Kathmandu', 25, '9861966614', 800),
(12, 4, 'Dr Tulsi Poudel', 'New Baneswor-Kathmandu', 5, '9806079144', 400),
(15, 1, 'Dr Sujan Upreti', 'B&NC Teaching Hospital', 7, '9817945678', 1500),
(16, 6, 'Dr Suman Sing', 'OM Shahi Pathivara', 10, '9827839393', 2000),
(17, 3, 'Dr Anand Jha', 'Annapurna Hospital', 15, '98736475757', 2000),
(18, 1, 'Dr Ajit Kumar Gurung', 'Annapurna Hospital', 3, '9874657676', 1000),
(19, 6, 'Dr Krishna Nepali', 'Dhulikhtalel Hospital', 5, '984756737', 900),
(20, 3, 'DR Prativa Shrestha', 'Narayani Samudhayik Hospital', 5, '9857676755', 800),
(21, 4, 'Dr Asmita Nepal', 'Nobel Medical College', 4, '9827364747', 600),
(22, 5, 'Dr Balkrishna Bhattrai', 'Mammohan Hospital', 6, '984756575', 500);

-- --------------------------------------------------------

--
-- Table structure for table `doctorcatagory`
--

CREATE TABLE `doctorcatagory` (
  `dc_id` int(11) NOT NULL,
  `dc_name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `doctorcatagory`
--

INSERT INTO `doctorcatagory` (`dc_id`, `dc_name`) VALUES
(1, 'Dietician'),
(3, 'Family Physician'),
(4, 'Dentist'),
(5, 'Surgeon'),
(6, 'Cardiologists');

-- --------------------------------------------------------

--
-- Table structure for table `labtest`
--

CREATE TABLE `labtest` (
  `l_id` int(11) NOT NULL,
  `l_name` varchar(50) NOT NULL,
  `l_description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `labtest`
--

INSERT INTO `labtest` (`l_id`, `l_name`, `l_description`) VALUES
(3, 'Full Body Checkup', 'Blood Glucose Fasting'),
(5, 'Half Body Checkup', 'it is only half body checkup'),
(6, 'Amlodipine', 'it is only half body checkup');

-- --------------------------------------------------------

--
-- Table structure for table `medicine`
--

CREATE TABLE `medicine` (
  `m_id` int(11) NOT NULL,
  `m_name` varchar(50) NOT NULL,
  `m_description` text NOT NULL,
  `m_price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `medicine`
--

INSERT INTO `medicine` (`m_id`, `m_name`, `m_description`, `m_price`) VALUES
(12, 'Acetaminophen', 'Acetaminophen is used to treat mild to moderate pain, moderate to severe pain in conjunction with opiates, or to reduce fever. Common conditions treated include headache, muscle aches, arthritis, backache, toothaches, sore throat, colds, flu, and fevers.', 100),
(13, 'Viagra', 'Viagra is used to treat erectile dysfunction (impotence) in men. Another brand of sildenafil is Revatio, which is used to treat pulmonary arterial hypertension and improve exercise capacity in men and women. This page contains specific information for Viagra, not Revatio.', 40),
(14, 'Omeprazole', 'Omeprazole is used to treat excess stomach acid in conditions such as non cancerous stomach ulcers, gastroesophageal reflux disease (GERD), active duodenal ulcer, Zollinger-Ellison syndrome and erosive esophagitis. Omeprazole works by blocking gastric acid production and is from the group of medicines called proton pump inhibitors.', 200),
(15, 'Amlodipine', 'Amlodipine belongs to a class of medications called calcium channel blockers. It lowers blood pressure by relaxing the blood vessels so the heart does not have to pump as hard.', 120),
(16, 'Bunavail', 'Bunavail buccal films contains a combination of buprenorphine and naloxone. Buprenorphine is an opioid medication, sometimes called a narcotic. Naloxone blocks the effects of opioid medication, including pain relief or feelings of well-being that can lead to opioid abuse.', 130),
(17, 'Hydroxychloroquine', 'Hydroxychloroquine is a quinoline medicine used to treat or prevent malaria, a disease caused by parasites that enter the body through the bite of a mosquito. Malaria is common in areas such as Africa, South America, and Southern Asia. This medicine is not effective against all strains of malaria.', 140),
(18, 'paracetamols', 'it is the type of medicine.', 500);

-- --------------------------------------------------------

--
-- Table structure for table `orderdoctor`
--

CREATE TABLE `orderdoctor` (
  `edid` int(11) NOT NULL,
  `tv` varchar(50) NOT NULL,
  `ed1` varchar(20) NOT NULL,
  `ed3` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orderdoctor`
--

INSERT INTO `orderdoctor` (`edid`, `tv`, `ed1`, `ed3`) VALUES
(12, 'Dentist', 'Prof. Dr. Umid Kumar', 2147483647),
(14, 'Dietician', 'Dr Sujan Upreti', 2147483647),
(15, 'Dentist', 'Dr Tulsi Poudel', 2147483647),
(16, 'Surgeon', 'Dr Suman Sing', 2147483647),
(17, 'Cardiologists', 'Dr Suman Sing', 2147483647),
(18, 'Family Physicians', 'Dr Anand Jha', 2147483647),
(19, 'Dietician', 'Dr Anand Jha', 2147483647),
(20, 'Dentist', 'Dr Balkrishna Bhattr', 984756575),
(21, 'Cardiologists', 'Dr Asmita Nepal', 2147483647),
(22, 'Dentist', 'Dr Asmita Nepal', 2147483647),
(23, 'Dietician', 'DR Prativa Shrestha', 2147483647),
(24, 'Family Physicians', 'Dr Tulsi Poudel', 2147483647),
(25, 'Dietician', 'Dr Suman Sing', 2147483647),
(26, 'Dentist', 'Dr Tulsi Poudel', 2147483647),
(27, 'Dietician', 'Prof. Dr. Umid Kumar', 2147483647);

-- --------------------------------------------------------

--
-- Table structure for table `orderlab`
--

CREATE TABLE `orderlab` (
  `edid` int(11) NOT NULL,
  `edname` varchar(20) NOT NULL,
  `edaddress` varchar(20) NOT NULL,
  `edcontact` varchar(20) NOT NULL,
  `edpincode` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orderlab`
--

INSERT INTO `orderlab` (`edid`, `edname`, `edaddress`, `edcontact`, `edpincode`) VALUES
(1, 'sdfg', 'sdf', '12345678', '123'),
(2, 'dinesh', 'budhabare', '9815997907', '1234'),
(3, 'pallu', 'ktm', '98060790', '123'),
(4, '', '', '', ''),
(5, 'hari om', 'birtamode', '98157675', '1234'),
(6, 'prasant', 'birtamode', '9806079013', '9876'),
(9, 'gopal', 'ktm', '987654321', '321');

-- --------------------------------------------------------

--
-- Table structure for table `ordermedicine`
--

CREATE TABLE `ordermedicine` (
  `edid` int(11) NOT NULL,
  `edname` varchar(50) NOT NULL,
  `edaddress` varchar(20) NOT NULL,
  `edcontact` int(20) NOT NULL,
  `edpincode` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ordermedicine`
--

INSERT INTO `ordermedicine` (`edid`, `edname`, `edaddress`, `edcontact`, `edpincode`) VALUES
(1, 'dinesh', 'budhabare', 2147483647, 1234),
(3, 'pallu', 'btm', 2147483647, 123),
(4, 'sita', 'govinda', 2147483647, 1234),
(5, 'sita', 'govinda', 2147483647, 1234),
(6, 'syam', 'birtamode', 2147483647, 5678),
(7, 'laxman', 'birtamode', 2147483647, 5678),
(8, 'Tika', 'birtamode', 2147483647, 5678);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `u_id` int(11) NOT NULL,
  `u_name` varchar(50) NOT NULL,
  `u_email` varchar(50) NOT NULL,
  `u_password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`u_id`, `u_name`, `u_email`, `u_password`) VALUES
(2, 'admin', 'admin@gmail.com', '$2y$10$qzCWrBGqC8JjaRRrAsmnKOpgoh3ZzVX8rvFPI/ZH4AUkSlB4yMb3S');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`d_id`),
  ADD KEY `dc_id` (`dc_id`);

--
-- Indexes for table `doctorcatagory`
--
ALTER TABLE `doctorcatagory`
  ADD PRIMARY KEY (`dc_id`);

--
-- Indexes for table `labtest`
--
ALTER TABLE `labtest`
  ADD PRIMARY KEY (`l_id`);

--
-- Indexes for table `medicine`
--
ALTER TABLE `medicine`
  ADD PRIMARY KEY (`m_id`);

--
-- Indexes for table `orderdoctor`
--
ALTER TABLE `orderdoctor`
  ADD PRIMARY KEY (`edid`);

--
-- Indexes for table `orderlab`
--
ALTER TABLE `orderlab`
  ADD PRIMARY KEY (`edid`);

--
-- Indexes for table `ordermedicine`
--
ALTER TABLE `ordermedicine`
  ADD PRIMARY KEY (`edid`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`u_id`),
  ADD UNIQUE KEY `u_email` (`u_email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `d_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `doctorcatagory`
--
ALTER TABLE `doctorcatagory`
  MODIFY `dc_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `labtest`
--
ALTER TABLE `labtest`
  MODIFY `l_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `medicine`
--
ALTER TABLE `medicine`
  MODIFY `m_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `orderdoctor`
--
ALTER TABLE `orderdoctor`
  MODIFY `edid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `orderlab`
--
ALTER TABLE `orderlab`
  MODIFY `edid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `ordermedicine`
--
ALTER TABLE `ordermedicine`
  MODIFY `edid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `doctor`
--
ALTER TABLE `doctor`
  ADD CONSTRAINT `doctor_ibfk_1` FOREIGN KEY (`dc_id`) REFERENCES `doctorcatagory` (`dc_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
