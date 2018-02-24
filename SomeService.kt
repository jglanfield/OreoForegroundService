package com.example.joel.servicetest

import android.app.*
import android.content.Intent
import android.os.IBinder
import android.support.v4.app.NotificationCompat
import android.util.Log

/**
 * Created by joel on 2018-02-23.
 */

class SomeService : Service() {
    companion object {
        private val TAG = "SomeService"
        private val NOTIFICATION_ID = 42
        private val CHANNEL_ID = "123456"
    }

    override fun onCreate() {
        Log.d(TAG, "onCreate")

        // TODO: do important tasks here...

        // this must be called within 5 seconds of a call to startForegroundService()
        startForeground(NOTIFICATION_ID, getNotification())
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    private fun getNotification(): Notification {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Notification title")
                .setContentText("Notification text")
                .setOngoing(true)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setWhen(System.currentTimeMillis())

        return builder.build()
    }
}