package ru.hackaton.profiler.url

import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL


class MyHttpURLConnection(url: URL) : HttpURLConnection(url) {
    private val conn: HttpURLConnection

    init {
        val newUrlString = url.toExternalForm()
        val u =URL(newUrlString)

        conn = URL(newUrlString).openConnection() as HttpURLConnection
    }

    override fun disconnect() {
        conn.disconnect()
    }

    override fun usingProxy(): Boolean {
        return false
    }

    @Throws(IOException::class)
    override fun connect() {
        conn.connect()
        conn.setRequestProperty("JSESSIONID", "X")
    }
}