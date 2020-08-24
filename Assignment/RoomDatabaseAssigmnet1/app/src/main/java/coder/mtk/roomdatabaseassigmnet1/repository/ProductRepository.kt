package coder.mtk.roomdatabaseassigmnet1.repository

import androidx.lifecycle.LiveData
import coder.mtk.roomdatabaseassigmnet1.dao.ProductDao
import coder.mtk.roomdatabaseassigmnet1.model.Product

class ProductRepository (private val productDao : ProductDao){
    val allProduct : LiveData <List<Product>> = productDao.getAllProduct()

    suspend fun insert (product : Product){
        productDao.insert(product)
    }

    suspend fun deleteProduct (id : Int){
        productDao.deleteProductItem(id)
    }

    suspend fun getRangeByPrice (startPrice : Double,endPrice : Double):List<Product>{
       return productDao.getRangeByPrice(startPrice,endPrice)
    }

    suspend fun getProductName (name : String){
        productDao.getProductName(name)
    }
}