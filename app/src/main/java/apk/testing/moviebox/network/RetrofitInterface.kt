package apk.testing.moviebox.network

import apk.testing.moviebox.model.PlayList
import apk.testing.moviebox.model.movie_details.Details
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

val API_KEY = "c0983d23fd25d13ce2953fc4c6eb536e"

val base_url = "https://api.themoviedb.org/3/movie/"

val image_url = "https://image.tmdb.org/t/p/w500"

interface RetrofitInterface {
    @GET("now_playing")
    fun getPlayList(@Query("api_key") apiKey: String = API_KEY) : Call<PlayList>

    @GET("{movie_id}")
    fun getDetails(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") apiKey: String = API_KEY
    ) : Call<Details>
}