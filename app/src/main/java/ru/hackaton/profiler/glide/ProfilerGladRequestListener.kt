package ru.hackaton.profiler.glide

import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import ru.hackaton.profiler.base.Library
import ru.hackaton.profiler.base.MeasurementService
import ru.hackaton.profiler.base.Stacktrace

class ProfilerGladRequestListener<R>(private val name: String): RequestListener<R> {
    override fun onLoadFailed(
        e: GlideException?,
        model: Any?,
        target: Target<R>?,
        isFirstResource: Boolean
    ): Boolean {
        val measurement = MeasurementService.startMeasurement(name, Library.Glide)
        measurement.status.exception = e
        MeasurementService.endMeasurement(measurement.id)
        return false
    }

    override fun onResourceReady(
        resource: R,
        model: Any?,
        target: Target<R>?,
        dataSource: DataSource?,
        isFirstResource: Boolean
    ): Boolean {
        if (dataSource != DataSource.REMOTE) {
            return false
        }
        val measurement = MeasurementService.startMeasurement(name, Library.Glide)
        MeasurementService.endMeasurement(measurement.id)
        measurement.stackTrace = Stacktrace.getTraceback()
        return false
    }
}