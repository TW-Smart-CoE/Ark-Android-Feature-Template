@file:Suppress("DSL_SCOPE_VIOLATION", "UnstableApiUsage")

import com.example.buildlogic.AppConfig
import com.example.buildlogic.androidLibrary

plugins {
    alias(libs.plugins.library)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kapt)
    alias(libs.plugins.router)
    alias(libs.plugins.detekt)
}

apply(from = "../config/jacoco/modules.kts")

androidLibrary {
    namespace = "${AppConfig.APP_PACKAGE_NAME}.feature.template.api"
}

dependencies {
    implementation(libs.router)
    kapt(libs.router.compiler)

    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.junit.ktx)

    detektPlugins(libs.detekt.formatting)
}