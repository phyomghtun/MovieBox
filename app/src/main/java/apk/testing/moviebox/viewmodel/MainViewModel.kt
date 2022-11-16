package apk.testing.moviebox.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import apk.testing.moviebox.model.PlayList
import apk.testing.moviebox.network.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel(){

    private var _now_play_list = MutableLiveData<PlayList>()
  //  val now_play_list: LiveData<PlayList> = _now_play_list

    init{
       _now_play_list = MutableLiveData()
    }

    fun loadPlayList() {
           movieRepository.nowPlayListApi(_now_play_list)
          // Log.d("response_msg",movieRepository.nowPlayListApi(_now_play_list).toString())
    }

    fun getPLayList(): MutableLiveData<PlayList> {
       // Log.d("response_msg", _now_play_list.toString())
        return _now_play_list

    }



}