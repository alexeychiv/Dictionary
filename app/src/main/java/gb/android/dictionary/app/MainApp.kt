package gb.android.dictionary.app

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import gb.android.dictionary.di.DaggerMainAppComponent
import javax.inject.Inject

class MainApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
        DaggerMainAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

    }
}
