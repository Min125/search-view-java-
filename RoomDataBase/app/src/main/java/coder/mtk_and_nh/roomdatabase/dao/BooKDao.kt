package coder.mtk_and_nh.roomdatabase.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import coder.mtk_and_nh.roomdatabase.model.Book
import kotlinx.coroutines.flow.callbackFlow

@Dao
interface BooKDao{
    @Query(value = "Select * FROM book_table")
    fun getAllBook() : LiveData<List<Book>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveBook (book: Book)
}