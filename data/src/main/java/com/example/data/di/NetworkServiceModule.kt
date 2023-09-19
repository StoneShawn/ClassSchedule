package com.example.data.di

import com.example.data.network.networkProvider
import org.koin.dsl.module

val networkServiceModule = module {
    single { networkProvider() }
}