package gb.android.dictionary.view.base

import gb.android.dictionary.model.data.AppState

interface View {

    fun renderData(appState: AppState)

}