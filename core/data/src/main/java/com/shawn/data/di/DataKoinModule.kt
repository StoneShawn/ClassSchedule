package com.shawn.data.di

import com.shawn.data.repository.CourseRepository
import com.shawn.data.repository.OfflineFirstCourseRepository
import com.shawn.database.di.appDatabaseKoinModule
import com.shawn.network.di.networkKoinModule
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataKoinModule = module {
    single { Dispatchers.IO }
    includes(appDatabaseKoinModule, networkKoinModule)

    singleOf(::OfflineFirstCourseRepository) {bind<CourseRepository>()}
}