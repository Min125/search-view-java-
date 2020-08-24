package coder.mtk_and_nh.moviesdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coder.mtk_and_nh.moviesdb.R
import coder.mtk_and_nh.moviesdb.model.tvshowpopular.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_popularmovie.view.*
import kotlinx.android.synthetic.main.item_searchmovie.view.*

class PopularTvShowAdapter (var resultList: List<Result> = ArrayList<Result>()) : RecyclerView.Adapter<PopularTvShowAdapter.PopularTvShowViewHolder>() {

    fun updateResult(resultList: List<Result>){
        this.resultList =resultList
    }

    class PopularTvShowViewHolder (itemView : View ) : RecyclerView.ViewHolder (itemView){
        fun bind(result  : Result){
            itemView.searchResultName.text = result.name
            itemView.searchResultDate.text = result.first_air_date
            itemView.searchResultRating.text = result.vote_average.toString()
            Picasso.get()
                .load("https://image.tmdb.org/t/p/w500/"+result.poster_path)
                .placeholder(R.drawable.ic_baseline_image_24)
                .fit()
                .into(itemView.searchResultImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularTvShowViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_searchmovie,parent,false)
        return PopularTvShowViewHolder(view)
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    override fun onBindViewHolder(holder: PopularTvShowViewHolder, position: Int) {
        holder.bind(resultList[position])
    }

}