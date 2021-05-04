import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.secrets_gradle_plugin") version "0.6"
    id("kotlin-parcelize")
    id("kotlin-android")
}

val composeVersion = properties["version.compose"] as String
val kotlinVersion = properties["version.kotlin"] as String

android {
    compileSdkVersion((properties["android.compileSdk"] as String).toInt())

    defaultConfig {
        minSdkVersion((properties["android.minSdk"] as String).toInt())
        targetSdkVersion((properties["android.targetSdk"] as String).toInt())
        buildToolsVersion = properties["android.buildToolsVersion"] as String

        applicationId = "dev.haroldjose.ominibus.android"
        versionCode = 1
        versionName = "1.0"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

//    signingConfigs {
//        create("release") {
//            storeFile = file("./key/key.jks")
//            gradleLocalProperties(rootDir).apply {
//                storePassword = getProperty("storePwd") as String
//                keyAlias = getProperty("keyAlias") as String
//                keyPassword = getProperty("keyPwd") as String
//            }
//        }
//    }

    buildTypes {
        create("debugPG") {
            //initWith(getByName("debug"))
            getByName("debug")
            isDebuggable = false
            isMinifyEnabled = true
            versionNameSuffix = " debugPG"
            matchingFallbacks.add("debug")

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                file("proguard-rules.pro")
            )
        }
        getByName("release") {
            isMinifyEnabled = false
            //signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                file("proguard-rules.pro")
            )
        }
    }

    buildFeatures {
        // Enables Jetpack Compose for this module
        viewBinding = true
        compose = true
    }


    compileOptions {
        // Flag to enable support for the new language APIs
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
        kotlinCompilerVersion = kotlinVersion
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0-alpha01")
    implementation("androidx.activity:activity-compose:1.3.0-alpha07")


    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")

    //desugar utils
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")

    //Compose
    implementation("androidx.compose.ui:ui:$composeVersion") //Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:$composeVersion") //Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:$composeVersion")

    //Navigation
    implementation("androidx.navigation:navigation-compose:1.0.0-alpha10")
//    implementation("androidx.navigation:navigation-runtime-ktx:2.3.5")


    //Material Design
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.material:material-icons-core:$composeVersion") //Material Design icons
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")

    //UI
    implementation("androidx.appcompat:appcompat:1.3.0-rc01")

    //Coroutines
    val coroutinesVersion = properties["version.kotlinx.coroutines"]
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    //DI
    implementation("org.koin:koin-core:2.2.2")
    implementation("org.koin:koin-androidx-scope:2.2.2")

    //Navigation
    implementation("com.github.terrakok:modo:0.6.1")
    implementation("com.github.terrakok:modo-render-android-fm:0.6.1")

    //WorkManager
    implementation("androidx.work:work-runtime-ktx:2.6.0-alpha02")

    //Google Maps
    implementation("com.google.maps.android:maps-v3-ktx:3.0.0") // KTX for the Maps SDK for Android V3 BETA Library
    implementation("com.google.maps.android:maps-utils-v3-ktx:3.0.0") // KTX for the Maps SDK for Android V3 BETA Utility Library
    implementation("com.google.android.libraries.maps:maps:3.1.0-beta")
    implementation("com.google.maps.android:android-maps-utils-v3:2.0.3")

}