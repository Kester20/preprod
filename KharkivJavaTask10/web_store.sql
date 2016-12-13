-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Дек 14 2016 г., 00:24
-- Версия сервера: 10.1.13-MariaDB
-- Версия PHP: 7.0.8

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
(3, 'Gaming ');

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
(9, 7, 'samsung', 1500, 'img\\sams.jpg', 3);

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
(7, 'Samsung');

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
  `mobileNumber` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `firstName`, `lastName`, `email`, `password`, `mobileNumber`) VALUES
(1, 'arsalan', 'ars', 'ars', 'ars', 0),
(5, 'Kester20', 'Kester20', 'arsalan.noormal@gmail.com', '11111111', 934096374);

-- --------------------------------------------------------

--
-- Структура для представления `laptops`
--
DROP TABLE IF EXISTS `laptops`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `laptops`  AS  select `laptop`.`id` AS `id`,`producer`.`name` AS `producer`,`laptop`.`model` AS `model`,`laptop`.`cost` AS `cost`,`laptop`.`image` AS `image`,`category`.`name` AS `category` from ((`laptop` join `producer`) join `category` on(((`laptop`.`producer` = `producer`.`id`) and (`laptop`.`category` = `category`.`id`)))) ;

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
-- Индексы таблицы `producer`
--
ALTER TABLE `producer`
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT для таблицы `producer`
--
ALTER TABLE `producer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
