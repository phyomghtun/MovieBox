package apk.testing.moviebox.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import apk.testing.moviebox.model.PlayList
import apk.testing.moviebox.model.movie_details.Details
import apk.testing.moviebox.network.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel(){
    private var movie_details = MutableLiveData<Details>()

    init {
        movie_details = MutableLiveData()
    }

    fun loadMovieDetails(movie_id: Int){
        movieRepository.getMovieDetails(movie_details,movie_id)
    }

    fun getMovieDetails() : MutableLiveData<Details>{
        return movie_details
    }

}