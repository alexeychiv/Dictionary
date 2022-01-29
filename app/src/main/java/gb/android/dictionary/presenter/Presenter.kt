package gb.android.dictionary.presenter

import gb.android.dictionary.model.data.AppState
import gb.android.dictionary.view.base.View


interface Presenter<T : AppState, V : View> {

    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)

}