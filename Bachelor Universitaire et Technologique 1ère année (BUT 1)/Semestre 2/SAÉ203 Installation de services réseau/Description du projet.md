# Installation et administration de services réseaux

Projet réalisé dans le cadre de la **SAÉ 2.03 : Installation de services réseaux** en BUT Informatique.

## Description

Cette SAÉ avait pour objectif de mettre en place et d’administrer différents **services réseaux** sur un PC sous Linux. Nous avons notamment travaillé sur la mise en place d’un environnement **LAMP**, composé de Linux, Apache, MariaDB et PHP.

Le projet nous a permis d’installer et de configurer un **serveur web Apache**, une **base de données MariaDB** ainsi que l’interaction entre PHP et MariaDB afin de créer une page web dynamique capable d’afficher des données provenant de la base de données.

Nous avons également configuré différents services réseau tels que **FTP avec vsftpd** et **SSH**, en appliquant certaines règles de configuration et de sécurité. Le service SSH a notamment été configuré afin d’interdire les connexions avec le compte root et d’utiliser un port d’écoute personnalisé.

Une partie du projet était également consacrée à l’**analyse des communications réseau avec Wireshark**, afin d’observer les échanges entre les différents protocoles et de comprendre leur encapsulation.

Enfin, nous avons utilisé **VirtualBox et Marionnet** afin de mettre en place une machine virtuelle et de réaliser des travaux pratiques liés aux réseaux.

Cette SAÉ m’a permis de développer mes compétences en **administration système, configuration de services réseau, gestion de bases de données, sécurisation des communications et virtualisation**.

## Compétence

**Administrer des systèmes informatiques communicants complexes**

## Fonctionnalités

- Installation et configuration d’un environnement LAMP
- Installation et configuration du serveur web Apache
- Installation et administration de MariaDB
- Configuration de l’interaction entre PHP et MariaDB
- Création et gestion d’une base de données
- Création et manipulation de tables SQL
- Mise en place d’une page web dynamique
- Configuration d’un serveur FTP avec vsftpd
- Gestion des accès anonymes et utilisateurs locaux
- Installation et configuration d’un serveur SSH
- Sécurisation de l’accès SSH
- Analyse des échanges réseau avec Wireshark
- Mise en place d’une machine virtuelle avec VirtualBox
- Utilisation de Marionnet pour les travaux pratiques réseau
- Gestion des utilisateurs et des droits sous Linux

## Fonctionnalités principales

### 🌐 Serveur web Apache

- Installation et utilisation du serveur Apache
- Configuration des pages personnelles
- Mise en place d’un répertoire `public_html`
- Création d’une page web dynamique
- Utilisation de PHP pour interagir avec la base de données
- Test du serveur web en local

### 🗄️ Base de données MariaDB

- Installation de MariaDB
- Création d’un utilisateur MariaDB
- Création d’une base de données
- Attribution des privilèges à un utilisateur
- Création et gestion de tables SQL
- Insertion et récupération de données
- Connexion à MariaDB depuis PHP grâce à PDO

### 🐘 PHP et pages dynamiques

- Mise en place d’une page `index.php`
- Connexion à MariaDB avec PDO
- Exécution de requêtes SQL depuis PHP
- Récupération des données de la base
- Affichage dynamique des données dans une page HTML

### 🔐 Sécurisation des services

- Protection d’une page web avec un fichier `.htaccess`
- Gestion des utilisateurs et groupes sous Linux
- Attribution de droits et privilèges
- Configuration sécurisée du serveur SSH
- Désactivation de la connexion SSH avec le compte root
- Utilisation d’un port SSH personnalisé
- Mise en place d’une authentification par clé publique

### 📁 Serveur FTP

- Installation et configuration de `vsftpd`
- Autorisation des connexions anonymes
- Limitation des droits des utilisateurs anonymes
- Autorisation des utilisateurs locaux
- Gestion des téléchargements et téléversements
- Tests du serveur avec `lftp`
- Analyse des échanges FTP avec Wireshark

### 🔎 Analyse réseau avec Wireshark

- Capture de trames réseau
- Analyse des échanges HTTP
- Observation des différents niveaux d’encapsulation
- Analyse des communications FTP
- Observation des différences entre communications non chiffrées et sécurisées
- Compréhension du rôle des protocoles réseau

### 🖥️ Virtualisation et réseau

- Installation de VirtualBox
- Importation d’une machine virtuelle Debian
- Mise en place d’un dossier partagé entre la machine physique et la machine virtuelle
- Utilisation de Marionnet
- Réalisation d’un travail pratique sur l’adressage réseau CIDR

## Technologies utilisées

- **Linux / Debian** — administration du système
- **Apache** — serveur web
- **MariaDB** — système de gestion de base de données
- **PHP** — développement de pages web dynamiques
- **SQL** — gestion et manipulation des données
- **PDO** — connexion entre PHP et MariaDB
- **FTP / vsftpd** — transfert de fichiers
- **SSH** — administration distante sécurisée
- **Wireshark** — analyse des trames réseau
- **VirtualBox** — virtualisation
- **Marionnet** — simulation et configuration réseau
- **lftp** — client FTP

## Objectif pédagogique

Cette SAÉ avait pour objectif de nous faire découvrir et mettre en pratique l’**installation, la configuration et l’administration de services réseau couramment utilisés dans le monde professionnel**.

Elle m’a notamment permis de développer mes compétences en :

- Administration système Linux
- Installation de services réseau
- Configuration d’un serveur web
- Gestion d’une base de données MariaDB
- Utilisation de PHP avec une base de données
- Gestion des utilisateurs et des droits
- Configuration d’un serveur FTP
- Configuration et sécurisation d’un serveur SSH
- Analyse de trames réseau avec Wireshark
- Compréhension des protocoles et de leur encapsulation
- Virtualisation avec VirtualBox
- Configuration et simulation de réseaux avec Marionnet
- Sécurisation des communications réseau

Cette SAÉ m’a également permis de mieux comprendre le fonctionnement d’une infrastructure réseau et les interactions entre les différents services qui la composent.

## Remarque

Ce projet m’a permis de travailler sur plusieurs aspects de l’administration informatique :

**Installation → Configuration → Administration → Sécurisation → Analyse**

La mise en place de l’environnement LAMP m’a notamment permis de comprendre l’interaction entre un serveur web, une base de données et un langage côté serveur.

L’utilisation de Wireshark, VirtualBox et Marionnet m’a également permis d’approfondir mes connaissances sur les communications réseau, la virtualisation et l’administration des systèmes.

## Auteur

**Kuruparan PATHMARANJAN**
