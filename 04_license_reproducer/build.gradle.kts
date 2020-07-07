import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.kordamp.gradle.plugin.base.ProjectsExtension

config {
    release = rootProject.findProperty("release").toString().toBoolean()

    info {
        name = "Kordamp License Reproducer"
        vendor = "none"
        description = "sample project to validate the license plugin when disabled"

        links {
            website = "https://github.com/ursjoss/kordamp-gradle-test-suite"
            issueTracker = "https://github.com/ursjoss/kordamp-gradle-test-suite/issues"
            scm = "https://github.com/ursjoss/kordamp-gradle-test-suite.git"
        }

        people {
            person {
                id = "ursjoss"
                name = "Urs Joss"
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
                testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
            }
            java {
                sourceCompatibility = JavaVersion.VERSION_11
                targetCompatibility = JavaVersion.VERSION_11
            }
            tasks {
                withType<KotlinCompile>().configureEach {
                    kotlinOptions.jvmTarget = JavaVersion.VERSION_11.majorVersion
                }
            }
        }
    }
}
