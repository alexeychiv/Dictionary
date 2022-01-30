package gb.android.dictionary.view.main

import gb.android.dictionary.model.data.AppState
import gb.android.dictionary.model.data.DataModel
import gb.android.dictionary.model.repository.Repository
import gb.android.dictionary.viewmodel.Interactor


class MainInteractor(
    private val remoteRepository: Repository<List<DataModel>>,
    private val localRepository: Repository<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                remoteRepository
            } else {
                localRepository
            }.getData(word)
        )
    }

}