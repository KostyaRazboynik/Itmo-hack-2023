package ru.hackaton.profiler.base

import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import ru.ok.android.itmohack2023.Threads
import java.io.IOException

object MeasurementApi {
    fun sendToServer(measurement: Measurement) {
        val client = OkHttpClient()
        println("send")
        var st = ""
        if (measurement.stackTrace != null) {
            for (i in measurement.stackTrace!!) {
                st += i.toString() + "\n"
            }
        }

        val formBody =
            FormBody.Builder()
                .add("id", measurement.id)
                .add("start_time", measurement.status.startTimestamp.toString())
                .add(
                    "duration",
                    (measurement.status.endTimestamp?.minus(measurement.status.startTimestamp)).toString()
                )
                .add("name", measurement.name.toString())
                .add("library", measurement.library.toString())
                .add("type", measurement.type.toString())
                .add("url", measurement.url.toString())
                .add(
                    "data_size",
                    (measurement.status.endSizeStamp?.minus(measurement.status.startSizeStamp)).toString()
                )
                .add("exception", measurement.status.exception.toString())
                .add("stack_trace", st)
                .build()


        val request = Request.Builder()
            .url("http://164.92.210.100:5000/addData")
            .post(formBody)
            .build()

        Threads.ioPool.execute {
            try {
                println("request    ${measurement.library}")
                val response = client.newCall(request).execute()
                println("got response       $response")
            } catch (e: IOException) {
                println("Exception " + e.message)
                e.printStackTrace()
            }
        }
    }

    fun sendToServer(measurement: List<Measurement>) {
        measurement.forEach { sendToServer(it) }
    }
}