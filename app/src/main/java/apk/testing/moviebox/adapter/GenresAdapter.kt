package apk.testing.moviebox.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import apk.testing.moviebox.databinding.ItemGenresBinding
import apk.testing.moviebox.model.movie_details.Genre

class GenresAdapter : RecyclerView.Adapter<GenresAdapter.ViewHolder>() {
    private var genresList: List<Genre> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setGenreList(genresList: List<Genre>){
        this.genresList = genresList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemGenresBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvGenres.text = genresList[position].name
    }

    override fun getItemCount(): Int = genresList.size

    class ViewHolder(val binding: ItemGenresBinding): RecyclerView.ViewHolder(binding.root)
}