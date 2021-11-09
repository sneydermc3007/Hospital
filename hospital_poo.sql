-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-11-2021 a las 02:00:46
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hospital_poo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_auxiliar`
--

CREATE TABLE `tbl_auxiliar` (
  `FK_ID_TURNO` int(11) NOT NULL,
  `FK_ID_PACIENTE` int(11) NOT NULL,
  `FK_ID_MEDICO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_medico`
--

CREATE TABLE `tbl_medico` (
  `ID_MEDICO` int(11) NOT NULL,
  `Nombre_M` varchar(30) NOT NULL,
  `Apellido_M` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_paciente`
--

CREATE TABLE `tbl_paciente` (
  `ID_PACIENTE` int(11) NOT NULL,
  `Nombre_P` varchar(30) NOT NULL,
  `Apellido` varchar(40) NOT NULL,
  `Fecha_Nacimiento` date NOT NULL,
  `Domicilio` varchar(50) NOT NULL,
  `ID_Pais` char(3) NOT NULL,
  `Telefono` varchar(20) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Observacion` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_turno`
--

CREATE TABLE `tbl_turno` (
  `ID_TURNO` int(11) NOT NULL,
  `Fecha_Turno` datetime NOT NULL,
  `Estado` varchar(2) DEFAULT 'si',
  `Observacion` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbl_auxiliar`
--
ALTER TABLE `tbl_auxiliar`
  ADD KEY `FK_ID_TURNO` (`FK_ID_TURNO`),
  ADD KEY `FK_ID_PACIENTE` (`FK_ID_PACIENTE`),
  ADD KEY `FK_ID_MEDICO` (`FK_ID_MEDICO`);

--
-- Indices de la tabla `tbl_medico`
--
ALTER TABLE `tbl_medico`
  ADD PRIMARY KEY (`ID_MEDICO`);

--
-- Indices de la tabla `tbl_paciente`
--
ALTER TABLE `tbl_paciente`
  ADD PRIMARY KEY (`ID_PACIENTE`);

--
-- Indices de la tabla `tbl_turno`
--
ALTER TABLE `tbl_turno`
  ADD PRIMARY KEY (`ID_TURNO`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbl_auxiliar`
--
ALTER TABLE `tbl_auxiliar`
  ADD CONSTRAINT `tbl_auxiliar_ibfk_1` FOREIGN KEY (`FK_ID_TURNO`) REFERENCES `tbl_turno` (`ID_TURNO`),
  ADD CONSTRAINT `tbl_auxiliar_ibfk_2` FOREIGN KEY (`FK_ID_PACIENTE`) REFERENCES `tbl_paciente` (`ID_PACIENTE`),
  ADD CONSTRAINT `tbl_auxiliar_ibfk_3` FOREIGN KEY (`FK_ID_MEDICO`) REFERENCES `tbl_medico` (`ID_MEDICO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
