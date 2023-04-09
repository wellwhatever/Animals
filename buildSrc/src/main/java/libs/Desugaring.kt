package libs

import org.gradle.api.artifacts.dsl.DependencyHandler

object Desugaring {

    private const val DESUGARING = "2.0.3"

    private val dependencies = listOf(
        "com.android.tools:desugar_jdk_libs:$DESUGARING"
    )

    fun DependencyHandler.desugaring(configurationName: String = "coreLibraryDesugaring") =
        dependencies.forEach { add(configurationName, it) }
}