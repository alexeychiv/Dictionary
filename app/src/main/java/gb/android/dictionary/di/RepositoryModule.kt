package gb.android.dictionary.di

import dagger.Module
import dagger.Provides
import gb.android.dictionary.model.data.DataModel
import gb.android.dictionary.model.datasource.DataSource
import gb.android.dictionary.model.datasource.RetrofitImpl
import gb.android.dictionary.model.datasource.RoomDataBaseImpl
import gb.android.dictionary.model.repository.Repository
import gb.android.dictionary.model.repository.RepositoryImpl
import javax.inject.Named
import javax.inject.Singleton


@Module
class RepositoryModule {

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideRepositoryRemote(@Named(NAME_REMOTE) dataSourceRemote: DataSource<List<DataModel>>): Repository<List<DataModel>> =
        RepositoryImpl(dataSourceRemote)

    @Provides
    @Singleton
    @Named(NAME_LOCAL)
    internal fun provideRepositoryLocal(@Named(NAME_LOCAL) dataSourceLocal: DataSource<List<DataModel>>): Repository<List<DataModel>> =
        RepositoryImpl(dataSourceLocal)

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideDataSourceRemote(): DataSource<List<DataModel>> =
        RetrofitImpl()

    @Provides
    @Singleton
    @Named(NAME_LOCAL)
    internal fun provideDataSourceLocal(): DataSource<List<DataModel>> = RoomDataBaseImpl()

}
