package gb.android.dictionary.model.repository

import gb.android.dictionary.model.data.DataModel
import gb.android.dictionary.model.datasource.DataSource


class RepositoryImpl(
    private val dataSource: DataSource<List<DataModel>>
) : Repository<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }

}