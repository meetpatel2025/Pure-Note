// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
//    id("com.google.devtools.ksp") version "2.3.4" apply false
//    alias(libs.plugins.android.application) apply false


    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
//    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.androidx.navigation.safeargs.kotlin) apply false
    alias(libs.plugins.kotlin.parcelize) apply false



}
//
//buildscript {
//    dependencies {
//        val nav_version = "2.9.7"
//        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
//
//    }
//}
