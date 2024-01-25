-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 09-Dez-2019 às 14:43
-- Versão do servidor: 5.7.17
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbaplanta`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbcliente`
--

CREATE TABLE `tbcliente` (
  `cod_cliente` bigint(10) NOT NULL,
  `nome_cliente` varchar(255) DEFAULT NULL,
  `nascimento_cliente` varchar(255) DEFAULT NULL,
  `cpf_cliente` varchar(255) DEFAULT NULL,
  `telefone_cliente` varchar(255) DEFAULT NULL,
  `cidade_cliente` varchar(255) DEFAULT NULL,
  `bairro_cliente` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbcompra`
--

CREATE TABLE `tbcompra` (
  `cod_compra` bigint(10) NOT NULL,
  `cod_planta_compra` varchar(255) DEFAULT NULL,
  `cod_cliente_compra` varchar(255) DEFAULT NULL,
  `quantidade_compra` int(11) DEFAULT NULL,
  `valor_compra` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbplanta`
--

CREATE TABLE `tbplanta` (
  `cod_planta` bigint(10) NOT NULL,
  `nome_planta` varchar(255) DEFAULT NULL,
  `nomec_planta` varchar(255) DEFAULT NULL,
  `area_planta` varchar(255) DEFAULT NULL,
  `qtd_planta` int(255) DEFAULT NULL,
  `valor` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbcliente`
--
ALTER TABLE `tbcliente`
  ADD PRIMARY KEY (`cod_cliente`);

--
-- Indexes for table `tbcompra`
--
ALTER TABLE `tbcompra`
  ADD PRIMARY KEY (`cod_compra`);

--
-- Indexes for table `tbplanta`
--
ALTER TABLE `tbplanta`
  ADD PRIMARY KEY (`cod_planta`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbcliente`
--
ALTER TABLE `tbcliente`
  MODIFY `cod_cliente` bigint(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `tbcompra`
--
ALTER TABLE `tbcompra`
  MODIFY `cod_compra` bigint(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `tbplanta`
--
ALTER TABLE `tbplanta`
  MODIFY `cod_planta` bigint(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
