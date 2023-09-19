package com.example.data.external.data

import com.example.data.model.Course

interface NetworkDataSource {
    suspend fun getCourse(): List<Course>
}