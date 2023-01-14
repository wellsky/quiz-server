val koin_version: String by project
val exposed_version: String by project
val h2_version: String by project

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    kotlin("jvm")

    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:31.0.1-jre")

    // Koin
    implementation("io.insert-koin:koin-core:$koin_version")

    // Exposed
    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")

    // DB drivers
    implementation("mysql:mysql-connector-java:8.0.30")
    implementation("com.h2database:h2:$h2_version")
    implementation("org.xerial:sqlite-jdbc:3.40.0.0")

    implementation(project(":model"))
}
