package coder.mtk.roomdatabaseassigmnet1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import coder.mtk.roomdatabaseassigmnet1.model.Product
import kotlinx.android.synthetic.main.activity_insert_data.*

class InsertDataActivity : AppCompatActivity() {

    lateinit var id: String
    lateinit var name: String
    lateinit var price: String
    lateinit var qty: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_data)

        btnAdd.setOnClickListener {
            val replyIntent = Intent()

            id = edtId.text.toString()
            if (TextUtils.isEmpty(edtId.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                id = edtId.text.toString()
                name = edtName.text.toString()
                price = edtPrice.text.toString()
                qty = edtQty.text.toString()
                replyIntent.putExtra(EXTRA_ID, id)
                replyIntent.putExtra(EXTRA_NAME, name)
                replyIntent.putExtra(EXTRA_PRICE, price)
                replyIntent.putExtra(EXTRA_QTY, qty)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_ID = "REPLY_ID"
        const val EXTRA_NAME = "REPLY_NAME"
        const val EXTRA_PRICE = "REPLY_PRICE"
        const val EXTRA_QTY = "REPLY_QTY"

    }
}