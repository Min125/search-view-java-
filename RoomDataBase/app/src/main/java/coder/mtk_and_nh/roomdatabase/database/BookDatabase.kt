package coder.mtk_and_nh.roomdatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import coder.mtk_and_nh.roomdatabase.dao.BooKDao
import coder.mtk_and_nh.roomdatabase.model.Book

@Database(entities = [(Book::class)],version = 1)
abstract class BookDatabase : RoomDatabase(){
    abstract fun bookDoa() : BooKDao

    companion object{
        private var INSTANCE : BookDatabase? = null

        fun getDatabase (context : Context):BookDatabase {
            val temInstance = INSTANCE
            if (temInstance != null){
                return temInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    BookDatabase::class.java,
                    "BookDB"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}