package apk.testing.moviebox.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import apk.testing.moviebox.model.PlayList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MovieRepository @Inject constructor(private val retrofitInterface: RetrofitInterface){

    fun nowPlayListApi(moviePlayList: MutableLiveData<PlayList>){
        val call: Call<PlayList> = retrofitInterface.getPlayList()
        call.enqueue(object : Callback<PlayList>{
            override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {
                if(response.isSuccessful){
                    moviePlayList.postValue(response.body())
                    //Log.d("response_msg",response.body().toString())
                }
            }

            override fun onFailure(call: Call<PlayList>, t: Throwable) {
                moviePlayList.postValue(null)
            }

        })
    }
}