package apk.testing.moviebox.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import apk.testing.moviebox.R
import apk.testing.moviebox.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        initViewModel()

    }
    fun initViewModel(){
        viewModel.loadPlayList()
        viewModel.getPLayList().observe(this) {
            if (it != null) {
                Log.d("response_msg",it.toString())
            }else{
                Log.d("response_msg","null")
            }
        }
    }
}