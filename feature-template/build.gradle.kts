@file:Suppress("DSL_SCOPE_VIOLATION", "UnstableApiUsage")

import com.example.buildlogic.AppConfig
import com.example.buildlogic.androidLibrary
import com.example.buildlogic.enableCompose

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
    namespace = "${AppConfig.APP_PACKAGE_NAME}.feature.template"

    enableCompose()
}

dependencies {
    api(project(":feature-template-api"))

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