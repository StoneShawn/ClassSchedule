package com.example.data.external.di

import com.example.data.external.data.NetworkDataSource
import com.example.data.internal.network.CourseApiImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkServiceModule = module {
    singleOf(::CourseApiImpl) {  bind<NetworkDataSource>()}
}