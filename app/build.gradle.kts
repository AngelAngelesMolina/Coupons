plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp") version "1.8.21-1.0.11"
    id("kotlin-kapt")

}

android {
    namespace = "com.example.coupons"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.coupons"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        //viewBinding = true
        dataBinding = true
    }
}

var room_version = "2.6.1"
var lifecycle_version = "2.6.1"
var coroutines_version = "1.7.3"
var lifeData_version = "2.8.3"
var volley_version = "1.2.1"
var glide_version = "4.15.1"
var gson_version = "2.10.1"
val activity_version = "1.9.1"

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.devtools.ksp:symbol-processing-api:1.8.21-1.0.11")
    // Kotlin
    implementation("androidx.activity:activity-ktx:$activity_version")
    //    ROOM
    implementation ("androidx.room:room-runtime:$room_version")
    //ksp ("androidx.room:room-compiler:$room_version")
    kapt("androidx.room:room-compiler:$room_version")
    //noinspection GradleDependency
    implementation ("androidx.room:room-ktx:$room_version")
    //GLIDE
    implementation ("com.github.bumptech.glide:glide:$glide_version")
    //COROUTINES
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version")
    //LIVEDATA
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifeData_version")
    //VOLLEY
    implementation ("com.android.volley:volley:$volley_version")
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}