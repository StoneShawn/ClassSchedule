package com.example.data.network

import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


fun networkProvider(): Retrofit {
    val client = OkHttpClient.Builder()
        .connectionSpecs(
            listOf(ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT)
        )
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .build()

    return Retrofit.Builder()
        .baseUrl("baseUrl")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

