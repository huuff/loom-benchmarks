plugins {
    id("java")
    id("org.springframework.boot") version "2.7.4"
    id("io.freefair.lombok") version "6.5.1"
    id("com.google.cloud.tools.jib") version "3.2.1"
}

group = "xyz.haff.loombenchmarks"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    val junitVersion = "5.9.0"
    val springdocVersion = "1.6.11"

    implementation(platform("org.springframework.boot:spring-boot-dependencies:2.7.4"))

    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    implementation("org.springdoc:springdoc-openapi-ui:$springdocVersion")
    implementation("org.springdoc:springdoc-openapi-data-rest:$springdocVersion")
    implementation("com.opencsv:opencsv:5.7.0")


    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

tasks.test {
    useJUnitPlatform()
}

jib {
    from {
        image = "gcr.io/distroless/java17-debian11@sha256:80b21bccb947050e0a944848340cf2cc229ec0f174490d263b57a66a60d290a2"
    }
    to {
        image = "loom-benchmark-data-rest"
    }
}