package coder.mtk.newappjava.fragments.adapter;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import coder.mtk.newappjava.R;
import coder.mtk.newappjava.model.ArticlesItem;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ArticleViewHolder> {
    private List<ArticlesItem> articlesItemList = new ArrayList<>();
    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_aritcle,parent,false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.title.setText(articlesItemList.get(position).getTitle());
        Picasso.get()
                .load(articlesItemList.get(position).getUrlToImage())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return articlesItemList.size();
    }

    public void updateArticle (List<ArticlesItem> articlesItemsList){
        this.articlesItemList =articlesItemsList;
        notifyDataSetChanged();
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView imageView;
        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.articleTitle);
            imageView = itemView.findViewById(R.id.articleImage);
        }
    }
}
