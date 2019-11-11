/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2019 Anonymous.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
plugins {
    id("org.kordamp.gradle.project")
    java
}

config {
    release = rootProject.findProperty("release").toString().toBoolean()

    info {
        name = "Sample"
        vendor = "Kordmap"
        description = "sample project"
        organization {
            name = "Kordamp"
            url = "http://kordamp.org"
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
}

allprojects {
    repositories {
        mavenLocal()
        jcenter()
    }

    tasks {
        val deleteOutFolderTask by registering(Delete::class) {
            delete("out")
        }
        named("clean") {
            dependsOn(deleteOutFolderTask)
        }
    }
}

subprojects {
    apply<JavaPlugin>()
    apply<IdeaPlugin>()

    dependencies {
        testImplementation("junit:junit:4.12")
    }
}
