plugins {
    id("com.apsl.glideapp.common.kotlin-publish")
    id("com.apsl.glideapp.common.kotlin-test")
    alias(libs.plugins.kotlin.serialization)
}

dependencies {
    implementation(project(":util"))
    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.serialization.json)
}
