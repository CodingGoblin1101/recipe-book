# Recipes Google Sheets App

**Kurzbeschreibung**

Android App zum Erstellen, Auslesen und Bearbeiten von Rezepten, die in einem Google Sheet gespeichert werden.

## Projektstruktur 

```
app/src/main/java/com/example/recipe_book
├
│  ├─ data
│  │  │  ├─ HttpRoute.kt
│  │  │  ├─ ProductResponse.kt
│  │  │  └─ ProductService.kt
├─ ui
│  ├─ screens
│  │  ├─ MainScreen.kt
│  │  └─ DetailScreen.kt
├─ viewmodel
│  ├─ RecipeListViewModel.kt
│  ├─ RecipeDetailViewModel.kt
├─ domain
│  └─ RecipeData.kt

```

---

## High-Level-Architektur

* **View (Jetpack Compose)**: Darstellung, Navigation, lokale Validierung.
* **ViewModel**: State-Haltung, UI-Logik, Aufruf von Use-Cases/Repository, Coroutine-Scope.
* **Repository**: Schnittstelle zur Datenquelle (Google Sheets). Beinhaltet Mapping zwischen Domain-Models und Google-Sheets-Formaten.
* **Domain**: `Recipe`-Model und evtl. Use-Cases (Add, Update, Delete, List).

---

## Wichtige Entscheidungen (Security & Auth)

> **Wähle eine Strategie** — zwei übliche Ansätze:

1. **Service-Account + Backend (empfohlen für Sicherheit)**

    * Backend-Service (z. B. Firebase Cloud Functions, Ktor/Node) hält Service-Account-Credentials sicher.
    * App ruft dein Backend auf; Backend spricht mit Google Sheets API.
    * Vorteil: keine sensiblen Keys in der App, einfachere Autorisierung/Logging.

2. **Direkter Zugriff vom Client (OAuth2 / Google Sign-In)**

    * App verwendet Google Sign-In / OAuth2, der Nutzer autorisiert Zugriff auf sein Google Drive / Sheets.
    * Vorteil: App kann direkt mit Sheets des Benutzers arbeiten.
    * Nachteil: aufwändigere OAuth-Implementierung, Token-Handling, höhere Komplexität.


---

## Google Sheets - Setup (ToDos)

* [ ] Script anpassen mit passenderen Datentypen


---

## Repository API (Interface) — ToDo

* [ ] genauen Aufbau der Architektur bestimmen + verbessern
* [ ] Datentypen anpassen an Script
* [ ] MainScreen verschönern
* [ ] RecipeDetails Screen
* [ ] ViewModel -> addRecipe
* [ ] ViewModel -> updateRecipes (even needed?)


---


## Google Sheets - empfohlenes Tabellenlayout

**Sheet "recipes" (Tabellenblatt):**

| ID | title | description | ingredients | steps | tags | created_at | updated_at |
| -- | ----- | ----------- | ----------- | ----- | ---- | ---------- | ---------- |

* `ID`: eindeutige ID (UUID oder inkrementell)
* `ingredients`: JSON-Array oder durch Pipe `|` getrennt
* `steps`: JSON-Array oder getrennt
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
  
* nachlesen:
  * ContentNegotiation
  * howTo gradle