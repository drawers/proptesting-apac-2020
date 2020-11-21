plugins {
    kotlin("jvm") version "1.4.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        showStandardStreams = true
    }
}

dependencies {
    implementation(kotlin("stdlib"))

    testImplementation(group = "org.easymock", name = "easymock", version = "4.2")
    testImplementation(group = "com.nhaarman.mockitokotlin2", name = "mockito-kotlin", version = "2.2.0")
    testImplementation(group = "junit", name = "junit", version = "4.13")
    testImplementation(group = "org.assertj", name = "assertj-core", version = "3.18.1")
    testImplementation(group = "io.kotest", name = "kotest-runner-junit5", version = "4.3.1")
    testImplementation(group = "io.kotest", name = "kotest-assertions-core", version = "4.3.1")
    testImplementation(group = "io.kotest", name = "kotest-property", version = "4.3.1")
}
