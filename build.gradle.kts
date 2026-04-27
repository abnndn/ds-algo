plugins {
    kotlin("jvm") version "2.1.0"
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
}

// Wire both folders as Kotlin source roots in a single source set so classes
// in leetcode-kotlin and low-level-design can reference each other.
sourceSets {
    main {
        kotlin {
            srcDirs("low-level-design")
        }
    }
}
