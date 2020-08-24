package coder.mtk_and_nh.moviesdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coder.mtk_and_nh.moviesdb.R
import coder.mtk_and_nh.moviesdb.model.upcomming.Result
import coder.mtk_and_nh.moviesdb.model.upcomming.UpComing
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_nowplaying.view.*

class UpComingAdapter (var resultList : List<Result> = ArrayList<Result>()) : RecyclerView.Adapter <UpComingAdapter.UpComingViewHolder> () {

    fun updateResult (resultList : List<Result>){
        this.resultList =resultList
    }

    class UpComingViewHolder (itemView : View) : RecyclerView.ViewHolder (itemView){
        fun bind(result: Result) {
            itemView.txtNowPlayingTitle.text = result.title
            Picasso.get()
                .load("https://image.tmdb.org/t/p/w500/"+result.backdrop_path)
                .fit()
                .placeholder(R.drawable.ic_baseline_image_24)
                .into(itemView.imgNowPlaying)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpComingViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_nowplaying,parent,false)
        return UpComingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    override fun onBindViewHolder(holder: UpComingViewHolder, position: Int) {
        holder.bind(resultList[position])
    }

}