plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.allopen") version "2.0.0"
    kotlin("plugin.jpa") version "2.0.0"
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
    apply(plugin = "org.jetbrains.kotlin.plugin.allopen")
    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")

    allOpen {
        annotation("javax.persistence.Entity")
    }
    noArg {
        annotation("com.tistory.dol9.entity.*")
    }


    dependencies {
        implementation("org.hibernate:hibernate-entitymanager:5.6.15.Final")
        implementation("com.h2database:h2:2.2.224")

        testImplementation(kotlin("test"))
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
