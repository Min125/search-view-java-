package coder.mtk_and_nh.roomdatabase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
import coder.mtk_and_nh.roomdatabase.R
import coder.mtk_and_nh.roomdatabase.model.Book
import kotlinx.android.synthetic.main.item_book.view.*

class BookAdapter (var bookList : ArrayList<Book>) : RecyclerView.Adapter<BookAdapter.BookAdapterViewHolder>(){
    class BookAdapterViewHolder (itemView : View) : RecyclerView.ViewHolder (itemView){
        fun bind(book:Book){
            itemView.itemBook.text = book.bookName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookAdapterViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_book,parent,false)
        return BookAdapterViewHolder(view)
    }

    override fun getItemCount(): Int {
       return bookList.size
    }

    override fun onBindViewHolder(holder: BookAdapterViewHolder, position: Int) {
        holder.bind(bookList[position])
    }
}