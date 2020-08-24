package coder.mtk.roomdatabaseassigmnet1.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coder.mtk.roomdatabaseassigmnet1.database.ProductDatabase
import coder.mtk.roomdatabaseassigmnet1.model.Product
import coder.mtk.roomdatabaseassigmnet1.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application){
    private val repository : ProductRepository
    val allProduct: LiveData<List<Product>>
    lateinit var  rangeByPrice :List<Product>

    init {
        val productDao = ProductDatabase.getDatabase(
            application
        ).productDao()

        repository = ProductRepository(productDao)
        allProduct = repository.allProduct
    }

   fun insert (product : Product)=viewModelScope.launch{
        repository.insert(product)
    }

    fun deleteProduct (id : Int) = viewModelScope.launch{
        repository.deleteProduct(id)
    }

     fun getRangeByPrice (startPrice : Double,endPrice : Double) = viewModelScope.launch{
        repository.getRangeByPrice(startPrice,endPrice)

    }

    fun getPRICE () : List<Product> = rangeByPrice

     fun getProductName (name : String) = viewModelScope.launch{
        repository.getProductName(name)
    }
}