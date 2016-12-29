-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Дек 29 2016 г., 16:40
-- Версия сервера: 10.1.19-MariaDB
-- Версия PHP: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `web_store`
--

-- --------------------------------------------------------

--
-- Структура таблицы `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'Netbook'),
(2, 'For work and study'),
(3, 'Gaming');

-- --------------------------------------------------------

--
-- Структура таблицы `laptop`
--

CREATE TABLE `laptop` (
  `id` int(11) NOT NULL,
  `producer` int(30) NOT NULL,
  `model` varchar(30) NOT NULL,
  `cost` int(11) NOT NULL,
  `image` varchar(60) NOT NULL,
  `category` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `laptop`
--

INSERT INTO `laptop` (`id`, `producer`, `model`, `cost`, `image`, `category`) VALUES
(1, 1, 'acer', 1000, 'img\\acer2.jpg', 2),
(2, 1, 'acer', 1200, 'img\\acer3.jpg', 2),
(3, 3, 'apple', 1900, 'img\\apple.jpg', 3),
(4, 5, 'hp', 1300, 'img\\hp.jpg', 3),
(5, 5, 'hp', 1200, 'img\\hp2.jpg', 2),
(6, 5, 'hp', 1300, 'img\\hp06.jpg', 2),
(7, 6, 'lenovo', 1000, 'img\\len.png', 3),
(8, 4, 'dell', 1200, 'img\\oi.jpg', 2),
(9, 7, 'samsung', 1500, 'img\\sams.jpg', 3),
(10, 8, 'apple', 2500, '', 1),
(11, 8, 'apple', 2100, '', 1),
(12, 8, 'apple', 1800, '', 1),
(13, 8, 'apple', 1900, '', 1),
(14, 8, 'apple', 2200, '', 1),
(15, 8, 'apple', 1800, '', 1),
(16, 8, 'apple', 1600, '', 1),
(17, 8, 'apple', 1600, '', 1),
(18, 8, 'apple', 1600, '', 1),
(19, 8, 'apple', 1600, '', 1),
(20, 8, 'apple', 1600, '', 1),
(21, 8, 'apple', 1600, '', 1),
(22, 8, 'apple', 1600, '', 1),
(23, 8, 'apple', 1600, '', 1);

-- --------------------------------------------------------

--
-- Дублирующая структура для представления `laptops`
--
CREATE TABLE `laptops` (
`id` int(11)
,`producer` varchar(30)
,`model` varchar(30)
,`cost` int(11)
,`image` varchar(60)
,`category` varchar(30)
);

-- --------------------------------------------------------

--
-- Структура таблицы `order`
--

CREATE TABLE `order` (
  `id` int(11) NOT NULL,
  `status` enum('accepted','confirmed','formed','expelled','done','canceled') NOT NULL,
  `specification_status` varchar(30) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Структура таблицы `producer`
--

CREATE TABLE `producer` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `producer`
--

INSERT INTO `producer` (`id`, `name`) VALUES
(1, 'Acer'),
(2, 'Asus'),
(3, 'Apple'),
(4, 'Dell'),
(5, 'HP'),
(6, 'Lenovo'),
(7, 'Samsung'),
(8, 'Zan');

-- --------------------------------------------------------

--
-- Структура таблицы `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'user'),
(2, 'admin');

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `mobileNumber` bigint(20) NOT NULL,
  `failedLogin` int(11) NOT NULL,
  `banWillBeRemoved` time NOT NULL,
  `role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `firstName`, `lastName`, `email`, `password`, `mobileNumber`, `failedLogin`, `banWillBeRemoved`, `role`) VALUES
(1, 'arsalan', 'ars', 'ars', 'ars', 0, 0, '11:28:13', 1),
(5, 'Kester20', 'Kester20', 'arsalan.noormal@gmail.com', '11111111', 934096374, 0, '00:00:00', 1);

-- --------------------------------------------------------

--
-- Дублирующая структура для представления `usersview`
--
CREATE TABLE `usersview` (
`id` int(11)
,`firstName` varchar(30)
,`lastName` varchar(30)
,`email` varchar(30)
,`password` varchar(30)
,`mobileNumber` bigint(20)
,`failedLogin` int(11)
,`banWillBeRemoved` time
,`name` varchar(10)
);

-- --------------------------------------------------------

--
-- Структура для представления `laptops`
--
DROP TABLE IF EXISTS `laptops`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `laptops`  AS  select `laptop`.`id` AS `id`,`producer`.`name` AS `producer`,`laptop`.`model` AS `model`,`laptop`.`cost` AS `cost`,`laptop`.`image` AS `image`,`category`.`name` AS `category` from ((`laptop` join `producer`) join `category` on(((`laptop`.`producer` = `producer`.`id`) and (`laptop`.`category` = `category`.`id`)))) order by `laptop`.`id` ;

-- --------------------------------------------------------

--
-- Структура для представления `usersview`
--
DROP TABLE IF EXISTS `usersview`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `usersview`  AS  select `users`.`id` AS `id`,`users`.`firstName` AS `firstName`,`users`.`lastName` AS `lastName`,`users`.`email` AS `email`,`users`.`password` AS `password`,`users`.`mobileNumber` AS `mobileNumber`,`users`.`failedLogin` AS `failedLogin`,`users`.`banWillBeRemoved` AS `banWillBeRemoved`,`role`.`name` AS `name` from (`users` join `role` on((`users`.`role` = `role`.`id`))) ;

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `laptop`
--
ALTER TABLE `laptop`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `producer`
--
ALTER TABLE `producer`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `laptop`
--
ALTER TABLE `laptop`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT для таблицы `order`
--
ALTER TABLE `order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `producer`
--
ALTER TABLE `producer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT для таблицы `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
