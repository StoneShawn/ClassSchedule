package com.shawn.database.di

import androidx.room.Room
import com.shawn.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appDatabaseKoinModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "database"
        ).build()
    }

    single { get<AppDatabase>().courseDao() }
}