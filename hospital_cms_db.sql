-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3307
-- Tiempo de generación: 19-05-2022 a las 04:59:47
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hospital_cms_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dosis`
--

CREATE TABLE `dosis` (
  `id_dosis` int(11) NOT NULL,
  `cantidad_dosis` varchar(45) DEFAULT NULL,
  `fecha_dosis` date DEFAULT NULL,
  `fecha_segunda_dosis` date DEFAULT NULL,
  `paciente_id_paciente` int(11) NOT NULL,
  `vacuna_id_vacuna` int(11) NOT NULL,
  `funcionario_id_funcionario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `funcionario`
--

CREATE TABLE `funcionario` (
  `id_funcionario` int(11) NOT NULL,
  `tipo_id` varchar(45) DEFAULT NULL,
  `nombres_funcionario` varchar(45) DEFAULT NULL,
  `apellidos_funcionario` varchar(45) DEFAULT NULL,
  `tipo_funcionario` varchar(45) DEFAULT NULL,
  `fecha_nacimiento` varchar(45) DEFAULT NULL,
  `correo_electronico` varchar(45) DEFAULT NULL,
  `profesion` varchar(45) DEFAULT NULL,
  `num_celular` varchar(11) DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `funcionario`
--

INSERT INTO `funcionario` (`id_funcionario`, `tipo_id`, `nombres_funcionario`, `apellidos_funcionario`, `tipo_funcionario`, `fecha_nacimiento`, `correo_electronico`, `profesion`, `num_celular`, `genero`) VALUES
(151515, 'Tarjeta de Identidad', 'Juan', 'Beltran', 'Epidemiólogo', 'Tue May 10 00:00:00 COT 2022', 'juan@gmail.com', 'Enfermeria', '1212121', 'M'),
(884441, 'Cédula de Ciudadania', 'Camilo', 'Arnol', 'Epidemiólogo', 'Thu May 14 00:00:00 COT 1998', 'camilo@gmail.com', 'Enfermeria', '3111455', 'Masculino'),
(10607442, 'Cédula de Ciudadania', 'Lucas Adolfo', 'Gomez Perez', 'Epidemiólogo', 'Tue May 12 21:46:01 COT 1998', 'lukas@gmail.com', 'Enfermeria', '3255221441', 'Masculino'),
(10665544, 'Cédula de Ciudadania', 'Armando', 'Gonzales', 'Epidemiólogo', 'Wed May 10 23:07:00 COT 1995', 'armando@gmail.com', 'Medicina', '3115551115', 'Masculino'),
(11155444, 'Registro Civil', 'Jose', 'pedro', 'Epidemiólogo', 'Wed May 10 00:00:00 COT 2000', 'jose@gmail.com', 'Medicina', '31514441', 'Masculino'),
(11515111, 'Registro Civil', 'Luisa', 'Diaz', 'Auxiliar Enfermería', 'Wed May 14 00:04:28 COT 1997', 'luisa@gmail.com', 'Enfermeria', '321151441', 'Femenino'),
(15552244, 'Pasaporte', 'Marcos', 'Villamizar', 'Epidemiólogo', 'Wed May 11 23:51:48 COT 2022', 'marcos@gmail.com', 'Medicina', '315544221', 'Masculino'),
(100115544, 'Cédula de Ciudadania', 'Diana', 'Lopez', 'Auxiliar Enfermería', 'Tue May 10 21:58:50 COT 2022', 'diana@gmail.com', 'Enfermeria', '3131551515', 'Femenino'),
(115554447, 'Cédula de Ciudadania', 'Maria', 'Torrez', 'Auxiliar Enfermería', 'Wed May 03 23:09:35 COT 2000', 'maria@gmail.com', 'Enfermeria', '3112515111', 'Femenino'),
(1515151111, 'Tarjeta de Identidad', 'Paula', 'Camargo Aristisaballl', 'Epidemiólogo', 'Wed May 11 23:57:09 COT 1994', 'paula@gmail.com', 'Medicina', '31155441', 'Femenino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `id_paciente` int(11) NOT NULL,
  `tipo_id` varchar(45) DEFAULT NULL,
  `nombres_paciente` varchar(45) DEFAULT NULL,
  `apellidos_paciente` varchar(45) DEFAULT NULL,
  `fecha_nacimiente` varchar(45) DEFAULT NULL,
  `direccion_residencia` varchar(45) DEFAULT NULL,
  `num_celular` varchar(45) DEFAULT NULL,
  `grupo_edad` varchar(45) DEFAULT NULL,
  `genero_paciente` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`id_paciente`, `tipo_id`, `nombres_paciente`, `apellidos_paciente`, `fecha_nacimiente`, `direccion_residencia`, `num_celular`, `grupo_edad`, `genero_paciente`) VALUES
(1144455, 'Cédula de Ciudadania', 'Paula', 'Ruiz', 'Tue May 12 23:13:37 COT 1998', 'Cra 19', '315454545', 'Adolecencia (12 - 18 años)', 'Femenino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombre_usuario` varchar(55) DEFAULT NULL,
  `tipo_usuario` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `funcionario_id_funcionario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vacuna`
--

CREATE TABLE `vacuna` (
  `id_vacuna` int(11) NOT NULL,
  `nombre_vacuna` varchar(55) DEFAULT NULL,
  `tipo_vacuna` varchar(45) DEFAULT NULL,
  `lote` varchar(45) DEFAULT NULL,
  `fecha_aplicada` date DEFAULT NULL,
  `fecha_vencimiento` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `dosis`
--
ALTER TABLE `dosis`
  ADD PRIMARY KEY (`id_dosis`),
  ADD KEY `fk_dosis_paciente1_idx` (`paciente_id_paciente`),
  ADD KEY `fk_dosis_vacuna1_idx` (`vacuna_id_vacuna`),
  ADD KEY `fk_dosis_funcionario1_idx` (`funcionario_id_funcionario`);

--
-- Indices de la tabla `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id_funcionario`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`id_paciente`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`,`funcionario_id_funcionario`),
  ADD KEY `fk_usuario_funcionario1_idx` (`funcionario_id_funcionario`);

--
-- Indices de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  ADD PRIMARY KEY (`id_vacuna`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `dosis`
--
ALTER TABLE `dosis`
  ADD CONSTRAINT `fk_dosis_funcionario1` FOREIGN KEY (`funcionario_id_funcionario`) REFERENCES `funcionario` (`id_funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_dosis_paciente1` FOREIGN KEY (`paciente_id_paciente`) REFERENCES `paciente` (`id_paciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_dosis_vacuna1` FOREIGN KEY (`vacuna_id_vacuna`) REFERENCES `vacuna` (`id_vacuna`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_funcionario1` FOREIGN KEY (`funcionario_id_funcionario`) REFERENCES `funcionario` (`id_funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
