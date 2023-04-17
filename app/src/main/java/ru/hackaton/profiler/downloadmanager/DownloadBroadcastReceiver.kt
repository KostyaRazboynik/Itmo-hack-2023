package ru.hackaton.profiler.downloadmanager

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import ru.hackaton.profiler.base.Library
import ru.hackaton.profiler.base.MeasurementService

class DownloadBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val action = intent!!.action

        if (DownloadManager.ACTION_DOWNLOAD_COMPLETE == action) {
            println("qweqwe")
            val measurement = MeasurementService.startMeasurement("BroadcastStart", Library.DownloadManager)
//            MeasurementService.endMeasurement(measurement.id)
        }
    }

}