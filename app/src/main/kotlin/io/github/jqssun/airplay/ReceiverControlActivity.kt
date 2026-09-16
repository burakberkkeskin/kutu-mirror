package io.github.jqssun.airplay

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import io.github.jqssun.airplay.service.AirPlayService

/**
 * Lightweight headless entry point to start the Kutu Mirror service.
 * Displays no UI and exits immediately.
 */
class ReceiverControlActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            val intent = Intent(this, AirPlayService::class.java).apply {
                action = AirPlayService.ACTION_START_SERVER
            }
            ContextCompat.startForegroundService(this, intent)
        } catch (e: Exception) {
            // Ignored
        }
        finish()
    }
}
