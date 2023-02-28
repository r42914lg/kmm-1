plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.r42914lg.trykmm.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.r42914lg.trykmm.android"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.fragment:fragment-ktx:1.5.5")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
}