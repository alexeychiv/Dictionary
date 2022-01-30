package gb.android.dictionary.di

import gb.android.dictionary.model.data.DataModel
import gb.android.dictionary.model.datasource.RetrofitImpl
import gb.android.dictionary.model.datasource.RoomDataBaseImpl
import gb.android.dictionary.model.repository.Repository
import gb.android.dictionary.model.repository.RepositoryImpl
import gb.android.dictionary.view.main.MainInteractor
import gb.android.dictionary.view.main.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module


val application = module {
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) {
        RepositoryImpl(RetrofitImpl())
    }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) {
        RepositoryImpl(RoomDataBaseImpl())
    }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}