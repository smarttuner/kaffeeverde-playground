plugins {
    kotlin(androidPlugin)
    id(androidApp)
    id(composePlugin) version Versions.COMPOSE_MULTIPLATFORM_PLUGIN
}

version = "0.0.1"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

android {
    compileSdk = Versions.ANDROID_COMPILE_SDK

    defaultConfig {
        applicationId = "com.example.rally"
        minSdk = Versions.ANDROID_MIN_SDK
        targetSdk = Versions.ANDROID_TARGET_SDK
        versionCode = 1
        versionName = "0.0.1"

        vectorDrawables {
            useSupportLibrary = true
        }
        //ndk { abiFilters "armeabi", "armeabi-v7a", "x86", "mips" }
    }

    buildTypes {
        getByName("debug") {
            applicationIdSuffix = ".debug"
        }
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    dataBinding {
        isEnabled = true
    }
    lint {
        checkReleaseBuilds = false
        abortOnError = false
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE_COMPILER
    }
    packagingOptions {
        resources.excludes.add("META-INF/licenses/**")
        resources.excludes.add("META-INF/AL2.0")
        resources.excludes.add("META-INF/LGPL2.1")
    }
}

dependencies {
    implementation(project(":example-rally-shared"))

    implementation(Deps.Material.Material)

    with(Deps.Compose){
        implementation(activity)
        implementation(compiler)
        implementation(ui)
        implementation(uiUtil)
        implementation(foundation)
        implementation(material)
        implementation(tooling_preview)
    }


    testImplementation("junit:junit:4.13.2")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}")

}