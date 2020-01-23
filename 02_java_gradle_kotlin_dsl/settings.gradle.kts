/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2020 Anonymous.
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
import org.kordamp.gradle.plugin.settings.ProjectsExtension
import org.kordamp.gradle.plugin.settings.SettingsPlugin

pluginManagement {
    repositories {
        mavenLocal()
        jcenter()
        gradlePluginPortal()
    }
    plugins {
        kotlin("jvm") version "1.3.61"
        val kordampVersion = "0.32.0-SNAPSHOT"
        id("org.kordamp.gradle.project") version kordampVersion
        id("org.kordamp.gradle.guide") version kordampVersion
        id("org.kordamp.gradle.integration-test") version kordampVersion
        id("org.kordamp.gradle.functional-test") version kordampVersion
    }
}

buildscript {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
    val kordampVersion = "0.32.0-SNAPSHOT"
    dependencies {
        classpath("org.kordamp.gradle:settings-gradle-plugin:$kordampVersion")
    }
}

apply<SettingsPlugin>()

rootProject.name = "02_java_gradle_kotlin_dsl"

configure<ProjectsExtension> {
    layout = "two-level"
    directories = listOf("docs", "subprojects")
}
