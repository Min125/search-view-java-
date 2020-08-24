package coder.mtk.roomdatabaseassigmnet1.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
class Product (
    @PrimaryKey()
    @ColumnInfo(name = "id")
    var id : Int ,

    @ColumnInfo(name = "name")
    var name : String,

    @ColumnInfo(name = "price")
    var price : Double,

    @ColumnInfo(name = "quantity")
    var quantity : Int
)