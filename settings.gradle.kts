pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev/")
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven("https://maven.mozilla.org/maven2/")
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev/")

    }
}
rootProject.name = "KaffeeVerde Playground"

include(":example-rally-android")
include(":example-rally-desktop-jvm")
include(":example-rally-ios")
include(":example-rally-shared")
