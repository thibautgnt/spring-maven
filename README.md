# Application Todo Spring Boot

Une application web de gestion de tâches (Todo) développée avec Spring Boot.

## Fonctionnalités

- Affichage de toutes les tâches
- Filtrage des tâches (actives/terminées)
- Création de nouvelles tâches
- Modification des tâches existantes
- Marquage des tâches comme terminées/actives
- Suppression des tâches
- Recherche de tâches par mot-clé

## Technologies utilisées

- Java 21
- Spring Boot 3.4.4
- Spring Data JPA
- Thymeleaf
- H2 Database
- Lombok
- Validation

## Prérequis

- JDK 21
- Gradle

## Installation et démarrage

1. Cloner le dépôt
2. Naviguer vers le répertoire du projet
3. Exécuter la commande: `./gradlew bootRun`
4. Accéder à l'application via: http://localhost:8080

## Structure du projet

- `controller`: Contrôleurs pour la gestion des requêtes HTTP
- `model`: Entités et modèles de données
- `service`: Logique métier
- `repository`: Accès aux données

## Auteur

Thibaut Genet - Cours DevSecOps
