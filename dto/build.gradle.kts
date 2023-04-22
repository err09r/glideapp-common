plugins {
    id("com.apsl.glideapp.common.kotlin-publish")
    alias(libs.plugins.kotlin.serialization)
}

dependencies {
    api(project(":models"))
    implementation(libs.kotlin.serialization.json)
}
