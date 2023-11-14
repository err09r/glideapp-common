dependencies {
    "testImplementation"(libs.kotlin.test)
    "testImplementation"(libs.kotlinx.coroutines.test)
    "testImplementation"(libs.turbine)
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
