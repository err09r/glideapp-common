plugins {
    id("com.apsl.glideapp.common.kotlin-library")
    `maven-publish`
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = project.name
            groupId = project.group.toString()
            version = project.version.toString()

            from(components["kotlin"])
        }
    }
}
