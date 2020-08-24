package coder.mtk.roomdatabaseassigmnet1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import coder.mtk.roomdatabaseassigmnet1.dao.ProductDao
import coder.mtk.roomdatabaseassigmnet1.model.Product

@Database(entities = arrayOf(Product::class),version = 1)
abstract class ProductDatabase  : RoomDatabase() {
    abstract fun productDao () : ProductDao

    companion object{
        private var INSTANCE : ProductDatabase? = null

        fun getDatabase (context: Context) : ProductDatabase{
            val temInstance = INSTANCE
            if (temInstance !=null){
                return temInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductDatabase::class.java,
                    "product_database"
                ).build()
                INSTANCE =instance
                return instance
            }
        }

    }
}