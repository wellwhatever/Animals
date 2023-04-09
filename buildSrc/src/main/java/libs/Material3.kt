package libs

import org.gradle.api.artifacts.dsl.DependencyHandler

object Material3 {
    private const val MATERIAL3 = "1.0.1"

    private val dependencies = listOf(
        "androidx.compose.material3:material3:$MATERIAL3"
    )

    fun DependencyHandler.material3(configurationName: String = "implementation") =
        dependencies.forEach { add(configurationName, it) }
}