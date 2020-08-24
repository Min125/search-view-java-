package coder.mtk.roomdatabaseassigmnet1.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import coder.mtk.roomdatabaseassigmnet1.model.Product

@Dao
interface ProductDao {
    @Query("SELECT * FROM product_table")
    fun getAllProduct () : LiveData<List<Product>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert (product: Product)

    @Query("DELETE FROM product_table WHERE id=:id ")
    suspend fun deleteProductItem(id : Int)

    @Query("SELECT * FROM product_table WHERE price BETWEEN :startPrice AND :endPrice")
    suspend fun getRangeByPrice(startPrice : Double, endPrice : Double) : List<Product>

    @Query("SELECT * FROM PRODUCT_TABLE WHERE name = :name ")
    suspend fun getProductName (name : String): List<Product>
}