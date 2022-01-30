package gb.android.dictionary.model.datasource

import gb.android.dictionary.model.data.DataModel


class RoomDataBaseImpl : DataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        TODO("not implemented")
    }

}