package ru.ok.android.itmohack2023

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.aspectj.lang.annotation.Aspect
import org.json.JSONArray
import org.json.JSONObject
import ru.hackaton.profiler.annotation.Measure

class JNIActivity : AppCompatActivity() {

    @Measure
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jniactivity)
        Threads.ioPool.execute {
            var result = nativeFunction() ?: return@execute
            result = result.dropWhile { it != '{' }

            val textJson = JSONObject(result)
            val act =
                textJson.getString("activity")
            runOnUiThread {
                findViewById<TextView>(R.id.result).text = act
            }
        }
    }

    external fun nativeFunction(): String?

    companion object {
        init {
            System.loadLibrary("jnisocket");
        }
    }
}