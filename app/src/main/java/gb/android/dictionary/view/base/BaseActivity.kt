package gb.android.dictionary.view.base

import androidx.appcompat.app.AppCompatActivity
import gb.android.dictionary.model.data.AppState
import gb.android.dictionary.viewmodel.BaseViewModel


abstract class BaseActivity<T : AppState> : AppCompatActivity() {

    abstract val viewModel: BaseViewModel<T>

    abstract fun renderData(appState: T)

}