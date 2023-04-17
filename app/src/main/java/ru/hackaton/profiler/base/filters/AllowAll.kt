package ru.hackaton.profiler.base.filters

import ru.hackaton.profiler.base.Measurement

class AllowAll : AbstractFilter() {
    override fun doFilter(measurement: Measurement): Boolean {
        return true
    }
}