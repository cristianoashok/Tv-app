plugins {
    id("com.android.application")
    id("kotlin-android") version "1.9.20" // Updated Kotlin version
    // ... (other plugins)
}

android {
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.tvplayer"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        namespace = "com.example.tvplayer"
    }

    buildTypes {
        getByName<BuildType>("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.exoplayer:exoplayer-core:2.19.1")
    implementation("com.google.android.exoplayer:exoplayer-ui:2.19.1")
    implementation("androidx.leanback:leanback:1.0.0")
    implementation("com.github.bumptech.glide:glide:4.11.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version")

    // Use ksp instead of kapt for Glide
    ksp("com.github.bumptech.glide:compiler:4.8.0")

    // ... (other dependencies)
}
