plugins {
    id("java")
    id("org.springframework.boot") version "2.7.4"
    id("io.freefair.lombok") version "6.5.1"
    id("org.openapi.generator") version "6.2.0"
}

group = "xyz.haff.loombenchmarks"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    val junitVersion = "5.9.0"

    implementation(platform("org.springframework.boot:spring-boot-dependencies:2.7.4"))
    implementation("org.springframework.boot:spring-boot-starter-web")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")

    // OpenAPI copy-pasted
    implementation("io.swagger:swagger-annotations:1.6.5")
    implementation("com.google.code.findbugs:jsr305:3.0.2")
    implementation("com.squareup.okhttp3:okhttp:4.9.3")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("io.gsonfire:gson-fire:1.8.5")
    implementation("javax.ws.rs:jsr311-api:1.1.1")
    implementation("javax.ws.rs:javax.ws.rs-api:2.1.1")
    implementation("org.openapitools:jackson-databind-nullable:0.2.3")
    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("jakarta.annotation:jakarta.annotation-api:1.3.5")
}

tasks.test {
    useJUnitPlatform()
}

val apiGeneratedSources = "$buildDir/generated-sources/client"
openApiGenerate {
    generatorName.set("java")
    inputSpec.set("$projectDir/src/main/resources/api.json")
    outputDir.set(apiGeneratedSources)
}

tasks.compileJava {
    dependsOn(tasks.openApiGenerate)
}

java {
    sourceSets["main"].java.srcDir(file("$apiGeneratedSources/src/main/java"))
}
