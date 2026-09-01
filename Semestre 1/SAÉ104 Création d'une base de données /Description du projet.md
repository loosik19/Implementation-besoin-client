# Rapportage de la station balnéaire

Projet réalisé dans le cadre de la SAÉ S1.04 à l’Université Sorbonne Paris Nord (IUT de Villetaneuse).

## Description

Ce projet consiste à concevoir et peupler une base de données permettant de gérer et de rapporter les informations relatives aux stations balnéaires et aux sites de baignade.

L’objectif est de mettre en place une base de données structurée permettant de centraliser différentes informations concernant :

- les régions ;
- les départements ;
- les communes ;
- les sites de baignade ;
- les analyses bactériologiques ;
- les événements liés aux saisons balnéaires.

Le projet comprend également une modélisation de la base de données à l’aide de l’Atelier de Génie Logiciel (AGL) **pgModeler**, ainsi que la création manuelle et automatique des tables en SQL.

## Compétence

Administrer des systèmes informatiques communicants complexes

## Fonctionnalités

Le projet permet :

- de créer une base de données relationnelle ;
- de créer les différentes tables nécessaires au stockage des données ;
- de définir les clés primaires et les clés étrangères ;
- de mettre en place les contraintes d’intégrité entre les différentes tables ;
- de modéliser la base de données avec pgModeler ;
- de générer automatiquement un script SQL à partir du modèle ;
- d’importer les données provenant de fichiers CSV ;
- d’utiliser des tables temporaires pour préparer les données ;
- de peupler les tables finales à partir des données importées ;
- de gérer les informations concernant les sites de baignade et les analyses effectuées.

## Fonctionnalités principales

- Modélisation conceptuelle et physique de la base de données
- Création manuelle de tables SQL
- Génération automatique de scripts SQL avec pgModeler
- Gestion des clés primaires et étrangères
- Gestion des associations entre les tables
- Importation de fichiers CSV
- Utilisation de tables temporaires
- Peuplement de la base de données
- Manipulation et projection des données
- Utilisation de PostgreSQL et de la commande `\COPY`

## Technologies utilisées

- PostgreSQL
- SQL
- pgModeler
- Fichiers CSV
- Commande `\COPY`

## Objectif pédagogique

Ce projet a permis de pratiquer :

- la conception d’une base de données relationnelle ;
- la modélisation conceptuelle et physique des données ;
- la création de tables en SQL ;
- l’utilisation des clés primaires et des clés étrangères ;
- la mise en place de contraintes d’intégrité ;
- l’utilisation d’un Atelier de Génie Logiciel (AGL) ;
- la génération automatique de scripts SQL ;
- l’importation de données depuis des fichiers CSV ;
- la création et l’utilisation de tables temporaires ;
- le peuplement d’une base de données ;
- la manipulation de données avec des requêtes SQL ;
- la comparaison entre une création manuelle et automatique d’une base de données.

## Remarque

Certaines projections de données n’ont pas pu être réalisées complètement, notamment les liens entre les sites, les analyses et les événements. De même, l’attribut permettant de relier les départements aux communes n’a pas été correctement projeté lors du peuplement. Le script généré automatiquement par pgModeler a également rencontré une erreur de permission lors de la tentative d’attribution du rôle `postgres`.

## Auteur

Kuruparan PATHMARANJAN
