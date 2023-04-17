package ru.ok.android.itmohack2023

import android.app.Application
import ru.hackaton.profiler.fresco.FrescoClient
import ru.hackaton.profiler.glide.GlideClient
import ru.hackaton.profiler.picasso.PicassoClient
import ru.hackaton.profiler.url.UrlClient

class ItmohackApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        FrescoClient().initiate(this)
        PicassoClient().initiate(this)
        GlideClient().initiate(this)
        UrlClient().initiate()
    }
}