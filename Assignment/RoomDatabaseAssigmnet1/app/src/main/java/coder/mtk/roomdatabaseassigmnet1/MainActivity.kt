package coder.mtk.roomdatabaseassigmnet1

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import coder.mtk.roomdatabaseassigmnet1.adapter.ProductAdapter
import coder.mtk.roomdatabaseassigmnet1.model.Product
import coder.mtk.roomdatabaseassigmnet1.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_search_by_price.*
import kotlinx.android.synthetic.main.delete_dialog.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var productViewModel: ProductViewModel
    private lateinit var productAdapter: ProductAdapter

    private val addProductActivityResultCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productViewModel = ViewModelProviders.of(this).get(ProductViewModel::class.java)
        productAdapter = ProductAdapter()

        recyclerProductList.apply {
            layoutManager = LinearLayoutManager(context)
//            adapter = productAdapter
        }

        productViewModel.allProduct.observe(
            this, Observer {
                productAdapter.addProductList(it)
                recyclerProductList.adapter = productAdapter
                Log.d("AllProduct", it.toString())
            }
        )

        btnInsert.setOnClickListener {
            val intent = Intent(this, InsertDataActivity::class.java)
            startActivityForResult(intent, addProductActivityResultCode)
        }

        btnDelete.setOnClickListener{
            var builder = AlertDialog.Builder(this)
            builder.apply {
                val deleteDialog = layoutInflater.inflate(R.layout.delete_dialog,null)
                setTitle("Delete Item")
                setView(deleteDialog)
                setPositiveButton("Ok"){
                    dialogInterface, i ->
                    var deleteText = deleteDialog.edtIdDelete.text.toString().toInt()
                    productViewModel.deleteProduct(deleteText)
                }
            }
            val alertDialogshow = builder.create()
            builder.show()
        }

        btnSearchByRange.setOnClickListener {
            var intent = Intent(this,SearchByPriceActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == addProductActivityResultCode && resultCode == Activity.RESULT_OK) {
            var id : Int?
            var name : String?
            var price : Double?
            var qty : Int?
            id = data?.getStringExtra(InsertDataActivity.EXTRA_ID)?.toInt()
            name = data?.getStringExtra(InsertDataActivity.EXTRA_NAME)
            price = data?.getStringExtra(InsertDataActivity.EXTRA_PRICE)?.toDouble()
            qty = data?.getStringExtra(InsertDataActivity.EXTRA_QTY)?.toInt()
            var product = Product(id!!,name!!,price!!,qty!!)
            Log.d("product>>>",product.toString())
            productViewModel.insert(product)
        }
    }
}