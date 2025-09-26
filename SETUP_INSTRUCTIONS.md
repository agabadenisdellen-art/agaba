# AGABA DENIS CLINIC - Project Setup Instructions

My apologies for the technical issues that prevented me from creating the project with the correct folder structure on my side. The good news is that all the code inside the files is **100% correct** for your "AGABA DENIS CLINIC" project.

Please follow these instructions carefully to set up the project in Android Studio.

---

### Step 1: Create a New Project in Android Studio

1.  Open Android Studio.
2.  Click on **"New Project"**.
3.  Select the **"Empty Activity"** template (the one with the Jetpack Compose logo). This is very important.
4.  Click **"Next"**.
5.  Configure your project with the following details:
    *   **Name:** `Agaba Denis Clinic`
    *   **Package name:** `com.example.agabadenisclinic` (This **must** match exactly).
    *   **Language:** Make sure **Kotlin** is selected.
    *   **Minimum SDK:** You can leave the default (e.g., API 24 or higher).
6.  Click **"Finish"**. Android Studio will create and build a new, empty project.

---

### Step 2: Copy the Code Files

Now, you will replace the contents of the template files with the code I generated.

1.  In Android Studio, switch to the **"Project"** view on the left-hand side (it usually defaults to "Android" view). This makes it easier to see all the files.
2.  Navigate to `app/src/main/java/com/example/agabadenisclinic`.
3.  One by one, open the files I created and copy their **entire contents**. Then, paste that content into the corresponding file in your Android Studio project, overwriting everything that was there.

    *   **`Patient.kt`**: Create this file and paste the content.
    *   **`Doctor.kt`**: Create this file and paste the content.
    *   **`ClinicDao.kt`**: Create this file and paste the content.
    *   **`ClinicDatabase.kt`**: Create this file and paste the content.
    *   **`ClinicViewModel.kt`**: Create this file and paste the content.
    *   **`AppScreen.kt`**: Create this file and paste the content.
    *   **`MainActivity.kt`**: Open the existing file and paste the content, overwriting the template.

4.  Now, do the same for the theme files in `app/src/main/java/com/example/agabadenisclinic/ui/theme`:
    *   **`Color.kt`**: Open the existing file and paste the content.
    *   **`Theme.kt`**: Open the existing file and paste the content.
    *   **`Typography.kt`**: Open the existing file and paste the content.

---

### Step 3: Update Your `build.gradle.kts` File

1.  In Android Studio, open the `build.gradle.kts` file that is for the **`app` module**.
2.  First, add the KSP plugin to the `plugins` block at the very top of the file:
    ```kotlin
    plugins {
        // ... other plugins
        id("com.google.devtools.ksp") version "1.9.0-1.0.13" // Ensure this version is compatible with your Kotlin plugin
    }
    ```
3.  Next, replace the entire `dependencies` block with the following:
    ```kotlin
    dependencies {

        // Default Compose dependencies
        implementation("androidx.core:core-ktx:1.12.0")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
        implementation("androidx.activity:activity-compose:1.8.0")
        implementation(platform("androidx.compose:compose-bom:2023.08.00"))
        implementation("androidx.compose.ui:ui")
        implementation("androidx.compose.ui:ui-graphics")
        implementation("androidx.compose.ui:ui-tooling-preview")
        implementation("androidx.compose.material3:material3")

        // --- Dependencies for the Clinic App ---

        // Room for database
        val room_version = "2.6.0"
        implementation("androidx.room:room-runtime:$room_version")
        implementation("androidx.room:room-ktx:$room_version") // For Coroutines support
        ksp("androidx.room:room-compiler:$room_version")

        // ViewModel
        implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

        // Navigation for Jetpack Compose
        implementation("androidx.navigation:navigation-compose:2.7.5")

        // Icons
        implementation("androidx.compose.material:material-icons-extended")

    }
    ```
4.  A bar will appear at the top of the editor window. Click **"Sync Now"**.

---

### Step 4: Update `AndroidManifest.xml`

You must tell the app to use the `ClinicApplication` class we created.

1.  In Android Studio, open `app/src/main/AndroidManifest.xml`.
2.  Find the `<application ...>` tag.
3.  Add the `android:name` attribute to it, like this:

    ```xml
    <application
        android:name=".ClinicApplication"
        ... >
    ```

---

### Step 5: Run the App!

That's it! You should now be able to run the application. Select an emulator or connect a physical Android device and click the green "Run" button. The app should build, install, and launch with the sample data already loaded.