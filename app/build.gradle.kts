plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.cybage.dogs_breed_app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.cybage.dogs_breed_app"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt") ,
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // AndroidX Dependencies

    implementation (libs.androidx.core.ktx)
    implementation (libs.androidx.lifecycle.runtime.ktx)
    implementation (libs.androidx.activity.compose.v140)
    implementation (libs.ui)
    implementation (libs.ui.graphics)
    implementation (libs.ui.tooling)
    implementation (libs.material3)
    implementation(libs.androidx.navigation.compose)
//    testImplementation(libs.testng)
//    testImplementation(libs.testng)
    androidTestImplementation (libs.androidx.junit.v113)
    androidTestImplementation (libs.androidx.espresso.core.v340)
    androidTestImplementation (libs.ui.test.junit4)
    debugImplementation (libs.androidx.ui.tooling.v110alpha04)

    // Retrofit and Gson dependencies
    implementation (libs.retrofit)
    implementation (libs.converter.gson)

        implementation(libs.androidx.navigation.compose)


        implementation (libs.androidx.lifecycle.livedata.ktx)


    //Mockito

//        testImplementation (libs.mockito.mockito.core)
//        testImplementation (libs.mockito.inline)
//        testImplementation (libs.mockito.mockito.core)
//
//    testImplementation (libs.mockito.mockito.core)
//
//    testImplementation(libs.kotlinx.coroutines.test)

//
implementation(libs.accompanist.coil)

    implementation (libs.coil)


    //Coroutines:
    implementation (libs.kotlinx.coroutines.core)
    implementation (libs.kotlinx.coroutines.android)

//
    implementation (libs.androidx.runtime.livedata)
    implementation (libs.androidx.lifecycle.viewmodel.compose)


}




