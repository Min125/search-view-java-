package coder.mtk_and_nh.roomdatabase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_table")
class Book(
    @PrimaryKey
    @ColumnInfo(name="id")
    var id : Int,

    @ColumnInfo(name = "book_name")
    var bookName : String
)