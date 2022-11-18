package apk.testing.moviebox.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import apk.testing.moviebox.databinding.ItemPlaylistBinding
import apk.testing.moviebox.extension.loadUrl
import apk.testing.moviebox.model.Result
import apk.testing.moviebox.network.image_url
import apk.testing.moviebox.ui.DetailsActivity
import dagger.hilt.android.qualifiers.ApplicationContext

class PlayListAdapter(var mContext: Context): RecyclerView.Adapter<PlayListAdapter.ViewHolder>() {
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
        holder.binding.itCk.setOnClickListener {
                Intent(mContext,DetailsActivity::class.java).also {
                it.putExtra("movie_id",playList[position].id.toString())
                mContext.startActivity(it)
        }
        }
    }

    override fun getItemCount(): Int = playList.size

    class ViewHolder(val binding: ItemPlaylistBinding):RecyclerView.ViewHolder(binding.root)
}