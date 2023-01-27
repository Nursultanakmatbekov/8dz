package com.example.a8dz.ui.utils

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.example.a8dz.R

var edtextExtra = ""
const val notificationID = 1

class MyNotificationService (
    private val context: Context ){

    private val notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE)as NotificationManager

    fun showNotification(){
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_anchor)
            .setContentTitle(edtextExtra)
            .setContentText("Добро пожаловать")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        notificationManager.notify(notificationID,notification)
    }
    companion object{
        const val CHANNEL_ID = "my_notifications"
    }
}