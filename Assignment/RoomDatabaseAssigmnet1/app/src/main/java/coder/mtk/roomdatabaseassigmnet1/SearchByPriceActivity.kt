package coder.mtk.roomdatabaseassigmnet1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import coder.mtk.roomdatabaseassigmnet1.adapter.ProductAdapter
import coder.mtk.roomdatabaseassigmnet1.model.Product
import coder.mtk.roomdatabaseassigmnet1.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.activity_search_by_price.*

class SearchByPriceActivity : AppCompatActivity() {

    lateinit var viewModel: ProductViewModel
    lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_by_price)

        viewModel = ViewModelProviders.of(this).get(ProductViewModel::class.java)

        recyclerStartEnd.layoutManager = LinearLayoutManager(this)

        productAdapter = ProductAdapter()

        btnSearch.setOnClickListener{
            var startPrice = edtStartPrice.text.toString().toDouble()
            var endPrice = edtEndPrice.text.toString().toDouble()

            viewModel.getRangeByPrice(startPrice,endPrice)

            productAdapter.addProductList(viewModel.getPRICE())

            recyclerStartEnd.adapter = productAdapter

        }
    }
}