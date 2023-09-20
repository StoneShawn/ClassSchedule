package com.example.data.internal.network

import com.example.data.external.data.NetworkDataSource
import com.example.data.internal.ApiService
import com.example.data.model.Course

class CourseApiImpl: NetworkDataSource {

    private val apiService by lazy {
        retrofitNetwork().create(ApiService::class.java)
    }
    override suspend fun getCourse(): List<Course> {
        return apiService.getCourse()
    }
}