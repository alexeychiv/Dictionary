package gb.android.dictionary.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import gb.android.dictionary.view.main.MainActivity


@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

}

