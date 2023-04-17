package ru.hackaton.profiler.base

import android.net.TrafficStats

data class Status(
    val startTimestamp: Long = System.currentTimeMillis(),
    var endTimestamp: Long? = null,
    val startSizeStamp: Long = TrafficStats.getTotalRxBytes() + TrafficStats.getTotalTxBytes(),
    var endSizeStamp: Long? = null,
    var exception: Exception? = null
)
