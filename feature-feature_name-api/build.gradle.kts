@file:Suppress("DSL_SCOPE_VIOLATION", "UnstableApiUsage")

import package_name.buildlogic.AppConfig
import package_name.buildlogic.androidLibrary

plugins {
    alias(libs.plugins.library)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kapt)
    alias(libs.plugins.router)
    alias(libs.plugins.detekt)
}

apply(from = "../config/jacoco/modules.kts")

androidLibrary {
    namespace = "package_name.feature.feature_name.api"
}

dependencies {
    implementation(libs.router)
    kapt(libs.router.compiler)

    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.junit.ktx)

    detektPlugins(libs.detekt.formatting)
}