import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    application
}

group = "com.tomazwang.app"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


val kotestVersion =  "5.0.3"

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
}

tasks.test {
    useJUnit()
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}