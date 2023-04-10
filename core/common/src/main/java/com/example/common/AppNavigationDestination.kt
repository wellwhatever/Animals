package com.example.common

/**
 * Interface for describing app navigation destination,
 * every destination should have it's unique navigation destination
 */
interface AppNavigationDestination {
    /**
     * Deep link for a specific navigation destination
     */
    val route: String

    /**
     * Destination id to discern specific destination from nested graph's route
     */
    val destination: String
}