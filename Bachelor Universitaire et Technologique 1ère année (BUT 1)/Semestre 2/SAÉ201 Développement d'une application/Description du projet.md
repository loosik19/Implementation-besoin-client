# Find My Word

Projet réalisé dans le cadre de la **SAÉ S2.01 : Développement d'une application** en BUT Informatique.

## Description

Ce projet consiste à développer une application appelée **Find My Word**, inspirée du célèbre jeu **Wordle**.

Le principe du jeu est de faire deviner à un joueur un mot secret de **5 lettres** en un maximum de **6 tentatives**. Après chaque proposition, le programme analyse les lettres du mot proposé et indique si elles sont :

- **OK** : la lettre est correctement placée
- **PRESENT** : la lettre est présente dans le mot mais mal positionnée
- **ABSENT** : la lettre n'est pas présente dans le mot recherché

L'objectif de cette SAÉ était de concevoir une application fonctionnelle tout en respectant les principes de la **programmation orientée objet**, notamment l'encapsulation, la séparation des responsabilités et l'utilisation du polymorphisme.

Le projet comprend également une modélisation UML permettant de représenter la structure de l'application et les relations entre les différentes classes.

## Compétence

**Développer une application informatique**

## Fonctionnalités

- Jeu de devinettes basé sur un mot secret de 5 lettres
- Maximum de 6 tentatives par partie
- Vérification de la validité des mots proposés
- Analyse des lettres proposées
- Indication des lettres correctement placées, présentes ou absentes
- Sélection aléatoire du mot secret
- Mode de test avec un mot fixe
- Gestion de deux joueurs
- Gestion des tours de jeu
- Système de score
- Chronomètre pour mesurer le temps de jeu
- Historique des parties
- Détermination du vainqueur
- Gestion de l'égalité grâce au temps
- Possibilité de rejouer une partie

## Fonctionnalités principales

### 🎮 Déroulement du jeu

- Saisie des propositions des joueurs
- Vérification des mots avant validation
- Gestion d'un maximum de 6 tentatives
- Affichage d'une grille textuelle après chaque essai
- Alternance entre les deux joueurs
- Vérification des conditions de victoire et de défaite

### 🔤 Gestion des mots

La classe `Word` permet de gérer la logique associée aux mots.

- Vérification qu'un mot contient exactement 5 lettres
- Vérification que le mot contient uniquement des caractères alphabétiques
- Vérification de l'absence de doublons
- Comparaison entre le mot proposé et le mot secret
- Génération des résultats `OK`, `PRESENT` et `ABSENT`
- Gestion autonome de la validité des propositions

### 🗂️ Gestion des mots avec le polymorphisme

Le projet utilise le **polymorphisme** afin de permettre différents modes de récupération du mot secret.

- `WordRepository` : classe abstraite servant de base aux dépôts de mots
- `WordRepositoryAlea` : fournit un mot choisi aléatoirement
- `WordRepositoryFixe` : fournit un mot fixe destiné notamment aux tests
- Utilisation de l'héritage et de la redéfinition de méthodes

Cette organisation permet de séparer la logique du jeu de la manière dont le mot secret est obtenu.

### 👥 Gestion des joueurs

La classe `Joueur` permet d'encapsuler les informations propres à chaque joueur.

- Gestion du nom du joueur
- Gestion des points
- Gestion du temps accumulé
- Gestion de deux joueurs au cours d'une même partie
- Mise à jour des scores et du temps après chaque manche

### 🏆 Système de score

Le jeu dispose d'un système de notation basé sur le nombre de tentatives.

- Attribution de points en fonction du nombre d'essais
- Une victoire au premier essai rapporte le maximum de points
- Un échec rapporte 0 point
- Comparaison des scores entre les joueurs
- Départage au temps en cas d'égalité de score
- Possibilité d'obtenir une égalité parfaite

### ⏱️ Gestion du temps

- Chronométrage de chaque manche
- Calcul du temps écoulé
- Accumulation du temps pour chaque joueur
- Utilisation du temps comme critère de départage

### 📋 Historique

- Conservation des informations des manches
- Stockage des propositions réalisées au cours des tours
- Affichage de l'historique en fin de session
- Réinitialisation des données lors d'une nouvelle session

## Technologies utilisées

- **Java** — développement de l'application
- **Programmation orientée objet** — organisation et conception du programme
- **UML** — modélisation des classes et des relations
- **JSON** — stockage de la liste des mots
- **Git / GitHub** — gestion et partage du projet

## Objectif pédagogique

Cette SAÉ avait pour objectif de nous permettre de mettre en pratique les principes de la **programmation orientée objet** à travers le développement d'une application complète.

Elle m'a notamment permis de développer mes compétences en :

- Programmation Java
- Programmation orientée objet
- Encapsulation
- Héritage
- Polymorphisme
- Classes abstraites
- Séparation des responsabilités
- Conception et modélisation UML
- Gestion des entrées utilisateur
- Manipulation de fichiers JSON
- Tests et débogage
- Organisation d'un projet informatique
- Travail en binôme

Le projet nous a également permis de comprendre l'importance d'une bonne conception avant l'implémentation et de modifier notre modélisation lorsque celle-ci ne correspondait pas correctement aux principes de la programmation orientée objet.

## Remarque

Ce projet m'a permis de participer au développement d'une application complète en Java et de mieux comprendre la mise en pratique de la **programmation orientée objet**.

Nous avons notamment rencontré des difficultés lors de l'intégration de l'historique et du système de score. Ces problèmes nous ont amenés à revoir l'organisation de certaines variables et méthodes afin d'améliorer la structure du programme.

Le projet comporte également certaines limites, notamment au niveau de la gestion des exceptions lors de la saisie de certaines valeurs numériques.

## Auteur

**Kuruparan PATHMARANJAN**
