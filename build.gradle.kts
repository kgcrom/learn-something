plugins {
    id("java")
    kotlin("jvm") version "2.0.0"
}

allprojects {
    group = "com.tistory.dol9"
    version = "1.0-SNAPSHOT"
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "kotlin")

    dependencies {
        testImplementation(kotlin("test"))
        testImplementation(platform("org.junit:junit-bom:5.10.0"))
        testImplementation("org.junit.jupiter:junit-jupiter")
    }

    tasks {
        test {
            useJUnitPlatform()
        }
    }

    kotlin {
        jvmToolchain(21)
    }
}
