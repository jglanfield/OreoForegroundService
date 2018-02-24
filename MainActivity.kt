package com.example.joel.servicetest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scanningService = Intent(this, SomeService::class.java)
        startForegroundService(scanningService)

        // startForeground() must be called within 5 seconds of service creation
    }
}
