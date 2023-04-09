package libs

import org.gradle.api.artifacts.dsl.DependencyHandler

object Hilt {
    const val HILT_VERSION = "2.45"
    const val HILT_COMPOSE_VERSION = "1.0.0"

    private val dependencies = listOf(
        "com.google.dagger:hilt-android:$HILT_VERSION",
        "androidx.hilt:hilt-navigation-compose:$HILT_COMPOSE_VERSION"
    )

    fun DependencyHandler.hilt(configurationName: String = "implementation") {
        dependencies.forEach { add(configurationName, it) }
        add("kapt", "com.google.dagger:hilt-android-compiler:$HILT_VERSION")
        add("kapt", "androidx.hilt:hilt-compiler:$HILT_COMPOSE_VERSION")
    }
}