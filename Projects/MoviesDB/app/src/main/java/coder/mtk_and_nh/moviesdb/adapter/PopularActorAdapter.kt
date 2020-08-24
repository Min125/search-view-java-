package coder.mtk_and_nh.moviesdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coder.mtk_and_nh.moviesdb.R
import coder.mtk_and_nh.moviesdb.model.popularactor.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.item_actor.view.*

class PopularActorAdapter (var resultList: List<Result> = ArrayList <Result>()) : RecyclerView.Adapter <PopularActorAdapter.PopularAcotorViewModel>(){

    fun updateResultList (resultList: List<Result>){
        this.resultList = resultList
    }

    class PopularAcotorViewModel(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(result: Result){
            itemView.txtActorName.text = result.name
            Picasso.get()
                .load("https://image.tmdb.org/t/p/w500/"+result.profile_path)
                .placeholder(R.drawable.ic_baseline_image_24)
                .into(itemView.imgActor)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularAcotorViewModel {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_actor,parent,false)
        return PopularAcotorViewModel(view)
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    override fun onBindViewHolder(holder: PopularAcotorViewModel, position: Int) {
        holder.bind(resultList[position])
    }
}