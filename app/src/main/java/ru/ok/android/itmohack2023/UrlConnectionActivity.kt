package ru.ok.android.itmohack2023

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Space
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray
import ru.hackaton.profiler.base.Library
import ru.hackaton.profiler.base.MeasurementService
import java.net.URL

class UrlConnectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cat_facts_layout)
        val list = findViewById<ViewGroup>(R.id.list)

        Threads.ioPool.execute {
                val measurement = MeasurementService.startMeasurement(this::class.simpleName!!, Library.Unknown)
                val url = "https://cat-fact.herokuapp.com/facts";
                val connection = URL(url).openConnection()
                val text = connection.getInputStream().bufferedReader().readText()
                val textJson = JSONArray(text)
                for (i in 0 until textJson.length()) {
                    val factJson = textJson.getJSONObject(i)
                    val factText = factJson.getString("text")

                    runOnUiThread {
                        val textView = TextView(this)
                        textView.text = factText
                        list.addView(textView)
                        val space = Space(this)
                        space.minimumHeight =
                            resources.getDimensionPixelOffset(R.dimen.padding_normal)
                        list.addView(space)
                    }
                measurement.url = url
                MeasurementService.endMeasurement(measurement.id)
            }
        }
    }
}