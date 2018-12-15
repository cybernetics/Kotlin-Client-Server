plugins {
    id("war")
    id("com.google.cloud.tools.appengine-standard")
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {
    api(project(":consumer-server:domain-server"))
    api(project(":consumer-server:repository-server"))
    implementation(Dependencies.objectify)
    implementation(Dependencies.endpoints)
    implementation(Dependencies.javaxServlet)
    implementation(Dependencies.kotlin)
    implementation(Dependencies.javaxInject)
    implementation(Dependencies.daggerCompiler)
    kapt(Dependencies.dagger)
    implementation(Dependencies.gson)
    implementation(project(":core-domain"))
    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.mockito)
}

appengine {
    deploy {
        version = "2"
        projectId = "APPENGINE_CONFIG"
    }
}


