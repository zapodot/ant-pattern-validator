plugins {
    // Use the alias from the catalog [plugins] section
    alias(libs.plugins.kotlin.multiplatform)
}

repositories {
    mavenCentral()
}

kotlin {
    // Target configuration (macos, linux, windows, etc.)
    macosX64("native")
    linuxX64()
    mingwX64()

    sourceSets {
        commonMain.dependencies {
            // Use type-safe accessors from the [libraries] section
            implementation(libs.clikt)
            implementation(libs.okio)
        }
    }

    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
        binaries.executable {
            baseName = "ant-check"
            entryPoint = "main"
        }
    }
}