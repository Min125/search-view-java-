package coder.mtk_and_nh.roomdatabase.repository

import androidx.lifecycle.LiveData
import coder.mtk_and_nh.roomdatabase.dao.BooKDao
import coder.mtk_and_nh.roomdatabase.database.BookDatabase
import coder.mtk_and_nh.roomdatabase.model.Book

class BookRespository (private val bookDao : BooKDao){
    val allBook : LiveData<List<Book>> = bookDao.getAllBook()

    suspend fun booInsert(book:Book){
        bookDao.saveBook(book)
    }
}