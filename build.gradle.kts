import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    id("org.jetbrains.kotlinx.kover") version "0.5.0"
    application
}

group = "com.pontotest"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}

kover {
    generateReportOnCheck = false
}

tasks.test {
    extensions.configure(kotlinx.kover.api.KoverTaskExtension::class) {
        isDisabled = false
        excludes = listOf("okhttp3.*", "io.grpc.*")
    }
}

tasks.koverXmlReport {
    isEnabled = true
    xmlReportFile.set(
        layout.buildDirectory.file(
            "$buildDir/reports/coverage-result.xml"
        )
    )
}

tasks.koverVerify {
    rule {
        name = "Minimum line coverage percentage rate"
        bound {
            minValue = 30
            valueType = kotlinx.kover.api.VerificationValueType.COVERED_LINES_PERCENTAGE
        }
    }
}




