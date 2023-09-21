package com.shawn.network.di

import com.shawn.network.retrofit.NetworkDataSource
import com.shawn.network.retrofit.RetrofitNetwork
import com.shawn.network.util.ConnectivityManagerNetworkMonitor
import com.shawn.network.util.NetworkMonitor
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkKoinModule = module {
    single { Dispatchers.IO }
    singleOf(::RetrofitNetwork) { bind<NetworkDataSource>() }
    singleOf(::ConnectivityManagerNetworkMonitor) { bind<NetworkMonitor>() }
    single { Json { ignoreUnknownKeys = true } }
}