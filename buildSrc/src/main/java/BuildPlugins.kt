object BuildPlugins {
    const val GRADLE_PLUGIN = "7.4.2"
    const val DAGGER_HILT = "2.45"
    const val KOTLIN = "1.8.10"

    val gradle by lazy { "com.android.tools.build:gradle:$GRADLE_PLUGIN" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN" }
    val daggerHilt by lazy { "com.google.dagger:hilt-android-gradle-plugin:$DAGGER_HILT" }
}