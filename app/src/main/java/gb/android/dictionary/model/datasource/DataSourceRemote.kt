package gb.android.dictionary.model.datasource

import gb.android.dictionary.model.data.DataModel
import io.reactivex.rxjava3.core.Observable

class DataSourceRemote(
    private val remoteProvider: RetrofitImpl = RetrofitImpl()
) : DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> = remoteProvider.getData(word)

}