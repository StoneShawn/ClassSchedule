package com.shawn.network.retrofit

import com.shawn.network.base.NetworkResponse
import com.shawn.network.model.NetworkCourse
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitNetworkApi {
    @Headers("json:true")
    @GET("/hahow/course")
    suspend fun getCourse(): NetworkResponse<List<NetworkCourse>>
}