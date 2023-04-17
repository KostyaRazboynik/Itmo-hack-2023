package ru.hackaton.profiler.fresco

import android.content.Context
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig
import com.facebook.imagepipeline.listener.RequestListener


class FrescoClient {
    fun initiate(context: Context) {
        val listeners: MutableSet<RequestListener> = HashSet()
        listeners.add(ProfilerRequestListener("Fresco"))
        val config = ImagePipelineConfig.newBuilder(context)
            .setRequestListeners(listeners)
            .build()
        Fresco.initialize(context, config)
    }
}