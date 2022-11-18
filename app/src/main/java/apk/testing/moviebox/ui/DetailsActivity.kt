package apk.testing.moviebox.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import apk.testing.moviebox.R
import apk.testing.moviebox.adapter.GenresAdapter
import apk.testing.moviebox.adapter.PlayListAdapter
import apk.testing.moviebox.databinding.ActivityDetailsBinding
import apk.testing.moviebox.extension.loadUrl
import apk.testing.moviebox.network.image_url
import apk.testing.moviebox.viewmodel.DetailsViewModel
import apk.testing.moviebox.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    private lateinit var activityDetailsBinding: ActivityDetailsBinding
    private lateinit var viewModel: DetailsViewModel
    private var movieid : Int = 0
    private lateinit var genresAdapter: GenresAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailsBinding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(activityDetailsBinding.root)

        movieid = intent.getStringExtra("movie_id")?.toInt()!!

        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView(){
        genresAdapter = GenresAdapter()
        activityDetailsBinding.rvGenres.apply {
            layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)
            adapter = genresAdapter
        }
    }

    fun initViewModel(){
        viewModel = ViewModelProvider(this)[DetailsViewModel::class.java]
        viewModel.loadMovieDetails(movieid)
        viewModel.getMovieDetails().observe(this) {
            if (it != null) {
                activityDetailsBinding.ivDetail.loadUrl(image_url+it.backdrop_path)
                activityDetailsBinding.tvDetailName.text = it.original_title
                activityDetailsBinding.tvDetailStarRate.text = "9.1/10 IMDb"
                activityDetailsBinding.tvLanguage.text = it.original_language
                activityDetailsBinding.tvLength.text = "2hr 5min"
                activityDetailsBinding.tvRating.text = it.vote_average.toString()
                activityDetailsBinding.tvDescription.text = it.overview
                genresAdapter.setGenreList(it.genres)

                activityDetailsBinding.detailProgressBar.visibility = View.INVISIBLE
                activityDetailsBinding.ivBack.setOnClickListener{
                    finish()
                }
                Log.d("response_msg",it.toString())
            }else{
                Log.d("response_msg","null")
            }
        }
    }
}