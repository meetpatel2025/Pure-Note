// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
//    alias(libs.plugins.kotlin.android) apply false
//    alias(libs.plugins.ksp) apply false
//    alias(libs.plugins.kotlin.parcelize) apply false
//    alias(libs.plugins.androidx.navigation.safeargs.kotlin) apply false

//
    alias(libs.plugins.navigation.safe.args) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
    // Source - https://stackoverflow.com/a/79529977
// Posted by SosaCD, modified by community. See post 'Timeline' for change history
// Retrieved 2026-03-03, License - CC BY-SA 4.0

//    id("org.jetbrains.kotlin.plugin.parcelize") version libs.versions.kotlin apply false

    id("com.google.devtools.ksp") version "2.3.4" apply false

}