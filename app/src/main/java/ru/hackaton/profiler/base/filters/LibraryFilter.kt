package ru.hackaton.profiler.base.filters

import ru.hackaton.profiler.base.Measurement

class LibraryFilter :AbstractFilter() {
    /**
     * @return true if library or name is null
     */
    override fun doFilter(measurement: Measurement): Boolean {
        super.doFilter(measurement)
        return measurement.library == null || measurement.name == null
    }
}