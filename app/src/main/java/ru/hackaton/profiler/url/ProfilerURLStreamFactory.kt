package ru.hackaton.profiler.url

import java.net.URLStreamHandler
import java.net.URLStreamHandlerFactory

class ProfilerURLStreamFactory: URLStreamHandlerFactory {
    override fun createURLStreamHandler(protocol: String?): URLStreamHandler? {
        println(protocol)
        return null
        return ProfilerStreamHandler()
    }

}