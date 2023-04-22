plugins {
    id("com.apsl.glideapp.common.kotlin-publish")
    alias(libs.plugins.kotlin.serialization)
}

dependencies {
    implementation(libs.kotlin.serialization.json)
    implementation(libs.kotlin.coroutines.core)
    implementation(libs.kotlin.datetime)
}
