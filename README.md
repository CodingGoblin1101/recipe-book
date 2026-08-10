# Recipes Google Sheets App

**Kurzbeschreibung**

Android App zum Erstellen, Auslesen und Bearbeiten von Rezepten, die in einem Sheet auf dem Google drive gespeichert werden.

## Projektstruktur 

```
com.example.recipe_book
├── data
│   ├── model                  // Models and Services
│   └── remote                 // Service/API definitions
│
├── ui── theme                 // Theme & styling
│   ├─── screens               // All screens 
│   ├─── components            // Reusable UI widgets 
│   └─── MainActivity
│
└─── viewmodel                 // ViewModel
```

---

## High-Level-Architektur

* **Model/Data**: Services, API definitions
* **View/UI (Jetpack Compose)**: Darstellung, Navigation, lokale Validierung.
* **ViewModel**: State-Haltung, UI-Logik, Aufruf von Use-Cases/Repository

---

## Google Sheets - Setup (ToDos)

* [x] change Datatypes in Script


---

## Repository API (Interface) — ToDo

* [x] change project structure
* [x] change Datatypes
* [ ] make MainScreen beautiful
* [ ] RecipeDetails Screen
* [ ] Unit Tests
* [ ] ViewModel -> addRecipe
* [ ] ViewModel -> updateRecipes (even needed?)

## Andere ToDos

* nachlesen:
    * [ ] ContentNegotiation
    * [ ] howTo gradle
*[x] README überarbeiten
* 
---


## Google Sheets - empfohlenes Tabellenlayout

**Sheet "recipes":**

| ID | title | description | ingredients | steps | tags | created_at | updated_at |
| -- | ----- | ----------- | ----------- | ----- | ---- | ---------- | ---------- |

* `ID`: eindeutige ID (UUID oder inkrementell)
* `ingredients`: JSON-Array
* `steps`: JSON-Array
* `tags`: Kommagetrennt
* `created_at` / `updated_at`: ISO 8601

---

## used Tutorials/Quellen

https://www.youtube.com/watch?v=0bZDPsaB7GY&list


---
## Probleme/Hinweise + Learnings

* API + HTTP Anfrage + Response
* HttpRoute enthält die URL zum Google App Script
* funktioniert auch im Emulator
* kurzes loading nötig, sonst crasht app


* probleme die aufgetreten sind:
    * HTTP response body being consumed twice
    * no NULL handling/ignorin - fix:               
      * install(ContentNegotiation) {
        json(Json {
        explicitNulls = false
