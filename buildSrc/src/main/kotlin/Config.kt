@file:Suppress("ConstPropertyName")

import org.gradle.api.JavaVersion

object Config {
    const val group = "com.apsl.glideapp.common"
    const val version = "0.1.5"

    val javaVersion = JavaVersion.VERSION_1_8

    object DependencyUpdates {
        const val outputFormatter = "html"
        const val reportfileName = "report"
    }
}
