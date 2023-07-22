-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 20, 2023 at 06:50 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `road_resolve`
--

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `ip_address` varchar(64) NOT NULL,
  `date` datetime NOT NULL DEFAULT current_timestamp(),
  `user_agent` varchar(256) NOT NULL,
  `location` text NOT NULL,
  `comments` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`id`, `name`, `email`, `ip_address`, `date`, `user_agent`, `location`, `comments`) VALUES
(18, 'Siti Sarah', 'ssarahesha26@gmail.com', '10.20.153.195', '2023-07-19 23:22:54', 'Dalvik/2.1.0 (Linux; U; Android 13; sdk_gphone64_x86_64 Build/TE1A.220922.010)', 'selangor', 'potholes'),
(19, 'Siti Sarah', 'ssarahesha26@gmail.com', '10.20.153.195', '2023-07-20 03:03:02', 'Dalvik/2.1.0 (Linux; U; Android 13; sdk_gphone64_x86_64 Build/TE1A.220922.010)', 'arau', 'roadkill'),
(20, 'Siti Sarah', 'ssarahesha26@gmail.com', '10.20.153.195', '2023-07-20 03:12:10', 'Dalvik/2.1.0 (Linux; U; Android 13; sdk_gphone64_x86_64 Build/TE1A.220922.010)', 'cyberjaya', 'broken traffic light'),
(21, 'Siti Sarah', 'ssarahesha26@gmail.com', '10.20.153.195', '2023-07-20 03:19:55', 'Dalvik/2.1.0 (Linux; U; Android 13; sdk_gphone64_x86_64 Build/TE1A.220922.010)', 'ldp highway', 'vehicle stopped'),
(22, 'Siti Sarah', 'ssarahesha26@gmail.com', '10.20.153.195', '2023-07-20 03:21:02', 'Dalvik/2.1.0 (Linux; U; Android 13; sdk_gphone64_x86_64 Build/TE1A.220922.010)', 'mex highway', 'object on road');

-- --------------------------------------------------------

--
-- Table structure for table `news`
--

CREATE TABLE `news` (
  `news_id` int(11) NOT NULL,
  `news_title` varchar(255) NOT NULL,
  `news_desc` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `news`
--

INSERT INTO `news` (`news_id`, `news_title`, `news_desc`) VALUES
(9, 'Highway Plus', 'Traffic Jam from ayer tawar to alor setar'),
(10, 'Highway Plus Updated', 'The is an accident on 290KM');

-- --------------------------------------------------------

--
-- Table structure for table `plan`
--

CREATE TABLE `plan` (
  `plan_id` int(11) NOT NULL,
  `plan_name` varchar(255) NOT NULL,
  `plan_price` int(11) DEFAULT NULL,
  `plan_discount` int(11) DEFAULT NULL,
  `plan_shippingfee` int(11) DEFAULT NULL,
  `plan_reward` decimal(11,1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `plan`
--

INSERT INTO `plan` (`plan_id`, `plan_name`, `plan_price`, `plan_discount`, `plan_shippingfee`, `plan_reward`) VALUES
(1, 'Admin', 0, 0, 0, NULL),
(2, 'Bronze', 0, 3, 0, '2.0'),
(3, 'Silver', 10, 5, 5, '2.5'),
(4, 'Gold', 25, 10, 10, '3.0');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL,
  `plan_id` int(11) NOT NULL,
  `role_name` varchar(255) NOT NULL,
  `role_phone` varchar(11) NOT NULL,
  `role_address` varchar(255) NOT NULL,
  `role_email` varchar(255) NOT NULL,
  `role_password` varchar(255) NOT NULL,
  `role_point` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`role_id`, `plan_id`, `role_name`, `role_phone`, `role_address`, `role_email`, `role_password`, `role_point`) VALUES
(1, 1, 'Admin', '0123456789', 'admin', 'admin@mail.com', '123', NULL),
(2, 1, 'Admin2', '0173694106', 'admin', 'admin2@mail.com', '123', NULL),
(3, 2, 'Ahmad Amin', '012321341', 'no59, Jln jati 6, Tmn RPA, 0600, arau, perlis', 'amin@mail.com', 'amin123', 11),
(4, 4, 'Syazwa Izzatie', '0125894944', 'no.9, Jalan Seri 7/2, Taman Rasa, 09010,Sungai Petani, Kedah', 'syazwa@mail.com', 'syazwa123', 33),
(5, 3, 'Shah Rizal', '0118459612', 'no.59 jalan melur 7, tmn bunga, 08001, bangan serai, perak', 'shah@mail.com', 'shah123', 30),
(6, 3, 'Afiqah farzana', '015894644', 'no.13, jalan polo air, taman sukan,  41000, shah alam, selangor', 'fiqah@mail.com', 'fiqah123', 29),
(9, 2, 'Nur Umairah', '0193239971', 'A-11-20, Ketumbar Heights Condo, Taman Yulek Cheras Strata, Cheras', 'umairah@mail.com', 'umairah123', 17),
(10, 4, 'Putera Iskandar bin A Khalid', '0172369793', 'No 19 Lebuh Bagor Persiaran Seraya Taman Petaling Indah 41200 Klang', 'putera@gmail.com', '123', 70),
(15, 4, 'Muhammad Syamim', '0192827363', 'No 12 Jalan Stesen 33000 Arau Perlis', 'syamim@mail.com', 'syamim123', 3),
(16, 4, 'Tengku Muhammad Fariz', '0139764546', 'No 12 Taman Titi Wangsa Maju 40010 Kuala Lumpur', 'tengku@mail.com', '123', NULL),
(30, 2, 'Test', '123452', 'Taman Chi Liung 41200 Klang', 'test@mail.com', '123', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`news_id`);

--
-- Indexes for table `plan`
--
ALTER TABLE `plan`
  ADD PRIMARY KEY (`plan_id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`role_id`),
  ADD KEY `plan_id` (`plan_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `news`
--
ALTER TABLE `news`
  MODIFY `news_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `plan`
--
ALTER TABLE `plan`
  MODIFY `plan_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `roles`
--
ALTER TABLE `roles`
  ADD CONSTRAINT `roles_ibfk_1` FOREIGN KEY (`plan_id`) REFERENCES `plan` (`plan_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
