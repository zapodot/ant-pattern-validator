import org.jetbrains.kotlin.gradle.internal.util.PlatformType
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotest)
    alias(libs.plugins.google.ksp)
}

repositories {
    mavenCentral()
}


kotlin {
    jvmToolchain(21)
    macosX64()
    linuxX64()
    mingwX64()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.clikt)
            implementation(libs.okio)
        }
        commonTest.dependencies {
            implementation(libs.kotest.framework)
            implementation(libs.kotest.assertions)
        }
        macosX64Test.dependencies {
            implementation(libs.kotest.framework)
            implementation(libs.kotest.assertions)
        }

    }

    targets.withType<KotlinNativeTarget> {
        binaries.executable {
            baseName = "ant-check"
            entryPoint = "org.zapodot.antpatternvalidator.main"
        }
    }
}