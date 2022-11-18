package apk.testing.moviebox.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import apk.testing.moviebox.R
import apk.testing.moviebox.adapter.PlayListAdapter
import apk.testing.moviebox.databinding.ActivityMainBinding
import apk.testing.moviebox.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var playListAdapter: PlayListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        initRecyclerView()
        initViewModel()

    }

    private fun initRecyclerView(){
        playListAdapter = PlayListAdapter(this)
        activityMainBinding.rView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = playListAdapter
        }
    }

    private fun initViewModel(){
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.loadPlayList()
        viewModel.getPLayList().observe(this) {
            if (it != null) {
                playListAdapter.setPlayList(it.results)
               // Log.d("response_msg",it.toString())
            }else{
                Log.d("response_msg","null")
            }
        }
    }
}