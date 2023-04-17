package ru.hackaton.profiler.glide

import android.annotation.SuppressLint
import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder


class GlideClient {
    @SuppressLint("VisibleForTests")
    fun initiate(context: Context) {
        Glide.init(context, GlideBuilder().addGlobalRequestListener(ProfilerGladRequestListener<Any>("Glide")))
    }
}