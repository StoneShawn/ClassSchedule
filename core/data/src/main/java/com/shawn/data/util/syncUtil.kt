package com.shawn.data.util

interface Syncable{
    suspend fun syncWith(): Boolean
}