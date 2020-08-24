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
import kotlinx.android.synthetic.main.item_searchmovie.view.*

class MoviesAdapter (var nowPlayingList: List<Result> = ArrayList<Result>()) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>(){

    var clickListener : ClickListener? = null

    fun setOnClickListener (clickListener : ClickListener){
        this.clickListener = clickListener
    }

    fun updateNowPlayingList(nowPlayingList: List<Result>){
        this.nowPlayingList= nowPlayingList
    }

    inner class MoviesViewHolder (itemView : View) : RecyclerView.ViewHolder (itemView) , View.OnClickListener{

        init {
            itemView.setOnClickListener(this)
        }

        lateinit var result: Result
        fun bind(result: Result){
            this.result = result
            itemView.searchResultName.text = result.title
            itemView.searchResultDate.text = result.release_date
            itemView.searchResultRating.text = result.vote_average.toString()
            Picasso.get()
                .load("https://image.tmdb.org/t/p/w500/"+result.poster_path)
                .placeholder(R.drawable.ic_baseline_image_24)
                .fit()
                .into(itemView.searchResultImg)
        }

        override fun onClick(p0: View?) {
            clickListener?.onClick(result)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_searchmovie,parent,false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return nowPlayingList.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(nowPlayingList[position])
    }
    interface ClickListener{
        fun onClick(result: Result)
    }
}