package coder.mtk.roomdatabaseassigmnet1.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coder.mtk.roomdatabaseassigmnet1.R
import coder.mtk.roomdatabaseassigmnet1.model.Product
import kotlinx.android.synthetic.main.item_product_list.view.*

class ProductAdapter: RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    var clickListener : ClickListener? = null

    fun setOnClickListener (clickListener :ClickListener){
        this.clickListener=clickListener
    }

    private var products = emptyList<Product>()

    inner class ProductViewHolder(itemView : View) : RecyclerView.ViewHolder (itemView),View.OnClickListener{

        init {
            itemView.setOnClickListener(this)
        }

        lateinit var product: Product

        fun bind(product : Product){
            this.product=product
            itemView.idValue.text = product.id.toString()
            itemView.name.text = product.name
            itemView.price.text =product.price.toString()
            itemView.qty.text = product.quantity.toString()
        }

        override fun onClick(p0: View?) {
            clickListener?.onCLick(product)
        }
    }

    fun addProductList(Product : List<Product>){
        this.products=Product
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_product_list,parent,false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("productsizr>>>>",products.size.toString())
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    interface ClickListener {
        fun onCLick(product: Product)
    }
}