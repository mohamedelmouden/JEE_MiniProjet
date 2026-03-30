# 🏥 MediCare System - Gestion de Clinique Médicale

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.4-brightgreen)
![Java](https://img.shields.io/badge/Java-17-orange)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.0-darkgreen)
![Tailwind CSS](https://img.shields.io/badge/Tailwind%20CSS-3.0-blueviolet)

**MediCare System** est une application web robuste et moderne conçue pour simplifier la gestion des rendez-vous médicaux au sein d'une clinique. Elle permet une interaction fluide entre les patients et les praticiens tout en offrant des outils d'analyse de présence.

---

## 🚀 Fonctionnalités Clés

### 👥 Gestion des Patients & Praticiens
- **Dossiers Patients** : Suivi complet (Identité, CIN, Assurance, Historique).
- **Équipe Médicale** : Gestion des praticiens par spécialité (Cardiologie, Pédiatrie, etc.).

### 📅 Agenda & Consultations
- **Planification** : Prise de rendez-vous intuitive avec sélection de date et heure.
- **Cycle de Vie** : Validation, annulation ou marquage des absences ("No-Show").
- **Filtrage Dynamique** : Recherche rapide par spécialité médicale ou par statut de consultation.

### 📊 Tableau de Bord Statistique
- **Analyse de Volume** : Répartition des consultations par spécialité et par mois.
- **Indicateur de Performance** : Calcul automatique du taux de "No-Show" pour optimiser la gestion du temps médical.

---

## 🛠️ Stack Technique

| Composant | Technologie |
| :--- | :--- |
| **Backend** | Spring Boot 3.2.4 (Java 17+) |
| **Persistance** | Spring Data JPA / Hibernate |
| **Base de Données** | MySQL |
| **Frontend** | Thymeleaf & Tailwind CSS |
| **Icônes** | FontAwesome 6 |

---

## ⚙️ Installation et Configuration

### 1. Prérequis
- Java 17 ou supérieur installé.
- Maven 3.6+ installé.
- Serveur MySQL en cours d'exécution.

### 2. Configuration de la Base de Données
Créez une base de données nommée `clinique` dans votre instance MySQL :
```sql
CREATE DATABASE clinique;
```

### 3. Configuration de l'Application
Éditez le fichier `src/main/resources/application.properties` pour correspondre à vos identifiants :
```properties
spring.datasource.username=votre_utilisateur
spring.datasource.password=votre_mot_de_passe
```

### 4. Lancement
Exécutez la commande suivante à la racine du projet :
```bash
mvn spring-boot:run
```
L'application sera accessible sur : **[http://localhost:9090](http://localhost:9090)**

---

## 📂 Structure du Projet

```text
src/main/java/com/medicare/sys/
├── controller/   # Contrôleurs Spring MVC
├── model/        # Entités JPA (DossierPatient, PraticienSante, etc.)
├── repository/   # Interfaces Spring Data JPA
└── service/      # Logique métier et calculs statistiques
```

### video demo :



https://github.com/user-attachments/assets/72f4ac3f-05c0-434a-8890-71e19d11f442



https://github.com/user-attachments/assets/72f4ac3f-05c0-434a-8890-71e19d11f442


