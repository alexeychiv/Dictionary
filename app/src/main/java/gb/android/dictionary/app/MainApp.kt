package gb.android.dictionary.app

import android.app.Application
import gb.android.dictionary.di.application
import gb.android.dictionary.di.mainScreen
import org.koin.core.context.startKoin


class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(application, mainScreen))
        }
    }

}
