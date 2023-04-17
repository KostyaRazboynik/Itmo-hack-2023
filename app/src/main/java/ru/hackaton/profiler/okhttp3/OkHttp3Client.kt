package ru.hackaton.profiler.okhttp3

import okhttp3.OkHttpClient
import ru.hackaton.profiler.base.Library


class OkHttp3Client {
    fun getClient(name: String): OkHttpClient.Builder {
        return OkHttpClient
            .Builder()
            .addInterceptor(ProfilerInterceptor(name, Library.OkHttp3))
    }
}