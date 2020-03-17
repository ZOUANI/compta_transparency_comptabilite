-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 17 mars 2020 à 17:24
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.4.1

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `compta_transparency_comptabilite`
--

-- --------------------------------------------------------

--
-- Structure de la table `banque`
--

CREATE TABLE `banque` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `caisse`
--

CREATE TABLE `caisse` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `solde` decimal(16,4) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `classe_comptable`
--

CREATE TABLE `classe_comptable` (
  `id` bigint(20) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `compte_banquaire`
--

CREATE TABLE `compte_banquaire` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `solde` decimal(16,4) DEFAULT NULL,
  `banque` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `compte_comptable`
--

CREATE TABLE `compte_comptable` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `sous_classe_comptable` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `etat_operation_comptable`
--

CREATE TABLE `etat_operation_comptable` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `operation_comptable`
--

CREATE TABLE `operation_comptable` (
  `id` bigint(20) NOT NULL,
  `date_operation_comptable` datetime DEFAULT NULL,
  `date_saisie` datetime DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `montant` decimal(16,4) DEFAULT NULL,
  `reference_facture` varchar(255) DEFAULT NULL,
  `reference_societe` varchar(255) DEFAULT NULL,
  `caisse` bigint(20) DEFAULT NULL,
  `compte_banquaire` bigint(20) DEFAULT NULL,
  `compte_comptable` bigint(20) DEFAULT NULL,
  `type_operation` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `sous_classe_comptable`
--

CREATE TABLE `sous_classe_comptable` (
  `id` bigint(20) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `classe_comptable` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `type_operation`
--

CREATE TABLE `type_operation` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `banque`
--
ALTER TABLE `banque`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `caisse`
--
ALTER TABLE `caisse`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `classe_comptable`
--
ALTER TABLE `classe_comptable`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `compte_banquaire`
--
ALTER TABLE `compte_banquaire`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5h83te6mo1kbviol8f9wvltbe` (`banque`);

--
-- Index pour la table `compte_comptable`
--
ALTER TABLE `compte_comptable`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKajf6wdmvrh66jg39vg1aryt4m` (`sous_classe_comptable`);

--
-- Index pour la table `etat_operation_comptable`
--
ALTER TABLE `etat_operation_comptable`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `operation_comptable`
--
ALTER TABLE `operation_comptable`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkt5dw93eim2uotngttopfiexv` (`caisse`),
  ADD KEY `FK94bwi32777cshjsmg9i99empl` (`compte_banquaire`),
  ADD KEY `FKj0grkgxvo0dmltj7g30hdnrlr` (`compte_comptable`),
  ADD KEY `FKmd9vimqjkn8mrc88l1ury57yb` (`type_operation`);

--
-- Index pour la table `sous_classe_comptable`
--
ALTER TABLE `sous_classe_comptable`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhacjc0ryy5m37e5fb4cftpsia` (`classe_comptable`);

--
-- Index pour la table `type_operation`
--
ALTER TABLE `type_operation`
  ADD PRIMARY KEY (`id`);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
