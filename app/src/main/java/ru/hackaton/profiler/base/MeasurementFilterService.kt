package ru.hackaton.profiler.base

import ru.hackaton.profiler.base.filters.AllowAll
import ru.hackaton.profiler.base.filters.DurationFilter
import ru.hackaton.profiler.base.filters.ExceptionFilter
import ru.hackaton.profiler.base.filters.LibraryFilter
import ru.hackaton.profiler.base.filters.LowSpeedFilter
import ru.hackaton.profiler.base.filters.UrlFilter
import java.lang.RuntimeException

object MeasurementFilterService {
    private val filters = arrayListOf(
        ExceptionFilter(),
        LowSpeedFilter(),
        DurationFilter(),
        LibraryFilter(),
        UrlFilter(),
        AllowAll()
    )

    fun checkMeasurement(measurement: Measurement) {
        for (filter in filters) {
            try {
                if(filter.doFilter(measurement)) {
                    MeasurementApi.sendToServer(measurement)
                }
            } catch (e: RuntimeException) {
                measurement.status.exception = e
                MeasurementApi.sendToServer(measurement)
            }
        }
    }
}