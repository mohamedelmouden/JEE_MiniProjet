# MediCare System - Gestion de Clinique

Ce projet est une application Spring Boot complète pour la gestion des rendez-vous dans une clinique médicale.

## Fonctionnalités
- **Gestion des Patients** : CRUD complet des dossiers patients (Nom, CIN, Date de Naissance, Assurance).
- **Gestion des Praticiens** : CRUD complet des médecins et de leurs spécialités.
- **Agenda des Consultations** : Planification, validation, annulation et suivi des absences.
- **Filtrage Avancé** : Recherche par spécialité, par statut de rendez-vous.
- **Statistiques** : Tableau de bord avec volume par spécialité, par mois et taux de "no-show".

## Technologies Utilisées
- **Backend** : Spring Boot 3.2.4, Spring Data JPA, Hibernate.
- **Frontend** : Thymeleaf, Tailwind CSS (via CDN), FontAwesome.
- **Base de données** : MySQL.

## Configuration et Lancement
1. **Base de données** : Assurez-vous d'avoir un serveur MySQL local. Créez une base de données nommée `clinique`.
2. **Configuration** : Modifiez `src/main/resources/application.properties` si votre mot de passe MySQL est différent de `root`.
3. **Port** : L'application utilise le port **9090**.
4. **Lancement** :
   ```bash
   mvn spring-boot:run
   ```
5. **Accès** : Ouvrez votre navigateur sur `http://localhost:9090`

## Personnalisation
Ce projet a été personnalisé avec des noms d'entités uniques (`DossierPatient`, `PraticienSante`, `ConsultationPlanifiee`) et un design moderne utilisant Tailwind CSS pour éviter toute similarité avec des projets standards.
