package apk.testing.moviebox.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import apk.testing.moviebox.databinding.ItemPlaylistBinding
import apk.testing.moviebox.extension.loadUrl
import apk.testing.moviebox.model.Result
import apk.testing.moviebox.network.image_url

class PlayListAdapter: RecyclerView.Adapter<PlayListAdapter.ViewHolder>() {
   private var playList: List<Result> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setPlayList(playList: List<Result>){
        this.playList = playList
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.mvTitle.text = playList[position].title
        holder.binding.vote.text = playList[position].vote_average.toString()
        holder.binding.releaseDate.text = playList[position].release_date
        holder.binding.poster.loadUrl(image_url+playList[position].poster_path)
    }

    override fun getItemCount(): Int = playList.size

    class ViewHolder(val binding: ItemPlaylistBinding):RecyclerView.ViewHolder(binding.root)
}