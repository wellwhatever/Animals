package libs

import org.gradle.api.artifacts.dsl.DependencyHandler

object Compose {
    private const val COMPOSE_BOM = "2023.03.00"
    const val COMPOSE_COMPILER = "1.4.4"
    const val COMPOSE_PREVIEW = "1.4.1"

    fun DependencyHandler.compose(configurationName: String = "implementation") {
        add(configurationName, platform("androidx.compose:compose-bom:$COMPOSE_BOM"))
        add(configurationName, "androidx.compose.ui:ui-tooling:$COMPOSE_PREVIEW")
    }
}