package gb.android.dictionary.view.main

import gb.android.dictionary.model.data.AppState
import gb.android.dictionary.model.data.DataModel
import gb.android.dictionary.model.repository.Repository
import gb.android.dictionary.viewmodel.Interactor
import io.reactivex.rxjava3.core.Observable

class MainInteractor(
    private val remoteRepository: Repository<List<DataModel>>,
    private val localRepository: Repository<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { AppState.Success(it) }
        } else {
            localRepository.getData(word).map { AppState.Success(it) }
        }
    }

}