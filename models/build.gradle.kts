plugins {
    id("com.apsl.glideapp.common.kotlin-publish")
    alias(libs.plugins.kotlin.serialization)
}

dependencies {
    implementation(project(":util"))
    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.serialization.json)
}
