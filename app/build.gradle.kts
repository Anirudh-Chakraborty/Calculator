plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.test.anicalc"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.test.anicalc"
        minSdk = 28
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    implementation("androidx.activity:activity:1.8.0") // Downgraded from 1.10.1
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}