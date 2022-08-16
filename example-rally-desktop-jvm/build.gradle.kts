import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
plugins {
    kotlin(multiplatform)
    id(composePlugin) version Versions.COMPOSE_MULTIPLATFORM_PLUGIN
}

group = "net.smarttuner.mlog.desktop"
version = "1.0.0"

kotlin {
    jvm {
        withJava()
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Coroutines
                implementation(Deps.Coroutines.common)
            }
        }

        val jvmMain by getting {
            kotlin.srcDirs("src/jvmMain/kotlin")
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation(compose.runtime)
                implementation(compose.foundation)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.material)
                implementation(compose.ui)
                implementation(compose.materialIconsExtended)


                implementation(project(":example-rally-shared"))
                // Coroutines
                implementation(Deps.Coroutines.swing)
            }
        }
    }
}

compose.desktop {
    application() {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "SmartTuner.net"
            macOS {
                bundleID = "net.smarttuner.mlog.desktop"
            }
        }
    }
}
