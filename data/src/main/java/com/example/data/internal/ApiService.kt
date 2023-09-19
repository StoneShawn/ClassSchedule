package com.example.data.internal

import com.example.data.model.Course
import retrofit2.http.GET

interface ApiService {
    @GET(value = "course")
    suspend fun getCourse() : List<Course>
}