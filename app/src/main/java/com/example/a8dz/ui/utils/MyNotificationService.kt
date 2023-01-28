package com.example.a8dz.ui.utils

import android.app.NotificationManager
import android.content.Context
import android.widget.EditText
import androidx.core.app.NotificationCompat
import com.example.a8dz.R

lateinit var editTextExtra: String

class MyNotificationService (private val context: Context ){

    private val notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE)as NotificationManager

    fun showNotification(){
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_anchor)
            .setContentTitle("Добро пожаловать")
            .setContentText(editTextExtra)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        notificationManager.notify(1,notification)
    }
    companion object{
        const val CHANNEL_ID = "my_notifications"
    }
}