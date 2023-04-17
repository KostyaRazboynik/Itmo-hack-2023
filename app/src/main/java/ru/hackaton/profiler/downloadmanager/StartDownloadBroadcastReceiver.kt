package ru.hackaton.profiler.downloadmanager

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class StartDownloadBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val action = intent!!.action

        if (DownloadManager.ACTION_NOTIFICATION_CLICKED == action) {
            println(intent.toUri(Intent.URI_INTENT_SCHEME).toString())
        }
    }

}