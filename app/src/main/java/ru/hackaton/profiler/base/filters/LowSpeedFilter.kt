package ru.hackaton.profiler.base.filters

import ru.hackaton.profiler.base.Measurement

class LowSpeedFilter : AbstractFilter() {
    // lower on 30%
    private val UPPER_BOUND = 1.3;
    override fun doFilter(measurement: Measurement): Boolean {
        super.doFilter(measurement)
        if (this.lastMeasurements.size < 20 || measurement.size == null) {
            return false
        }

        var avarage = 0.0
        var count = 0

        for (i in this.lastMeasurements) {
            if (i.size != null && i.status.endTimestamp != null) {
                avarage += i.size!!.toFloat() / (i.status.endTimestamp!! - i.status.startTimestamp)
                count++
            }
        }
        val currentSpeed =
            measurement.size!!.toFloat() / (measurement.status.endTimestamp!! - measurement.status.startTimestamp)
        val averageSpeed = avarage / count
        return currentSpeed * UPPER_BOUND < averageSpeed
    }
}