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

//dependencies {
//    // AndroidX Dependencies
//
//    implementation (libs.androidx.core.ktx)
//    implementation (libs.androidx.lifecycle.runtime.ktx)
//    implementation (libs.androidx.activity.compose.v140)
//    implementation (libs.ui)
//    implementation (libs.ui.graphics)
//    implementation (libs.ui.tooling)
//    implementation (libs.material3)
//    implementation(libs.androidx.navigation.compose)
//    implementation(libs.androidx.ui.util.android)
//    implementation(libs.androidx.ui.android)
//    implementation(libs.androidx.ui.text.android)
//    implementation(libs.androidx.ui.tooling.preview.android)
//    testImplementation(libs.testng)
//    testImplementation(libs.testng)
////    testImplementation(libs.testng)
////    testImplementation(libs.testng)
//    androidTestImplementation (libs.androidx.junit.v113)
//    androidTestImplementation (libs.androidx.espresso.core.v340)
//    androidTestImplementation (libs.ui.test.junit4)
//    debugImplementation (libs.androidx.ui.tooling.v110alpha04)
//
//    // Retrofit and Gson dependencies
//    implementation (libs.retrofit)
//    implementation (libs.converter.gson)
//
//        implementation(libs.androidx.navigation.compose)
//
//
//        implementation (libs.androidx.lifecycle.livedata.ktx)
//
//
//    //Mockito
//
////        testImplementation (libs.mockito.mockito.core)
////        testImplementation (libs.mockito.inline)
////        testImplementation (libs.mockito.mockito.core)
////

//
//
//    implementation(libs.androidx.ui.graphics)
//    implementation(libs.androidx.ui.layout)
//
////
//implementation(libs.accompanist.coil)
//
//    implementation (libs.coil)
//
//
//    //Coroutines:
//    implementation (libs.kotlinx.coroutines.core)
//    implementation (libs.kotlinx.coroutines.android)
//
////
//    implementation (libs.androidx.runtime.livedata)
//    implementation (libs.androidx.lifecycle.viewmodel.compose)
//
//// Hilt as stack overflow suggested:
//    implementation(libs.androidx.hilt.navigation.compose)
//}

dependencies {
    implementation (libs.androidx.core.ktx.v170)
    implementation (libs.androidx.lifecycle.runtime.ktx.v240)
    implementation (libs.activity.compose.v140)
    implementation (libs.androidx.ui.v110)
    implementation (libs.androidx.ui.graphics.v110)
    implementation (libs.androidx.ui.tooling.v110)
    implementation (libs.material)
    implementation (libs.androidx.navigation.compose.v240alpha10)
    implementation(libs.androidx.foundation.layout.android)
    implementation(libs.androidx.material3.android)
    implementation(libs.androidx.foundation.android)
    testImplementation (libs.testng.v740)
    androidTestImplementation (libs.junit.v113)
    androidTestImplementation (libs.espresso.core.v340)
    implementation (libs.androidx.ui.test.junit4.v110)
    debugImplementation (libs.androidx.ui.tooling.preview)
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation (libs.androidx.lifecycle.livedata.ktx.v240)
    implementation (libs.coil.compose)
    implementation (libs.kotlinx.coroutines.core)
    implementation (libs.kotlinx.coroutines.android)
    implementation (libs.androidx.lifecycle.viewmodel.compose.v240alpha03)


//    testImplementation (libs.mockito.mockito.core)
//
//    testImplementation(libs.kotlinx.coroutines.test)
//
//
//    androidTestImplementation (libs.androidx.core.testing)
//
//    testImplementation(libs.mockito.kotlin)
//
//    androidTestImplementation (libs.kotlinx.coroutines.test)


    // MockwebServer:
    testImplementation(libs.mockwebserver)



    //for DogRepoTestcases:



    testImplementation (libs.junit)
    testImplementation (libs.kotlinx.coroutines.test.v160)
    testImplementation (libs.mockito.core)
    testImplementation (libs.mockito.inline)
    testImplementation (libs.androidx.core.testing.v210)

    //MOCK INLINE:
    testImplementation (libs.mockito.inline.v420)

    //Robolectric:
    testImplementation (libs.robolectric)





}


