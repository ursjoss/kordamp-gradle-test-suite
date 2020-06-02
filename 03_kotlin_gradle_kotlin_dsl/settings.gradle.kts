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
import org.kordamp.gradle.plugin.settings.ProjectsExtension
import org.kordamp.gradle.plugin.settings.SettingsPlugin

buildscript {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }

    val kotlinVersion: String by settings
    val kordampVersion: String by settings

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")

        classpath("org.kordamp.gradle:settings-gradle-plugin:$kordampVersion")
        classpath("org.kordamp.gradle:kotlin-project-gradle-plugin:$kordampVersion")
        classpath("org.kordamp.gradle:guide-gradle-plugin:$kordampVersion")
        classpath("org.kordamp.gradle:integrationtest-gradle-plugin:$kordampVersion")
        classpath("org.kordamp.gradle:functionaltest-gradle-plugin:$kordampVersion")
        classpath("org.kordamp.gradle:detekt-gradle-plugin:$kordampVersion")
        classpath("org.kordamp.gradle:sonar-gradle-plugin:$kordampVersion")
    }
}

apply<SettingsPlugin>()

rootProject.name = "03_kotlin_gradle_kotlin_dsl"

configure<ProjectsExtension> {
    layout.set("two-level")
    directories.addAll(listOf("docs", "subprojects"))

    plugins {
        path(":") {
            id("java")
            id("org.kordamp.gradle.kotlin-project")
            id("org.kordamp.gradle.sonar")
            id("org.kordamp.gradle.detekt")
        }
        path(":guide") {
            id("org.kordamp.gradle.guide")
        }
        dir("subprojects") {
            exclude(":project3")
            id("org.jetbrains.kotlin.jvm")
            id("org.kordamp.gradle.integration-test")
        }
        path(":project3") {
            id("org.jetbrains.kotlin.jvm")
            id("org.kordamp.gradle.functional-test")
        }
    }
}
