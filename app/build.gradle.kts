import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.ksp)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "my.way.raycast"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "my.way.raycast"
        minSdk = 31
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }


    val secretProperties = rootProject.file("secret.properties")
    val secrets = Properties().apply {
        if (secretProperties.exists()) {
            load(secretProperties.inputStream())
        }
    }

    val xaiApiKey: String = secrets.getProperty("XAI_API_KEY") ?: throw IllegalArgumentException("XAI_API_KEY not found in secret.properties")
    val raycastSignature: String = secrets.getProperty("RAYCAST_SIGNATURE") ?: throw IllegalArgumentException("RAYCAST_SIGNATURE not found in secret.properties")
    val raycastToken: String = secrets.getProperty("RAYCAST_TOKEN") ?: throw IllegalArgumentException("RAYCAST_TOKEN not found in secret.properties")


    buildTypes {
        debug {
            buildConfigField("String", "XAI_API_KEY", "\"$xaiApiKey\"")
            buildConfigField("String", "RAYCAST_SIGNATURE", "\"$raycastSignature\"")
            buildConfigField("String", "RAYCAST_TOKEN", "\"$raycastToken\"")
            isDebuggable = false
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "XAI_API_KEY", "\"$xaiApiKey\"")
            buildConfigField("String", "RAYCAST_SIGNATURE", "\"$raycastSignature\"")
            buildConfigField("String", "RAYCAST_TOKEN", "\"$raycastToken\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.lifecycle.service)
    implementation(libs.androidx.datastore.core)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    implementation(libs.androidx.savedstate.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.activity.ktx)

    implementation(libs.androidx.datastore.preferences)

    implementation(libs.composeunstyled.primitives)

    // Koin
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)

    // Ktor
    implementation(libs.bundles.ktor)


    // Serialization
    implementation(libs.kotlinx.serialization.json)

    implementation("io.coil-kt.coil3:coil-compose:3.3.0")


    // Room (kapt for compiler)
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

}