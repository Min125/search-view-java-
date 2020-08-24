package coder.mtk_and_nh.moviesdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import coder.mtk_and_nh.moviesdb.R
import coder.mtk_and_nh.moviesdb.model.popular.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_popularmovie.view.*

class PopularMoviesAdapter (var resultList : List<Result> = ArrayList<Result>()) : RecyclerView.Adapter<PopularMoviesAdapter.PopularMoviesViewHolder>(){

    fun updatePopularMovieAdapter (resultList : List<Result>){
        this.resultList = resultList
    }

    class PopularMoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(result: Result){
            itemView.txtPopularMovieName.text = result.title
            itemView.txtPopularMovieDate.text =result.release_date
            Picasso.get()
                .load("https://image.tmdb.org/t/p/w500/"+result.poster_path)
                .fit()
                .placeholder(R.drawable.ic_baseline_image_24)
                .into(itemView.imgPopularMovie)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_popularmovie,parent,false)
        return PopularMoviesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    override fun onBindViewHolder(holder: PopularMoviesViewHolder, position: Int) {
        holder.bind(resultList[position])
    }
}