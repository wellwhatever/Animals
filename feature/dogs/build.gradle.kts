import libs.Compose.compose
import libs.Hilt.hilt
import libs.Kotlin.kotlin
import libs.Material3.material3

plugins {
    id("com.android.library")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.feature.dogs"
    compileSdk = DefaultConfig.compileSdkVersion

    defaultConfig {
        minSdk = DefaultConfig.minSdkVersion
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.Compose.COMPOSE_COMPILER
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    kotlin()
    compose()
    material3()
    hilt()
}