package ru.hackaton.profiler.exoplayer

import android.content.Context
import android.os.Handler
import android.os.Looper
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector
import com.google.android.exoplayer2.util.Clock
import com.google.android.exoplayer2.util.SystemClock

class ExoPlayerClient {
    fun getClient(context: Context) : ExoPlayer {
        val analyticsCollector = DefaultAnalyticsCollector(Clock.DEFAULT)

        analyticsCollector.addListener(ProfilerAnalyticsCollector("ExoPlayer"))

        return ExoPlayer.Builder(context).setAnalyticsCollector(analyticsCollector).build()
    }
}