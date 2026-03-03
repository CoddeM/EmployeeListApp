plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.rahul.myapplication"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.rahul.myapplication"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    implementation ("androidx.room:room-runtime:2.8.4")
    ksp ("androidx.room:room-compiler:2.8.4") // For Kotlin projects using KSP

    // Optional: Kotlin Extensions and Coroutines support
    implementation ("androidx.room:room-ktx:2.8.4")

    // Paging 3 Core
    implementation ("androidx.paging:paging-runtime:3.3.6")

    // Optional: Paging Compose integration (for Jetpack Compose)
    implementation ("androidx.paging:paging-compose:3.3.6")

    // Optional: Room-Paging integration (enables PagingSource from Room queries)
    implementation ("androidx.room:room-paging:2.8.4")

    //Hilt
    val hiltVersion = "2.56"
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    ksp("com.google.dagger:hilt-compiler:$hiltVersion")

    val androidxHiltVersion = "1.2.0"
    implementation("androidx.hilt:hilt-work:$androidxHiltVersion")
    ksp("androidx.hilt:hilt-compiler:$androidxHiltVersion")

    //coil
    implementation("io.coil-kt:coil-compose:2.7.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.3.0")

    implementation("androidx.work:work-runtime:2.11.1")
    implementation("androidx.work:work-runtime-ktx:2.11.1")
}