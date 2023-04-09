package libs

import org.gradle.api.artifacts.dsl.DependencyHandler

object NavigationCompose {

    private const val NAVIGATION_COMPOSE_VERSION = "2.5.3"

    fun DependencyHandler.navigation(configurationName: String = "implementation") {
        add(configurationName, "androidx.navigation:navigation-compose:$NAVIGATION_COMPOSE_VERSION")
    }
}