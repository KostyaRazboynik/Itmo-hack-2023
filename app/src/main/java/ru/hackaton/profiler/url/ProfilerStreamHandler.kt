package ru.hackaton.profiler.url

import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStream
import java.net.URL
import java.net.URLConnection
import java.net.URLStreamHandler

class ProfilerStreamHandler() : URLStreamHandler() {
    override fun openConnection(u: URL): URLConnection {
        return MyHttpURLConnection(u)
    }
}

