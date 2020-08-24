package coder.mtk_and_nh.moviesdb.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coder.mtk_and_nh.moviesdb.R
import coder.mtk_and_nh.moviesdb.model.searchmovie.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_searchmovie.view.*

class SearchMoviesAdapter (var resultList : List<Result> = ArrayList<Result>()) : RecyclerView.Adapter<SearchMoviesAdapter.SearchMovieViewHolder>(){

    fun updateResult(resultList : List<Result>){
        this.resultList =resultList
    }

    class SearchMovieViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        fun bind(result : Result){
            Log.d("searchresultName>",result.title)
            itemView.searchResultName.text = result.title
            itemView.searchResultDate.text = result.release_date
            itemView.searchResultRating.text = result.vote_average.toString()
            Picasso.get()
                .load("https://image.tmdb.org/t/p/w500/"+result.poster_path)
                .placeholder(R.drawable.ic_baseline_image_24)
                .fit()
                .into(itemView.searchResultImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchMovieViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_searchmovie,parent,false)
        return SearchMovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("searchSize>>",resultList.size.toString())
        return resultList.size

    }

    override fun onBindViewHolder(holder: SearchMovieViewHolder, position: Int) {
        holder.bind(resultList[position])
    }
}