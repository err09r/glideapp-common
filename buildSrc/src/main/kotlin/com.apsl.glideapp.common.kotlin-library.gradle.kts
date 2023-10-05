import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    kotlin("jvm")
}

group = Config.group
version = project.property("artifactVersion").toString()

java {
    withSourcesJar()
    withJavadocJar()

    sourceCompatibility = Config.javaVersion
    targetCompatibility = Config.javaVersion
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = Config.javaVersion.toString()
    }
}
