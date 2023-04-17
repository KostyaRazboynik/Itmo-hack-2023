package ru.hackaton.profiler.picasso

import android.content.Context
import com.squareup.picasso.Picasso

class PicassoClient {
    fun initiate(context: Context) {
        val builder = Picasso.Builder(context)
        builder.downloader(ProfilerPicassoExecutorService("Picasso"))
        Picasso.setSingletonInstance(builder.build())
    }
}