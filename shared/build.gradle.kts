import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.sqldelight)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = false
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation("app.cash.sqldelight:coroutines-extensions:2.0.0")
            implementation("app.cash.sqldelight:runtime:2.0.0")
            implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        androidMain.dependencies {
            implementation("app.cash.sqldelight:android-driver:2.0.0")
        }
        iosMain.dependencies {
            implementation("app.cash.sqldelight:native-driver:2.0.0")
        }
    }
}


sqldelight {
    databases {
        create(name = "NoteDatabase") {
            packageName.set("com.example.noteappkmm.db")
        }
    }
}

android {
    namespace = "com.example.notesappkmm"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}

