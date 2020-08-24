package coder.mtk_and_nh.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import coder.mtk_and_nh.roomdatabase.adapter.BookAdapter
import coder.mtk_and_nh.roomdatabase.database.BookDatabase
import coder.mtk_and_nh.roomdatabase.model.Book
import coder.mtk_and_nh.roomdatabase.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val db = Room.databaseBuilder(
//            applicationContext,
//            BookDatabase::class.java,
//            "BookDB"
//        ).build()
//
//        Thread {
//            val book = Book(
//                1,
//                "android book"
//            )
//            db.bookDao().saveBook(book)
//
//            db.bookDao().getAllBook().forEach
//
//        }

        val bookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)

        bookViewModel.save(Book(1,"android"))

//        val bookAdapter = BookAdapter()


    }
}