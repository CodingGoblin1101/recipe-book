# Recipes Google Sheets App

**Short Description**

Android app for creating, reading, and editing recipes that are stored in a Google Sheet on Google Drive.
Designed for collaboratively sharing and expanding a recipe book without requiring a server.

## Project Structure

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
* **View/UI (Jetpack Compose)**: UI rendering, navigation, local validation
* **ViewModel**: State management, UI logic, calling use cases/repository

---

## Google Sheets - Setup (ToDos)

* [x] change Datatypes in Script


---

## ToDo

* [x] change project structure
* [x] change Datatypes
* [ ] make MainScreen beautiful
* [ ] RecipeDetails Screen
* [ ] Unit Tests
* [x] ViewModel + add recipe
* [ ] ViewModel -> updateRecipes (is this even needed?)

---


## Google Sheets - Recommended Table Layout

**Sheet "recipes":**

| ID | title | description | ingredients | steps | tags | created_at | updated_at |
| -- | ----- | ----------- | ----------- | ----- | ---- | ---------- | ---------- |

* `ID`: Unique ID (UUID or incremental)
* `ingredients`: JSON-Array
* `steps`: JSON-Array
* `tags`: Comma-separated
* `created_at` / `updated_at`: ISO 8601

--> TODO: decide if I want this kind of layout
---

## used Tutorials

https://www.youtube.com/watch?v=0bZDPsaB7GY&list


---
## Nice-to-Know 

* HttpRoute contains only the Google App Script URL
* works in emulator
* loading needed, otherwise apps crashes //TODO: Why this?

fixed bugs:
  * HTTP response body being consumed twice
  * no NULL handling/ignoring - fix:
    install(ContentNegotiation) {
      json(Json {
      explicitNulls = false })
    }