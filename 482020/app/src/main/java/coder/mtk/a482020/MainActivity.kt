package coder.mtk.a482020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCount.setOnClickListener{
            var count : Int = txtCount.text.toString().toInt()
            count += 1
            txtCount.text = count.toString()
        }

        btnNext.setOnClickListener{
            val intent = Intent (this,NextActivity::class.java) // called reflection
            val count = txtCount.text.toString()
            intent.putExtra("COUNT",count)
            startActivity(intent)
        }
    }

}