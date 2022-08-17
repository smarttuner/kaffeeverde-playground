import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin(multiplatform)
    id(androidLib)
    id(composePlugin) version Versions.COMPOSE_MULTIPLATFORM_PLUGIN
}

version = "1.0"

kotlin {
    iosX64("uikitX64") {
        binaries {
            sharedLib {
                baseName = "shared"
                freeCompilerArgs += listOf(
                    "-linker-option", "-framework", "-linker-option", "Metal",
                    "-linker-option", "-framework", "-linker-option", "CoreText",
                    "-linker-option", "-framework", "-linker-option", "CoreGraphics"
                )
            }
        }
    }
    iosArm64("uikitArm64") {
        binaries {
            sharedLib {
                baseName = "shared"
                freeCompilerArgs += listOf(
                    "-linker-option", "-framework", "-linker-option", "Metal",
                    "-linker-option", "-framework", "-linker-option", "CoreText",
                    "-linker-option", "-framework", "-linker-option", "CoreGraphics"
                )
                // TODO: the current compose binary surprises LLVM, so disable checks for now.
                freeCompilerArgs += "-Xdisable-phases=VerifyBitcode"
            }
        }
    }

    android()
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                with(compose){
                    implementation(runtime)
                    implementation(foundation)
                    implementation(ui)
                    implementation(material)
                    implementation(animation)
                    implementation(materialIconsExtended)
                }
                api(Deps.KaffeeVerde.ApplicationSupport)
            }


        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting
        val desktopMain by getting

        val iosMain by creating  {
            dependsOn(commonMain)
        }

        val uikitX64Main by getting {
            dependsOn(iosMain)
        }
        val uikitArm64Main by getting {
            dependsOn(iosMain)
        }

        val androidTest by getting

    }
}

android {
    compileSdk =  Versions.ANDROID_COMPILE_SDK
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = Versions.ANDROID_MIN_SDK
        targetSdk = Versions.ANDROID_TARGET_SDK
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}


kotlin {
    targets.withType<KotlinNativeTarget> {
        binaries.all {
            // TODO: the current compose binary surprises LLVM, so disable checks for now.
            freeCompilerArgs += "-Xdisable-phases=VerifyBitcode"
        }
    }
}
