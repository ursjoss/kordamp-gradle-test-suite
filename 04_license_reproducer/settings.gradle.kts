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
    }
}

apply<SettingsPlugin>()

rootProject.name = "04_license_reproducer"

configure<ProjectsExtension> {
    setLayout("two-level")
    directories.addAll(listOf("docs", "subprojects"))

    plugins {
        path(":") {
            id("java")
            id("org.kordamp.gradle.kotlin-project")
        }
        dir("subprojects") {
            id("org.jetbrains.kotlin.jvm")
        }
    }
}
