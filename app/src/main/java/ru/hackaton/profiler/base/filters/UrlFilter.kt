package ru.hackaton.profiler.base.filters

import android.webkit.URLUtil
import ru.hackaton.profiler.base.Measurement

class UrlFilter : AbstractFilter() {
    /**
     * @return true if this url, but uncorrected
     */
    override fun doFilter(measurement: Measurement): Boolean {
        super.doFilter(measurement)
        var url = measurement.url
        return url != null && !URLUtil.isValidUrl(url)
    }
}