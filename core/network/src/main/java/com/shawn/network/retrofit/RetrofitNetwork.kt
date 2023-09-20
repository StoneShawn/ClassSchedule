package com.shawn.network.retrofit

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.shawn.network.model.NetworkCourse
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.ConnectionSpec
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class RetrofitNetwork(networkJson: Json, context: Context) : NetworkDataSource {

    private val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })
        .addInterceptor(JsonRequestInterceptor(context))
        .connectionSpecs(
            listOf(ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT)
        )
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://google")
        .client(client)
        .addConverterFactory(
            @OptIn(ExperimentalSerializationApi::class)
            networkJson.asConverterFactory("application/json".toMediaType())
        )
        .build()
        .create(RetrofitNetworkApi::class.java)

    override suspend fun getCourse(): List<NetworkCourse> {
        return retrofit.getCourse()
    }
}