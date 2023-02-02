@file:Suppress("DSL_SCOPE_VIOLATION", "UnstableApiUsage")

import package_name.buildlogic.androidLibrary
import package_name.buildlogic.enableCompose

plugins {
    alias(libs.plugins.library)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kapt)
    alias(libs.plugins.hilt)
    alias(libs.plugins.router)
    alias(libs.plugins.detekt)
}

apply(from = "../config/jacoco/modules.kts")

androidLibrary {
    namespace = "package_name.feature.feature_name"

    enableCompose()
}

dependencies {
    api(project(":feature-feature_name-api"))

    implementation(libs.core.ktx)
    implementation(libs.material)
    implementation(libs.bundles.compose)
    implementation(libs.accompanist.permission)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    implementation(libs.router)
    kapt(libs.router.compiler)

    api(libs.ark.ui)

    testImplementation(libs.junit4)

    androidTestImplementation(libs.androidx.junit.ktx)

    detektPlugins(libs.detekt.formatting)
}