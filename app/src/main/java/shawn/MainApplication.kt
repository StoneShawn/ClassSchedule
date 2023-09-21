package shawn

import android.app.Application
import com.shawn.di.syncWorkerKoinModule
import com.shawn.util.Sync
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin
import shawn.di.mainAppModule

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoinApplication()

    }

    private fun startKoinApplication() {
        startKoin {
            androidContext(this@MainApplication)
            workManagerFactory()
            modules(
                mainAppModule,
            )
        }

        syncData()
    }

    private fun syncData() {
        Sync.initialize(context = this)
    }
}