package coder.mtk_and_nh.roomdatabase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import coder.mtk_and_nh.roomdatabase.database.BookDatabase
import coder.mtk_and_nh.roomdatabase.model.Book
import coder.mtk_and_nh.roomdatabase.repository.BookRespository
import kotlinx.coroutines.launch

class BookViewModel (application: Application) : AndroidViewModel(application){
    private val repository : BookRespository
    val allBook : LiveData<List<Book>>

    init {
        val bookDao = BookDatabase.getDatabase(application).bookDoa()

        repository = BookRespository(bookDao)
        allBook = repository.allBook
    }

    fun save(book:Book)= viewModelScope.launch {
        repository.booInsert(book)
    }
}