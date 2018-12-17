import org.gradle.kotlin.dsl.`kotlin-dsl`


buildscript {

    repositories {
        jcenter()
        mavenCentral()
        google()
        mavenLocal()
        maven { url = uri("https://maven.fabric.io/public") }
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.2.61")
    }
}

plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

repositories {
    google()
    jcenter()
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.11")
}
