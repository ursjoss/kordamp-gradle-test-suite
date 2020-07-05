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
config {
    release = rootProject.findProperty("release").toString().toBoolean()

    info {
        name = "Kordamp Java Project 2"
        vendor = "none"
        description = "sample project to validate functionality with java & gradle kotlin DSL configuration"

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

    coverage {
        jacoco {
            includeProjectDependencies = true
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
}

val junitVersion: String by project
projects {
    all {
        path("*") {
            repositories {
                mavenLocal()
                jcenter()
            }
        }
        dir("subprojects") {
            dependencies {
                testImplementation("junit:junit:$junitVersion")
            }
        }
    }
}
