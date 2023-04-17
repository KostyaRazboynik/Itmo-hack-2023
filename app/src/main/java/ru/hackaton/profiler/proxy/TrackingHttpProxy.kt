package ru.hackaton.profiler.proxy
/*
import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler
import com.sun.net.httpserver.HttpServer
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import okhttp3.internal.http.HttpMethod
import ru.hackaton.profiler.Config
import java.io.IOException
import java.net.InetSocketAddress

class TrackingHttpProxy {
    val proxy: HttpServer = HttpServer.create(InetSocketAddress(8000), 0)

    init {
        proxy.createContext("/", TrackingHandler())
        proxy.executor = null
    }

    fun getUrl():String {
        return "http://127.0.0.1:8000"
    }

    private class TrackingHandler : HttpHandler {
        override fun handle(exchange: HttpExchange) {
            val url = exchange.requestURI
            println("pepe")
            val request = Request.Builder()
                .url(url.toURL())

            for (header in exchange.requestHeaders) {
                request.addHeader(header.key, header.value.joinToString(", "))
            }

            val body = exchange.requestBody.bufferedReader().readText();

            request.method(exchange.requestMethod,
                if (HttpMethod.requiresRequestBody(exchange.requestMethod)) body.toRequestBody() else null)

            val os = exchange.responseBody;

            var id : Long? = null
            if (!url.equals(Config().tracking_url)) {
                id = TimeLog.start("<generic http request>", url.toString())
            }
            val response : Response
            try {
                response = OkHttpClient().newCall(request.build()).execute()
            } catch (e: IOException) {
                e.printStackTrace()
                if (id != null) {
                    end(id, error = true)
                }
                exchange.sendResponseHeaders(500, -1);
                exchange.close()
                return
            }

            if (id != null) {
                end(id)
            }

            if (response.body != null) {
                exchange.sendResponseHeaders(response.code, response.body!!.contentLength())
            } else {
                exchange.sendResponseHeaders(response.code, 0)
            }

            for (header in response.headers) {
                exchange.responseHeaders.add(header.first, header.second)
            }

            response.body!!.byteStream().copyTo(os)

            exchange.close()

        }
    }
}

fun main() {
    val proxy = TrackingHttpProxy()
    proxy.proxy.start()
}
 */