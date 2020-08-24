package coder.mtk.newsapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coder.mtk.newsapi.R
import coder.mtk.newsapi.model.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_top_head_line.view.*
import kotlinx.android.synthetic.main.item_layout.view.*
import okhttp3.HttpUrl.get

class NewsAdapter (var articleList : List<Article> = ArrayList()) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){

    var clickListener : ClickListener? = null

    fun setOnClickListener (clickListener: ClickListener){
        this.clickListener = clickListener
    }

    fun updateArrayList (articleList : List<Article>){
        this.articleList = articleList
    }

    inner class NewsViewHolder (itemView : View) : RecyclerView.ViewHolder (itemView), View.OnClickListener{

        init {
            itemView.setOnClickListener(this)
        }

        lateinit var article: Article

        fun bind(article : Article){
            this.article = article
            itemView.newsTitle.text = article.title
            Picasso.get()
                .load(article.urlToImage)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.newsPhoto)
        }

        override fun onClick(p0: View?) {
            clickListener?.click(article)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(articleList[position])
    }

    interface ClickListener {
        fun click  (article: Article)
    }
}