package coder.mtk.viewmodel

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import coder.mtk.viewmodel.viewmodel.CountViewMethod
import kotlinx.android.synthetic.main.activity_main.*

class SimpleViewModelActivity : AppCompatActivity() {
    private val sharedField = "SHARE_COUNT"  // assign file name for store data

    var sharedPerferences : SharedPreferences? = null

    var editor  : SharedPreferences.Editor? = null

    lateinit var countViewMethod: CountViewMethod

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPerferences = getSharedPreferences(sharedField, Context.MODE_PRIVATE)

        editor = sharedPerferences?.edit()

        countViewMethod = ViewModelProvider(this).get(CountViewMethod::class.java)

        var count = sharedPerferences?.getInt("COUNT",0)
        txtCount.text = count.toString()

        btnCount.setOnClickListener {
            var countNum = txtCount.text.toString().toInt()
            countViewMethod.setCount(countNum)

            txtCount.text = countViewMethod.getCount().toString()

        }
    }

    override fun onPause() {
        super.onPause()
        editor?.putInt("COUNT", countViewMethod.getCount())//txtCount.text.toString().toInt()
        editor?.apply()
    }
}



