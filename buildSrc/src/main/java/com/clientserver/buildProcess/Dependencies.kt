object Versions {
    val kotlin = "1.3.0"
    val appengine = "2.0.0-rc3"
    val appengineApi = "1.9.49"
    val androidGradle = "3.2.1"
    val endpoints = "2.0.3"
    val javax_servlet = "2.5"
    val javax_inject = "1"
    val dagger = "2.20"
    val retrofit = "2.3.0"
    val gson = "2.7"
    val objectify = "6.0.2"
    val supportLibrary = "1.0.0"
    val coroutines = "1.0.1"
    val archComponents = "1.1.1"
    val workManager = "1.0.0-beta01"
    val mockito = "1.5.0"
    val kotlinTest = "3.1.11"
    val mockitoKotlin = "2.0.0-RC1"
}

object Dependencies {
    val androidGradle = "com.android.tools.build:gradle:${Versions.androidGradle}"
    val appengineGradle = "com.google.cloud.tools:appengine-gradle-plugin:${Versions.appengine}"
    val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val appengine = "com.google.appengine:appengine-java-sdk:${Versions.appengine}"
    val appengineApi = "com.google.appengine:appengine-api-1.0-sdk:${Versions.appengineApi}"
    val endpoints = "com.google.endpoints:endpoints-framework:${Versions.endpoints}"
    val javaxServlet = "javax.servlet:servlet-api:${Versions.javax_servlet}"
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    val kotlin8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    val javaxInject = "javax.inject:javax.inject:${Versions.javax_inject}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    val daggerProcessorAndroid = "com.google.dagger:dagger-processor:${Versions.dagger}"
    val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    val workManager = "android.arch.work:work-runtime:${Versions.workManager}"

    val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val objectify = "com.googlecode.objectify:objectify:${Versions.objectify}"
    val supportAppcompat = "androidx.appcompat:appcompat:${Versions.supportLibrary}"
    val supportRecycler = "androidx.recyclerview:recyclerview:${Versions.supportLibrary}"
    val supportCardView = "androidx.cardview:cardview:${Versions.supportLibrary}"
    val supportV4 = "androidx.legacy:legacy-support-v4:${Versions.supportLibrary}"
    val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    val roomRuntime = "android.arch.persistence.room:runtime:${Versions.archComponents}"
    val roomCompiler = "android.arch.persistence.room:compiler:${Versions.archComponents}"
    val mockito = "com.nhaarman:mockito-kotlin:${Versions.mockito}"
    val kotlinTest = "io.kotlintest:kotlintest-runner-junit5:${Versions.kotlinTest}"
    val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"

}