# Skill Swap

**Skill Swap** est une plateforme backend d'échange de compétences. Elle permet aux utilisateurs de proposer des services (cours, mentorat) et de les échanger contre des crédits virtuels dans une logique de "Time Banking".

## Fonctionnalités Principales

* **Gestion Utilisateurs :** Inscription sécurisée et gestion de portefeuille de crédits.
* **Offres de Services :** Publication d'annonces (ex: "Cours de Java", "Jardinage").
* **Système de Transaction :** Échange atomique de crédits entre l'acheteur et le vendeur.
* **Validation Métier :** Vérification automatique des soldes et rollback en cas d'erreur.

## Stack Technique

Ce projet a été conçu avec les standards modernes de l'industrie (2025) :

* **Langage :** Java 21
* **Framework :** Spring Boot 3 (Web, Data JPA)
* **Base de données :** PostgreSQL (Production) / H2 (Dev)
* **Conteneurisation :** Docker & Docker Hub
* **CI/CD :** GitHub Actions (Pipeline automatisé de Test & Build)
* **Tests :** JUnit 5 & Mockito (Tests unitaires isolés)

## Démarrage Rapide (Via Docker)

Pas besoin d'installer Java ou Maven. Vous pouvez lancer l'application complète avec une seule commande :

```bash
docker run -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/skill_swap \
  -e SPRING_DATASOURCE_USERNAME=admin \
  -e SPRING_DATASOURCE_PASSWORD=admin \
  Alexandre1609/skill-swap:latest
  ```

L'application sera accessible sur : http://localhost:8080

## Installation Manuelle

1. Cloner le projet:
```bash
git clone [https://github.com/](https://github.com/)[TON_PSEUDO]/skill-swap.git
```

2. Compiler et Tester:
```bash
mvn clean package
```

3. Lancer:
```bash
java -jar target/*.jar
```

## Qualité du code 

Le projet suit une architecture MVC stricte. Les règles métier critiques (comme le transfert d'argent) sont couvertes par des Tests Unitaires automatisés via GitHub Actions.


Réalisé par Alexandre
