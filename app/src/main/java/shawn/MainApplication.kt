package shawn

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import shawn.di.mainAppModule

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoinApplication()
    }

    private fun startKoinApplication(){
        startKoin {
            androidContext(this@MainApplication)
            modules(
               mainAppModule
            )
        }
    }
}