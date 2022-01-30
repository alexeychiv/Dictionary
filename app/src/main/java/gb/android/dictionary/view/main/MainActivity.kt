package gb.android.dictionary.view.main

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import gb.android.dictionary.databinding.ActivityMainBinding
import gb.android.dictionary.model.data.AppState
import gb.android.dictionary.model.data.DataModel
import gb.android.dictionary.utils.network.isOnline
import gb.android.dictionary.view.base.BaseActivity
import gb.android.dictionary.view.main.adapter.MainAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : BaseActivity<AppState, MainInteractor>() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    override lateinit var vModel: MainViewModel

    private val adapter: MainAdapter by lazy { MainAdapter(onListItemClickListener) }
    private val onListItemClickListener: MainAdapter.OnListItemClickListener =
        object : MainAdapter.OnListItemClickListener {
            override fun onItemClick(data: DataModel) {
                Toast.makeText(this@MainActivity, data.text, Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()

        binding.btnSearch.setOnClickListener {
            val word = binding.etWord.text.toString()

            if (word.isNotEmpty()) {
                isNetworkAvailable = isOnline(applicationContext)
                if (isNetworkAvailable) {
                    vModel.getData(word, isNetworkAvailable)
                } else {
                    showNoInternetConnectionDialog()
                }
            }
        }

        binding.rvResultList.layoutManager = LinearLayoutManager(applicationContext)
        binding.rvResultList.adapter = adapter
    }

    private fun initViewModel() {
        if (binding.rvResultList.adapter != null) {
            throw IllegalStateException("The ViewModel should be initialised first")
        }
        val viewModel: MainViewModel by viewModel()
        vModel = viewModel
        vModel.subscribe().observe(this@MainActivity, { renderData(it) })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                showViewWorking()
                val dataModel = appState.data
                if (dataModel.isNullOrEmpty()) {
                    showAlertDialog(
                        "Sorry!",
                        "No definitions found!"
                    )
                } else {
                    adapter.setData(dataModel)
                }
            }
            is AppState.Loading -> {
                showViewLoading()
                if (appState.progress != null) {
                    binding.horizontalProgressBar.visibility = VISIBLE
                    binding.circleProgressBar.visibility = GONE
                    binding.horizontalProgressBar.progress = appState.progress
                } else {
                    binding.horizontalProgressBar.visibility = GONE
                    binding.circleProgressBar.visibility = VISIBLE
                }
            }
            is AppState.Error -> {
                showViewWorking()
                showAlertDialog("Error!", appState.error.message)
            }
        }
    }

    private fun showViewWorking() {
        binding.loadingFrameLayout.visibility = GONE
    }

    private fun showViewLoading() {
        binding.loadingFrameLayout.visibility = VISIBLE
    }
}