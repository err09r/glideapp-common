plugins {
    id("com.apsl.glideapp.common.kotlin-publish")
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.serialization.json)
}
