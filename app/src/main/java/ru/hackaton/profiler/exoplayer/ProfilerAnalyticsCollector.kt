package ru.hackaton.profiler.exoplayer

import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.analytics.AnalyticsListener
import com.google.android.exoplayer2.source.LoadEventInfo
import com.google.android.exoplayer2.source.MediaLoadData
import ru.hackaton.profiler.base.Library
import ru.hackaton.profiler.base.MeasurementService
import ru.hackaton.profiler.base.RequestType


class ProfilerAnalyticsCollector(
    private val name: String
) : AnalyticsListener {
    private fun getRequestType(mediaLoadData: MediaLoadData): RequestType {
        if (mediaLoadData.trackType == C.TRACK_TYPE_VIDEO) {
            return RequestType.Video
        } else if (mediaLoadData.trackType == C.TRACK_TYPE_AUDIO) {
            return RequestType.Audio
        }
        return RequestType.Unknown;
    }


    override fun onLoadStarted(
        eventTime: AnalyticsListener.EventTime,
        loadEventInfo: LoadEventInfo,
        mediaLoadData: MediaLoadData
    ) {
        val measurement = MeasurementService.startMeasurement(
            loadEventInfo.loadTaskId.toString(),
            name,
            Library.ExoPlayer,
            getRequestType(mediaLoadData)
        )
    }

    override fun onLoadCompleted(
        eventTime: AnalyticsListener.EventTime,
        loadEventInfo: LoadEventInfo,
        mediaLoadData: MediaLoadData
    ) {
        val policy = ThreadPolicy.Builder()
            .permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val measurement = MeasurementService.endMeasurement(
            loadEventInfo.loadTaskId.toString(),
            loadEventInfo.uri.toString(),
            loadEventInfo.bytesLoaded,
            true
        )
    }
}