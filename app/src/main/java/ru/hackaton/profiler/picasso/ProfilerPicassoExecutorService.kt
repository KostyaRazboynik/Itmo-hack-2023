package ru.hackaton.profiler.picasso

import com.squareup.picasso.Downloader
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import ru.hackaton.profiler.base.Library
import ru.hackaton.profiler.okhttp3.ProfilerInterceptor
import java.io.IOException

class ProfilerPicassoExecutorService(name: String) : Downloader {
    private val client = OkHttpClient.Builder()
        .addInterceptor(ProfilerInterceptor(name, Library.Picasso))
        .build()

    override fun load(request: Request): Response {
        return client
            .newCall(request)
            .execute()
    }

    override fun shutdown() {
        try {
            client.cache?.close()
        } catch (ignored: IOException) {
        }
    }
}