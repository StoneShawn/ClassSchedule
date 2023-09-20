package com.shawn.network.retrofit

import android.content.Context
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class JsonRequestInterceptor(private val context: Context) : Interceptor {
    companion object {
        private const val JSON = "json"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val header = request.header(JSON)

        if (header != null) {
            val filename = request.url.pathSegments.last()
            return Response.Builder()
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .message("")
                .code(200)
                .body(context.readFileFromAssets
                    ("jsons/$filename.json").toResponseBody(("application/json").toMediaTypeOrNull())
                )
                .build()
        }

        return chain.proceed(request.newBuilder().removeHeader(JSON).build())
    }

    private fun Context.readFileFromAssets(filePath: String): String {
        return resources.assets.open(filePath).bufferedReader().use { it.readText() }
    }
}