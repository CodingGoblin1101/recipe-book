# Recipes Google Sheets App

**Kurzbeschreibung**

Mobile App (Android, Kotlin + Jetpack Compose) zum Erstellen, Auslesen und Bearbeiten von Rezepten, die in einem Google Sheet gespeichert werden. Architektur: **MVVM** (Packages: `view`, `viewmodel`, `domain` (Model), `repository`).

---

## Ziel

Schritt-für-Schritt-Plan und ToDo-Liste, damit du die App sauber und reproduzierbar entwickelst. Die README enthält Vorschläge zur Authentifizierung, Sicherheit, Datenmodell, API-Zugriff, UI-Screens, Tests und CI.

---

## Projektstruktur (empfohlen)

```
app/src/main/kotlin/com/yourcompany/recipes
├─ view
│  ├─ ui
│  │  ├─ screens
│  │  │  ├─ LoginScreen.kt
│  │  │  ├─ RecipeListScreen.kt
│  │  │  ├─ RecipeDetailScreen.kt
│  │  │  └─ RecipeEditorScreen.kt
│  │  └─ components
│  └─ navigation
├─ viewmodel
│  ├─ RecipeListViewModel.kt
│  ├─ RecipeDetailViewModel.kt
│  └─ AuthViewModel.kt
├─ domain
│  ├─ model
│  │  └─ Recipe.kt
│  └─ usecase
│     └─ (optional) use cases
└─ repository
   ├─ SheetsRepository.kt (interface)
   └─ SheetsRepositoryImpl.kt (implementation)
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

**WICHTIG**: Niemals private Service-Account Schlüssel in einem veröffentlichten APK/Repo einchecken.

---

## Google Sheets - Setup (ToDos)

* [x] Google Cloud Console Projekt erstellen

    * [x] Sheets API aktivieren (Google Sheets API v4)
    * [ ] Drive API aktivieren falls nötig (z. B. wenn du Sheets erstellen möchtest)

* [ ] Authentifizierungsstrategie wählen (siehe oben)

### Wenn du Backend + Service-Account verwendest

* [ ] Service Account erstellen
* [ ] JSON-Key herunterladen **(niemals in VCS!)**
* [ ] Sheet erstellen, seine ID notieren und ggf. mit Service-Account teilen (falls möglich)
* [ ] Backend-Endpoint(s) designen: `/recipes` (GET, POST, PUT, DELETE)
* [ ] Backend implementieren: nimmt Requests entgegen, mapped JSON ↔ Sheet rows, ruft Google Sheets API auf

### Wenn du OAuth/Google-Sign-In auf dem Client verwendest

* [ ] OAuth-Client-ID (Android) in Google Cloud Console anlegen
* [ ] `google-services.json` (falls Firebase / Play Services verwendet) richtig konfigurieren
* [ ] Sheet-Layout definieren oder Benutzer Sheet erlauben
* [ ] Implementiere Token-Refresh / Error-Handling

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

**Hinweis:** Verwende klar definierte Spalten, damit die Zuordnung zwischen Row und Domain-Model deterministisch ist.

---

## Repository API (Interface) — ToDo

```kotlin
interface SheetsRepository {
    suspend fun getAllRecipes(): List<Recipe>
    suspend fun getRecipeById(id: String): Recipe?
    suspend fun createRecipe(recipe: Recipe): String // returns new id
    suspend fun updateRecipe(recipe: Recipe): Boolean
    suspend fun deleteRecipe(id: String): Boolean
    suspend fun syncIfNeeded(): Unit
}
```

* [ ] Implementiere `SheetsRepositoryImpl` (HTTP client or Google API client)
* [ ] Mapping: `List<String>` (Sheet row) ↔ `Recipe` (Domain)
* [ ] Fehlerklassen definieren (z. B. `NetworkException`, `AuthException`, `SheetFormatException`)

---

## Domain Model (Beispiel)

```kotlin
data class Recipe(
    val id: String,
    val title: String,
    val description: String,
    val ingredients: List<String>,
    val steps: List<String>,
    val tags: List<String> = emptyList(),
    val createdAt: Instant,
    val updatedAt: Instant
)
```

ToDos:

* [ ] Serializable/Parcelize markieren (kotlinx.serialization / Parcelable)
* [ ] Converters für `List<String>` ↔ CSV/JSON

---

## Netzwerk / Google API - Implementationsempfehlungen

* **Option A — Google API Java Client**

    * Kann direkt verwendet werden, aber führt viele transitive Abhängigkeiten ein.
* **Option B — REST via Retrofit / Ktor / OkHttp** (empfohlen für Kontrolle)

    * Verwende Retrofit + kotlinx.serialization (oder Moshi/Gson) um REST-Aufrufe auf die Sheets API zu machen.
    * Endpoint: `[https://sheets.googleapis.com/v4/spreadsheets/{spreads](https://sheets.googleapis.com/v4/spreadsheets/{spreads)
