package com.shawn.network.retrofit

import com.shawn.network.model.NetworkCourse

interface NetworkDataSource {
    suspend fun getCourse(): List<NetworkCourse>
}