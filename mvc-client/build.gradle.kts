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
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}