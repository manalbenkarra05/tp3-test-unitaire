# TP3 - Tests d'Intégration avec JUnit 5 et Mockito

Ce projet contient l'implémentation de trois exercices de **tests d'intégration** en Java, utilisant **JUnit 5** pour les tests unitaires et **Mockito** pour le mocking des dépendances.

## 📚 Objectifs

- Comprendre les tests d'intégration entre modules, DAO, et services externes.
- Simuler des interactions avec des dépendances (mock).
- Tester des scénarios de succès, d'erreur, et de gestion d'exceptions.
## ✅ Exercices

### 🔹 Exercice 1 : Interaction simple entre modules

- `UserService` appelle `UserRepository`.
- Utilisation de `Mockito` pour simuler `UserRepository`.

### 🔹 Exercice 2 : Interaction avec une base de données (mockée)

- `OrderController` → `OrderService` → `OrderDao`
- `OrderDao` est mocké : aucune vraie base n’est utilisée.

### 🔹 Exercice 3 : Intégration d'une API externe simulée

- `ProductService` appelle une API via `ProductApiClient`.
- Tests de cas réels, erreurs API, données nulles.

---
# TP3 - Tests d'Intégration avec Docker, Testcontainers, et Spring Boot

Ce projet contient l'implémentation des exercices du TP3, axés sur les **tests d'intégration** en Java, en utilisant **Spring Boot**, **JUnit 5**, et **Testcontainers** pour exécuter des tests robustes avec une base de données MySQL dans des conteneurs Docker. Le projet suit les directives du TP3 (Tests Unitaires et d'Intégration - Partie 2).

## 📚 Objectifs

- Comprendre les concepts fondamentaux de **Docker** : images, conteneurs, registres, et Docker Compose.
- Utiliser **Testcontainers** pour exécuter des tests d'intégration dans des environnements isolés.
- Mettre en pratique des tests d'intégration avec une application Spring Boot et une base de données MySQL.
- Publier le code sur un dépôt GitHub, en suivant les bonnes pratiques Git.

## 🛠️ Prérequis

Pour exécuter ce projet, vous devez avoir :
- **Java 8 ou supérieur** installé.
- **IntelliJ IDEA** comme IDE recommandé.
- **Docker** installé et configuré (compatible avec Windows, macOS, ou Linux).
- Une connexion Internet pour télécharger les images Docker.
- **Maven** ou **Gradle** comme gestionnaire de dépendances.
- Un compte GitHub configuré avec un **Personal Access Token (PAT)** ou une clé SSH pour les opérations Git.

## 📦 Dépendances

Les dépendances nécessaires sont configurées dans le fichier `pom.xml` (pour Maven) ou `build.gradle` (pour Gradle). Voici les dépendances clés :

### Maven
```xml
<dependency>
    <groupId>org.testcontainers</groupId>
    <artifactId>testcontainers</artifactId>
    <version>1.20.2</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.testcontainers</groupId>
    <artifactId>mysql</artifactId>
    <version>1.20.2</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.30</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

### Gradle
```gradle
testImplementation 'org.testcontainers:testcontainers:1.20.2'
testImplementation 'org.testcontainers:mysql:1.20.2'
testImplementation 'mysql:mysql-connector-java:8.0.30'
testImplementation 'org.springframework.boot:spring-boot-starter-test'
```

## ✅ Exercices

### 🔹 Exercice 1 : Maîtriser Testcontainers

**Objectif** : Compiler les parties indépendantes du projet (par exemple, remplacer une base de données mockée par une image Docker MySQL) et publier les tests sur GitHub.

**Implémentation** :
- Création de la classe `MyIntegrationTest` dans le package `Partie02` pour tester l'intégration avec une base de données MySQL via Testcontainers.
- Utilisation de `Tp3IntegrationTestApplication` (package `org.example.TP3partie2`) comme classe principale Spring Boot.
- Configuration d'un conteneur MySQL (version 5.7) avec Testcontainers pour exécuter les tests dans un environnement isolé.
- Test de base (`contextLoads`) pour vérifier que le conteneur MySQL est en cours d'exécution.

**Fichiers clés** :
- `src/test/java/Partie02/MyIntegrationTest.java`
- `src/main/java/org/example/TP3partie2/Tp3IntegrationTestApplication.java`

**Commandes Git pour pousser le code** :
```bash
# Vérifier les modifications
git status

# Ajouter les fichiers
git add src/test/java/Partie02/MyIntegrationTest.java
git add src/main/java/org/example/TP3partie2/Tp3IntegrationTestApplication.java

# Commiter
git commit -m "Ajout de MyIntegrationTest et Tp3IntegrationTestApplication pour Exercice 1"

# Résoudre les conflits si nécessaire (après un git pull)
git pull origin main
git add .
git commit

# Pousser vers GitHub
git push origin main
```

### 🔹 Exercice 2 : Tests d'intégration avec Testcontainers pour une application de gestion de tâches

**Objectif** : Réécrire les tests d'intégration d'une application de gestion de tâches en utilisant Testcontainers et Docker, en s'appuyant sur le projet GitHub `rengreen/task-manager`.

**Étapes** :
1. Cloner le projet : `git clone https://github.com/rengreen/task-manager.git`
2. Analyser les tests existants dans le projet pour identifier leurs limitations (par exemple, couverture, fiabilité).
3. Réécrire les tests d'intégration en utilisant Testcontainers pour démarrer un conteneur MySQL.
4. Exécuter les tests avec JUnit et vérifier leur bon fonctionnement.
5. Comparer les tests réécrits avec les tests originaux en termes de couverture, lisibilité, maintenabilité, et fiabilité.

**Commentaires sur les tests existants** :
- Les tests originaux (si mockés) peuvent manquer de réalisme, car ils n'interagissent pas avec une vraie base de données.
- L'utilisation de Testcontainers garantit un environnement isolé et reproductible, améliorant la fiabilité des tests.
- Les tests réécrits couvrent les mêmes scénarios (création, récupération, suppression de tâches) avec une base de données réelle.

**Mises à jour du README** :
- Si de nouveaux scénarios de test ont été ajoutés, ils sont documentés dans ce fichier.

## 🚀 Exécution des tests

1. Assurez-vous que **Docker** est en cours d'exécution sur votre machine.
2. Depuis le répertoire racine du projet (`tp3-testynitaire`), exécutez les tests avec Maven :
   ```bash
   mvn test
   ```
   Ou avec Gradle :
   ```bash
   ./gradlew test
   ```
3. Les tests dans `MyIntegrationTest` démarrent automatiquement un conteneur MySQL, exécutent les tests, et arrêtent le conteneur.

## 🛠️ Résolution des problèmes Git

Si vous rencontrez l'erreur suivante lors du push :
```
To https://github.com/manalbenkarra05/tp3-test-unitaire.git
 ! [rejected]        main -> main (fetch first)
```
Cela signifie que le dépôt distant contient des modifications absentes localement. Pour résoudre :
```bash
# Récupérer et fusionner les modifications distantes
git pull origin main

# Résoudre les conflits si nécessaire
git add .
git commit

# Pousser à nouveau
git push origin main
```

**Problème d'authentification** :
- Si vous voyez une erreur 403 ou un problème lié à un compte incorrect (par exemple, `ghostblm`), supprimez les identifiants incorrects dans le **Gestionnaire d'identifiants Windows** :
    1. Ouvrez **Panneau de configuration** > **Comptes d'utilisateurs** > **Gestionnaire d'identifiants**.
    2. Sous **Informations d'identification Windows**, supprimez les entrées pour `git:https://github.com` ou `github.com`.
    3. Utilisez votre nom d'utilisateur GitHub (`manalbenkarra05`) et un **Personal Access Token (PAT)** lors du push.
- Alternativement, configurez SSH :
  ```bash
  ssh-keygen -t ed25519 -C "votre-email@example.com"
  cat ~/.ssh/id_ed25519.pub
  ```
  Ajoutez la clé publique à GitHub (**Settings** > **SSH and GPG keys**) et mettez à jour l'URL du dépôt :
  ```bash
  git remote set-url origin git@github.com:manalbenkarra05/tp3-test-unitaire.git
  ```

## 📝 Notes supplémentaires

- **Correction dans `MyIntegrationTest`** : La classe `MyIntegrationTest` a été mise à jour pour utiliser `org.example.TP3partie2.Tp3IntegrationTestApplication` au lieu de `org.example.DemoApplication`, qui n'existait pas.
- **Structure du projet** :
    - Tests : `src/test/java/Partie02/MyIntegrationTest.java`
    - Application principale : `src/main/java/org/example/TP3partie2/Tp3IntegrationTestApplication.java`
- **Testcontainers** : Les tests utilisent un conteneur MySQL 5.7 avec la base de données `tp3db`, configurée via `@DynamicPropertySource` pour une intégration dynamique avec Spring Boot.
- **Prochaines étapes** : Pour l'Exercice 2, envisagez d'ajouter des tests spécifiques pour la gestion des tâches (par exemple, `testCreateTask`, `testGetTask`, `testDeleteTask`) comme décrit dans le TP (pages 4-5).

## 🔗 Ressources

- Documentation Testcontainers : [https://java.testcontainers.org/](https://java.testcontainers.org/)
- Projet de référence pour l'Exercice 2 : [https://github.com/rengreen/task-manager](https://github.com/rengreen/task-manager)
- Dépôt GitHub du projet : [https://github.com/manalbenkarra05/tp3-test-unitaire](https://github.com/manalbenkarra05/tp3-test-unitaire)
