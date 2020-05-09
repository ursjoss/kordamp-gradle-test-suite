/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2020 Anonymous.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
        enabled = true
        licenses {
            license {
                id = "Apache-2.0"
            }
        }
    }

    quality {
        detekt {
            buildUponDefaultConfig = true
            failFast = true
        }

        sonar {
            username = "ursjoss"
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
