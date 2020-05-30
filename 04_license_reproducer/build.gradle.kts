import org.kordamp.gradle.plugin.base.ProjectsExtension

config {
    release = rootProject.findProperty("release").toString().toBoolean()

    info {
        name = "Sample"
        vendor = "Kordmap"
        description = "sample project"
        organization {
            name = "Kordamp"
            url = "https://kordamp.org"
        }

        links {
            website = "https://github.com/aalmiray/kordamp-gradle-plugins-workshop"
            issueTracker = "https://github.com/aalmiray/kordamp-gradle-plugins-workshop/issues"
            scm = "https://github.com/aalmiray/kordamp-gradle-plugins-workshop.git"
        }

        people {
            person {
                id = "anonymous"
                name = "Anonymous"
                roles = listOf("developer")
            }
        }
    }

    licensing {
        enabled = false
        licenses {
            license {
                id = "Apache-2.0"
            }
        }
    }
}

val junitVersion: String by project

configure<ProjectsExtension> {
    all {
        path("*") {
            repositories {
                mavenLocal()
                mavenCentral()
                jcenter()
            }
        }

        dir("subprojects") {
            val junitVersion: String by project
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
                testImplementation("junit:junit:$junitVersion")
            }
        }
    }
}
