plugins{
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android{

    namespace = "com.priyanshub.messagemate"
    compileSdk = Versions.compileSdk

    defaultConfig{
        applicationId = "com.priyanshub.messagemate"
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = Versions.versionCode
        versionName = Versions.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes{
        getByName("release"){
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions{
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        dataBinding = true
    }

    dependencies{
        implementation(Dependencies.coreKtx)
        implementation(Dependencies.appcompat)
        implementation(Dependencies.material)
        implementation(Dependencies.constraintLayout)
        testImplementation(Dependencies.junit)
        androidTestImplementation(Dependencies.extJunit)
        androidTestImplementation(Dependencies.espressoCore)

        implementation(Dependencies.splashScreen)

        //modules
        implementation(project(Modules.chat))
        implementation(project(Modules.onboarding))
        implementation(project(Modules.central))
    }
}