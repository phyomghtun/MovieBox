package apk.testing.moviebox.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import apk.testing.moviebox.model.PlayList
import apk.testing.moviebox.model.movie_details.Details
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

    fun getMovieDetails(movieDetails: MutableLiveData<Details>,movie_id: Int){
        val call: Call<Details> = retrofitInterface.getDetails(movie_id)
        call.enqueue(object : Callback<Details>{
            override fun onResponse(call: Call<Details>, response: Response<Details>) {
                if(response.isSuccessful){
                    movieDetails.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<Details>, t: Throwable) {
                movieDetails.postValue(null)
            }

        })
    }
}