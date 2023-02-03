
plugins {
    java
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.allopen") version "1.7.22"
    id("io.quarkus")
}

repositories {
    mavenCentral()
    mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("org.jboss.slf4j:slf4j-jboss-logmanager")
    implementation("io.quarkiverse.jooq:quarkus-jooq:0.4.0")
    implementation("io.quarkus:quarkus-kotlin")
    implementation("io.quarkus:quarkus-agroal")
    implementation("io.quarkus:quarkus-hibernate-reactive-panache-kotlin")
    implementation("io.quarkus:quarkus-smallrye-graphql")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.quarkus:quarkus-arc")
    implementation("io.quarkus:quarkus-jdbc-postgresql")
    implementation("org.liquibase:liquibase-core:4.19.0")
    testImplementation("io.quarkus:quarkus-junit5")
    implementation("org.jooq:jooq-codegen:3.17.7")
    implementation("com.graphql-java:java-dataloader:3.1.0")
}

group = "com.example"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<Test> {
    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
}
allOpen {
    annotation("javax.ws.rs.Path")
    annotation("javax.enterprise.context.ApplicationScoped")
    annotation("io.quarkus.test.junit.QuarkusTest")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
    kotlinOptions.javaParameters = true
}

tasks.register<JavaExec>("jooqCodegen") {
    mainClass.set("com.example.util.JooqCodegenKt")
    classpath = sourceSets["main"].runtimeClasspath
}