package gb.android.dictionary.di

import dagger.Module
import dagger.Provides
import gb.android.dictionary.model.data.DataModel
import gb.android.dictionary.model.repository.Repository
import gb.android.dictionary.view.main.MainInteractor
import javax.inject.Named


@Module
class InteractorModule {

    @Provides
    internal fun provideInteractor(
        @Named(NAME_REMOTE) repositoryRemote: Repository<List<DataModel>>,
        @Named(NAME_LOCAL) repositoryLocal: Repository<List<DataModel>>
    ) = MainInteractor(repositoryRemote, repositoryLocal)

}
