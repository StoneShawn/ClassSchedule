package com.shawn.network.di

import com.shawn.network.retrofit.NetworkDataSource
import com.shawn.network.retrofit.RetrofitNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkKoinModule = module {
    single { Dispatchers.IO }
    singleOf(::RetrofitNetwork) { bind<NetworkDataSource>() }
    single { Json { ignoreUnknownKeys = true } }
}