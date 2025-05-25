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
