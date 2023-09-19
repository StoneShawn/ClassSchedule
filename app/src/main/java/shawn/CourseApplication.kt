package shawn

import android.app.Application
import com.example.data.di.networkServiceModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CourseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

    }

    private fun startKoinApplication(){
        startKoin {
            androidContext(this@CourseApplication)
            modules(
                networkServiceModule
            )
        }
    }
}