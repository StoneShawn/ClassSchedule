package com.shawn.network.retrofit

import com.shawn.network.model.NetworkCourse
import retrofit2.http.GET

interface RetrofitNetworkApi {
    @GET
    suspend fun getCourse(): List<NetworkCourse>
}