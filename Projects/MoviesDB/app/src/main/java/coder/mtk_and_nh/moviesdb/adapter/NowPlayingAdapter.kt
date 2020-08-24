package coder.mtk_and_nh.moviesdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coder.mtk_and_nh.moviesdb.R
import coder.mtk_and_nh.moviesdb.model.nowPlaying.NowPlaying
import coder.mtk_and_nh.moviesdb.model.nowPlaying.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_nowplaying.view.*

class NowPlayingAdapter (var nowPlayingList: List<Result> = ArrayList<Result>()) : RecyclerView.Adapter<NowPlayingAdapter.NowPlayingViewHolder>(){

    fun updateNowPlayingList(nowPlayingList: List<Result>){
        this.nowPlayingList= nowPlayingList
    }

    class NowPlayingViewHolder (itemView : View) : RecyclerView.ViewHolder (itemView){
        fun bind(result: Result){
            itemView.txtNowPlayingTitle.text = result.original_title
            Picasso.get()
                .load("https://image.tmdb.org/t/p/w500/"+result.backdrop_path)
                .fit()
                .placeholder(R.drawable.ic_baseline_image_24)
                .into(itemView.imgNowPlaying)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_nowplaying,parent,false)
        return NowPlayingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return nowPlayingList.size
    }

    override fun onBindViewHolder(holder: NowPlayingViewHolder, position: Int) {
        holder.bind(nowPlayingList[position])
    }
}