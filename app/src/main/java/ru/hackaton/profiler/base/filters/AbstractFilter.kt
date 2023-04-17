package ru.hackaton.profiler.base.filters

import ru.hackaton.profiler.base.Measurement

/**
 * This filter should implements all another filter
 */
abstract class AbstractFilter {
    /**
     * @return true - if this Measurement have unusual behavior
     */
    protected val lastMeasurements = ArrayList<Measurement>()

    open fun doFilter(measurement: Measurement): Boolean {
        lastMeasurements.add(measurement)
        return false
    }
}