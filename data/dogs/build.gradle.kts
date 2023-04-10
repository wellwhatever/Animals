import java.io.FileInputStream
import java.util.Properties
import libs.BuildModules
import libs.Hilt.hilt
import libs.Retrofit.retrofit

plugins {
    id("com.android.library")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.android")
}

val apikeyPropertiesFile = rootProject.file("apikey.properties")
val apikeyProperties = Properties()
apikeyProperties.load(FileInputStream(apikeyPropertiesFile))

android {
    namespace = "com.example.data.dogs"
    compileSdk = DefaultConfig.compileSdkVersion

    defaultConfig {
        minSdk = DefaultConfig.minSdkVersion
        buildConfigField(
            "String",
            "DOGS_API_KEY_SECRET",
            apikeyProperties.getProperty("DOGS_API_KEY_SECRET")
        )
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {
    implementation(project(BuildModules.coreNetwork))
    implementation(project(BuildModules.coreCommon))
    retrofit()
    hilt()
}