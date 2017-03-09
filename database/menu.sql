-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2017-03-06 01:28:34
-- 服务器版本： 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tjzhic`
--

-- --------------------------------------------------------

--
-- 表的结构 `menu`
--

CREATE TABLE `menu` (
  `id` mediumint(8) NOT NULL,
  `menu_num` mediumint(8) NOT NULL,
  `menu_parentnum` mediumint(8) NOT NULL,
  `menu_class` mediumint(8) NOT NULL,
  `menu_name` varchar(128) NOT NULL,
  `menu_url` varchar(128) NOT NULL,
  `menu_group` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `menu`
--

INSERT INTO `menu` (`id`, `menu_num`, `menu_parentnum`, `menu_class`, `menu_name`, `menu_url`, `menu_group`) VALUES
(1, 0, 0, 0, '系统状态', 'pages/state.jsp', 'sysadmin'),
(2, 1, 0, 0, '阶段定义', 'pages/setstate.jsp', 'sysadmin'),
(3, 3, 0, 0, '管理员维护', 'pages/sysadmin.jsp', 'sysadmin'),
(4, 4, 0, 0, '数据库管理', 'pages/database.jsp', 'sysadmin'),
(5, 5, 0, 0, '登陆历史', 'pages/history.jsp', 'sysadmin'),
(6, 6, 0, 0, '修改密码', 'pages/password.jsp', 'sysadmin'),
(7, 7, 0, 0, '退出系统', 'pages/logout.jsp', 'sysadmin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `menu`
--
ALTER TABLE `menu`
  MODIFY `id` mediumint(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
