package com.example.animals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.animals.ui.theme.AnimalsTheme
import timber.log.Timber

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupTimber()
        setContent {
            AnimalsTheme {
                AnimalsAppStartRoute()
            }
        }
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            // FIXME: plant release tree here, dummy for now
            Timber.plant(Timber.DebugTree())
        }
    }
}