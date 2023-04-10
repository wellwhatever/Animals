package libs

import org.gradle.api.artifacts.dsl.DependencyHandler

object UiTests {
    private const val JUNIT = "1.1.5"
    private const val ESPRESSO_CORE = "3.5.1"

    private val dependencies = listOf(
        "androidx.test.ext:junit:$JUNIT",
        "androidx.test.espresso:espresso-core:$ESPRESSO_CORE"
    )

    fun DependencyHandler.uiTests(configurationName: String = "androidTestImplementation") =
        dependencies.forEach { add(configurationName, it) }
}