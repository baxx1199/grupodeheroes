-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-05-2021 a las 07:13:02
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `listadeheroes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `heroes`
--

CREATE TABLE `heroes` (
  `ID` int(4) NOT NULL,
  `Nombre` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `Apellido` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `Edad` int(11) NOT NULL,
  `Alias` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `Grupo` varchar(50) CHARACTER SET utf32 COLLATE utf32_spanish2_ci NOT NULL,
  `Estado` varchar(20) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `heroes`
--

INSERT INTO `heroes` (`ID`, `Nombre`, `Apellido`, `Edad`, `Alias`, `Grupo`, `Estado`) VALUES
(10003, 'Barry', 'Allen', 27, 'Flash', 'Jl', 'Activo'),
(10004, 'Oliver', 'Queen', 32, 'Green Arrow', 'Jl', 'Activo'),
(10005, 'Tony', 'Stark', 42, 'Iron Man', 'Avengers', 'Muerto'),
(10006, 'Bruce', 'Banner', 42, 'Hulk', 'Avengers', 'Desconocido'),
(10007, 'Steve', 'Rogers', 152, 'Capitan America', 'Avengers', 'Retirado'),
(10008, 'Baxx', 'Baxter', 25, 'Baxx', 'Arcania Force', 'Activo'),
(10009, 'Bucky', 'Barnes', 38, 'Winter Soldier', 'Avengers', 'Activo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `heroes`
--
ALTER TABLE `heroes`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `heroes`
--
ALTER TABLE `heroes`
  MODIFY `ID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10010;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
