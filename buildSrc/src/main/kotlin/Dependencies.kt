const val androidPlugin = "android"
const val androidApp = "com.android.application"
const val cocoapods = "native.cocoapods"
const val androidLib = "com.android.library"
const val multiplatform = "multiplatform"
const val mavenPublish = "maven-publish"
const val composePlugin = "org.jetbrains.compose"

const val KOMPASS_LIB_GROUP = "net.smarttuner.kompass"

object Versions {
    const val KOMPASS_LIB_VERSION = "0.0.1"

    const val KAFFEEVERDE_APPLICATION_SUPPORT = "0.0.8"

    const val ANDROID_MIN_SDK = 24
    const val ANDROID_TARGET_SDK = 32
    const val ANDROID_COMPILE_SDK = 32

    const val KOTLIN = "1.7.0"
    const val KOTLIN_GRADLE_PLUGIN = KOTLIN
    const val ANDROID_GRADLE_PLUGIN = "7.2.1"
    const val NAPIER = "2.6.1"

    const val KTOR = "2.0.1"
    const val UUID = "0.4.0"
    const val DITCHOOM_BUFFER = "1.0.86"

    const val COMPOSE_MULTIPLATFORM_PLUGIN = "1.2.0-alpha01-dev753"
    const val COMPOSE_COMPILER= "1.2.0"
    const val COMPOSE= "1.2.0"
    const val COMPOSE_ACTIVITY = "1.4.0"

    const val MATERIAL = "1.4.0"


    const val APP_COMPAT= "1.4.1"
    const val ANDROID_X_CORE= "1.7.0"
    const val ANDROID_X_ACTIVITY= "1.4.0"

    const val coroutines = "1.6.4"
    const val coroutines_android = "1.6.4"
    const val coroutines_swing = "1.6.4"
    const val coroutines_core = "1.6.4"

}

object Deps {
    const val android_gradle_plugin = "com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_PLUGIN}"
    const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN_GRADLE_PLUGIN}"

    object Napier{
        const val Napier = "io.github.aakira:napier:${Versions.NAPIER}"
    }
    object Ktor {
        const val Core = "io.ktor:ktor-client-core:${Versions.KTOR}"
    }
    object UUID {
        const val UUID = "com.benasher44:uuid:${Versions.UUID}"
    }
    object DitchoomBuffer {
        const val DitchoomBuffer = "com.ditchoom:buffer:${Versions.DITCHOOM_BUFFER}"
    }
    object Material {
        const val Material = "com.google.android.material:material:${Versions.MATERIAL}"
    }
    object KaffeeVerde {
        const val ApplicationSupport = "net.smarttuner.kaffeeverde:application-support:${Versions.KAFFEEVERDE_APPLICATION_SUPPORT}"
    }

    object AndroidXPlatform{
        const val ActivityKtx = "androidx.activity:activity-ktx:${Versions.ANDROID_X_ACTIVITY}"
    }

    object Compose {
        const val ui = "androidx.compose.ui:ui:${Versions.COMPOSE}"
        const val uiUtil = "androidx.compose.ui:ui-util:${Versions.COMPOSE}"
        const val ui_viewbinding = "androidx.compose.ui:ui-viewbinding:${Versions.COMPOSE}"
        const val tooling = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
        const val tooling_preview = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}"
        const val foundation = "androidx.compose.foundation:foundation:${Versions.COMPOSE}"
        const val material = "androidx.compose.material:material:${Versions.COMPOSE}"
        const val material_icons = "androidx.compose.material:material-icons-extended:${Versions.COMPOSE}"
        const val animation = "androidx.compose.animation:animation:${Versions.COMPOSE}"
        const val runtime = "androidx.compose.runtime:runtime:${Versions.COMPOSE}"
        const val compiler = "androidx.compose.compiler:compiler:${Versions.COMPOSE}"
        const val runtime_livedata = "androidx.compose.runtime:runtime-livedata:${Versions.COMPOSE}"
        const val foundationLayout = "androidx.compose.foundation:foundation-layout:${Versions.COMPOSE}"
        const val activity = "androidx.activity:activity-compose:${Versions.COMPOSE_ACTIVITY}"
        const val runtime_debug = "androidx.compose.runtime:runtime-android-debug:${Versions.COMPOSE_ACTIVITY}"
    }

    object Coroutines {
        const val common = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines_core}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines_android}"
        const val swing = "org.jetbrains.kotlinx:kotlinx-coroutines-swing:${Versions.coroutines_swing}"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    }
}
