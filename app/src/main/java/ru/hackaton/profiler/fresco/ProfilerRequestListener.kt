package ru.hackaton.profiler.fresco

import com.facebook.imagepipeline.listener.BaseRequestListener
import com.facebook.imagepipeline.listener.RequestListener
import com.facebook.imagepipeline.request.ImageRequest
import ru.hackaton.profiler.base.Library
import ru.hackaton.profiler.base.MeasurementService
import ru.hackaton.profiler.base.RequestType

class ProfilerRequestListener(
    private val name: String
) : RequestListener {
    override fun onProducerStart(requestId: String?, producerName: String?) {
    }

    override fun onProducerEvent(requestId: String?, producerName: String?, eventName: String?) {
    }

    override fun onProducerFinishWithSuccess(
        requestId: String?,
        producerName: String?,
        extraMap: MutableMap<String, String>?
    ) {
    }

    override fun onProducerFinishWithFailure(
        requestId: String?,
        producerName: String?,
        t: Throwable?,
        extraMap: MutableMap<String, String>?
    ) {
    }

    override fun onProducerFinishWithCancellation(
        requestId: String?,
        producerName: String?,
        extraMap: MutableMap<String, String>?
    ) {

    }

    override fun onUltimateProducerReached(
        requestId: String?,
        producerName: String?,
        successful: Boolean
    ) {
    }

    override fun requiresExtraMap(requestId: String?): Boolean {
        return true
    }

    override fun onRequestStart(
        request: ImageRequest,
        callerContext: Any?,
        requestId: String,
        isPrefetch: Boolean
    ) {
        println("START")
        MeasurementService.startMeasurement(requestId, name, Library.Fresco, RequestType.Image)
    }

    override fun onRequestFailure(
        request: ImageRequest,
        requestId: String,
        throwable: Throwable,
        isPrefetch: Boolean
    ) {
        val measurement = MeasurementService.endMeasurement(requestId)
        measurement?.status?.exception = Exception()
        measurement?.url = request.sourceUri.toString()
        measurement?.size =
            ((request.bytesRange?.from?.let { request.bytesRange?.to?.minus(it) }))?.toLong()
    }

    override fun onRequestCancellation(requestId: String?) {
    }

    override fun onRequestSuccess(request: ImageRequest, requestId: String, isPrefetch: Boolean) {
        val measurement = MeasurementService.endMeasurement(requestId, false)
        measurement?.url = request.sourceUri.toString()
        measurement?.size =
            ((request.bytesRange?.from?.let { request.bytesRange?.to?.minus(it) }))?.toLong()
        MeasurementService.checkMeasurement(measurement)
    }
}