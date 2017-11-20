create database trabalho;
use trabalho;
-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 16-Out-2017 às 21:44
-- Versão do servidor: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `trabalho`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `agenda`
--

CREATE TABLE `agenda` (
  `idAgenda` int(11) NOT NULL,
  `titulo` varchar(200) NOT NULL,
  `prioridade` varchar(10) NOT NULL,
  `data` varchar(15) DEFAULT NULL,
  `hora` varchar(6) DEFAULT NULL,
  `idFuncionario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `agenda`
--

INSERT INTO `agenda` (`idAgenda`, `titulo`, `prioridade`, `data`, `hora`, `idFuncionario`) VALUES
(1, 'dsadsada', 'Média', '12', '12', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `beneficio`
--

CREATE TABLE `beneficio` (
  `idBeneficio` int(11) NOT NULL,
  `beneficio` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cargo`
--

CREATE TABLE `cargo` (
  `idCargo` int(11) NOT NULL,
  `cargo` varchar(45) DEFAULT NULL,
  `id_departamento` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cargo`
--

INSERT INTO `cargo` (`idCargo`, `cargo`, `id_departamento`) VALUES
(1, 'Programador', 1),
(2, 'Analista de Processos', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `departamento`
--

CREATE TABLE `departamento` (
  `idDepartamento` int(11) NOT NULL,
  `departamento` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `departamento`
--

INSERT INTO `departamento` (`idDepartamento`, `departamento`) VALUES
(1, 'RH'),
(2, 'Desenvolvimento'),
(3, 'Testes'),
(4, 'Desenvoiunfepvjue'),
(5, 'dasdad'),
(7, 'testeeeeeeeee');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `idFuncionario` int(11) NOT NULL,
  `funcionario` varchar(220) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`idFuncionario`, `funcionario`) VALUES
(1, 'Jão');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agenda`
--
ALTER TABLE `agenda`
  ADD PRIMARY KEY (`idAgenda`),
  ADD KEY `FK_AGENDA_FUNCIONARIO` (`idFuncionario`);

--
-- Indexes for table `beneficio`
--
ALTER TABLE `beneficio`
  ADD PRIMARY KEY (`idBeneficio`);

--
-- Indexes for table `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`idCargo`),
  ADD KEY `FK_DEPARTMANETO` (`id_departamento`);

--
-- Indexes for table `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`idDepartamento`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`idFuncionario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `agenda`
--
ALTER TABLE `agenda`
  MODIFY `idAgenda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `beneficio`
--
ALTER TABLE `beneficio`
  MODIFY `idBeneficio` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `cargo`
--
ALTER TABLE `cargo`
  MODIFY `idCargo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `departamento`
--
ALTER TABLE `departamento`
  MODIFY `idDepartamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `idFuncionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
 alter table funcionario add cpf varchar(45);
 alter table funcionario add nome varchar(45);
 alter table funcionario add rg varchar(45);
 alter table funcionario add naturalidade varchar(45);
 alter table funcionario add beneficio varchar(45);
 alter table funcionario add dataNasc varchar(45);
 alter table funcionario add dataAdmissao varchar(45);
 alter table funcionario add descricao varchar(45);
-- Constraints for dumped tables

alter table funcionario change funcionario nome_funcionario varchar(45); 
--

--
-- Limitadores para a tabela `agenda`
--
ALTER TABLE `agenda`
  ADD CONSTRAINT `FK_AGENDA_FUNCIONARIO` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`idFuncionario`);

--
-- Limitadores para a tabela `cargo`
--
ALTER TABLE `cargo`
  ADD CONSTRAINT `FK_DEPARTMANETO` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`idDepartamento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

alter table funcionario add codigo int(45);
alter table funcionario add situacao varchar(45);
alter table funcionario add cargo int(4);
alter table funcianorio change cargo cargo int(4);
