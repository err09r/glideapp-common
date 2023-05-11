plugins {
    id("com.apsl.glideapp.common.kotlin-publish")
    alias(libs.plugins.kotlinx.serialization)
}

dependencies {
    api(project(":models"))
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.datetime)
}
