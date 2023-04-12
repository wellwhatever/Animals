package libs

import org.gradle.api.artifacts.dsl.DependencyHandler

object Kotlin {
    private const val KOTLIN_VERSION = "1.8.20"
    private const val KOTLIN_COROUTINES_VERSION = "1.6.4"
    private const val DESUGARING = "2.0.3"
    private const val KOTLINX_COLLECTIONS_IMMUTABLE = "0.3.5"

    private val dependencies = listOf(
        "org.jetbrains.kotlin:kotlin-stdlib:$KOTLIN_VERSION",
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:$KOTLIN_COROUTINES_VERSION",
        "org.jetbrains.kotlinx:kotlinx-collections-immutable:$KOTLINX_COLLECTIONS_IMMUTABLE"
    )

    fun DependencyHandler.kotlin(configurationName: String = "implementation") =
        dependencies.forEach { add(configurationName, it) }
}