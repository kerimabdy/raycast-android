package my.way.raycast

import android.app.Application
import my.way.raycast.di.startKoinWithModules

class RaycastApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoinWithModules(this@RaycastApp)
    }
}