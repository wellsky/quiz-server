val koin_version: String by project

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    kotlin("jvm") version "1.7.22"
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

