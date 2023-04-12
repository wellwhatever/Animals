# Animals

Simple multi-module single activity compose app, that follows [android clean acritecture principles](https://developer.android.com/topic/architecture)

## Architecture:

MVVM architecture with [ViewModel as state holder](https://developer.android.com/jetpack/compose/state-hoisting#viewmodels-as-state-owner) emitting single UiState, using flows and coroutines as async tools.
The project is split into base: domain, data, core and feature modules following basic principles of recommended Android clean architecture and [modularization](https://developer.android.com/topic/modularization/patterns) by Google
Goals are: 
-- Minimize build time
-- Flexible, extendable, easy-to-understand app structure
-- Testable code

## Navigation

Implemented using [compose navigation](https://developer.android.com/jetpack/compose/navigation). This means that application does not have any fragments and uses only single activity where it draws its content

## Material You

Uses materaial3 and dynamic color providers
