package ru.hackaton.profiler.base.filters

import ru.hackaton.profiler.base.Measurement

class DurationFilter : AbstractFilter() {

    private var UPPER_BOUND = 1.3

    /**
     * @return true if duration of loading current file is too long then previous
     */
    override fun doFilter(measurement: Measurement): Boolean {
        super.doFilter(measurement)
        if (measurement.status.endTimestamp == null || this.lastMeasurements.size < 20) {
            return false
        }

        var avarage = 0.0
        var count = 0

        for (i in this.lastMeasurements) {
            if (i.status.endTimestamp != null) {
                avarage += (i.status.endTimestamp!! - i.status.startTimestamp)
                count++
            }
        }
        val currentTime =
            measurement.status.endTimestamp!! - measurement.status.startTimestamp
        val averageTime = avarage / count
        return currentTime > averageTime * UPPER_BOUND
    }
}