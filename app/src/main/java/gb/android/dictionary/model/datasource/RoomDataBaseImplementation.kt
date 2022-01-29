package gb.android.dictionary.model.datasource

import gb.android.dictionary.model.data.DataModel
import io.reactivex.rxjava3.core.Observable


class RoomDataBaseImplementation : DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        TODO("not implemented")
    }

}