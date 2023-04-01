@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
    }
}
rootProject.name = "glideapp-common"
include("dto")
include("util")
include("models")
