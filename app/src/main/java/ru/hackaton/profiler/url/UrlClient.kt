package ru.hackaton.profiler.url

import java.net.URL

class UrlClient {
    fun initiate() {
//        URL.handlers
        URL.setURLStreamHandlerFactory(ProfilerURLStreamFactory())
    }
}