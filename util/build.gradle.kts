plugins {
    id("com.apsl.glideapp.common.kotlin-publish")
    id("com.apsl.glideapp.common.kotlin-test")
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.serialization.json)
}
