package libs

import org.gradle.api.artifacts.dsl.DependencyHandler

object Retrofit {
    const val RETROFIT_VERSION = "2.9.0"
    const val MOSHI_VERSION = "1.14.0"

    private val dependencies = listOf(
        "com.squareup.retrofit2:retrofit:$RETROFIT_VERSION",
        "com.squareup.retrofit2:converter-moshi:$RETROFIT_VERSION",
        "com.squareup.moshi:moshi:$MOSHI_VERSION"
    )

    fun DependencyHandler.retrofit(configurationName: String = "implementation") {
        dependencies.forEach { add(configurationName, it) }
        add("kapt", "com.squareup.moshi:moshi-kotlin-codegen:$MOSHI_VERSION")
    }
}