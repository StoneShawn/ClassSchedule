package com.shawn.database.di

import androidx.room.Room
import com.shawn.database.Database
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseKoinModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            Database::class.java,
            "database"
        ).build()
    }

    single { get<Database>().courseDao() }
}