import java.io.FileInputStream
import java.util.Properties
import libs.AndroidCore.androidCore
import libs.Hilt.hilt
import libs.Kotlin.kotlin
import libs.Compose.compose
import libs.Coil.coil
import libs.Desugaring.desugaring
import libs.Material3.material3
import libs.NavigationCompose.navigation
import libs.Retrofit.retrofit
import libs.Timber.timber

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
}

val keystorePropertiesFile = rootProject.file("keystore.properties")
val keyStoreProperties = Properties()
keyStoreProperties.load(FileInputStream(keystorePropertiesFile))

android {
    namespace = "com.example.animals"
    compileSdk = DefaultConfig.compileSdkVersion

    defaultConfig {
        applicationId = "com.example.animals"
        minSdk = DefaultConfig.minSdkVersion
        targetSdk = DefaultConfig.targetSdkVersion
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    signingConfigs {
        create("release") {
            storeFile = file(keyStoreProperties.getProperty("storeFile"))
            storePassword = keyStoreProperties.getProperty("storePassword")
            keyAlias = keyStoreProperties.getProperty("keyAlias")
            keyPassword = keyStoreProperties.getProperty("keyPassword")
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
        debug {
            isDebuggable = true
            versionNameSuffix = "-debug"
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.Compose.COMPOSE_COMPILER
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures {
        compose = true
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    kotlin()
    desugaring()
    androidCore()
    compose()
    material3()
    hilt()
    coil()
    navigation()
    retrofit()
    timber()
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}