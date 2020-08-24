package coder.mtk.jsonretrofitsample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coder.mtk.jsonretrofitsample.R
import coder.mtk.jsonretrofitsample.model.Post
import coder.mtk.jsonretrofitsample.model.PostItem
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter (var postList : ArrayList <PostItem>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
    class PostViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {
        fun bind(post : PostItem){
            itemView.txtPost.text = post.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent,false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postList[position])
    }

}