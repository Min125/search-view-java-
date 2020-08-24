package coder.mtk.a482020

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login_next.*

class LoginNextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_next)
        val name : String? = intent.getStringExtra("NAME")
        val age : String? = intent.getStringExtra("AGE")

        txtName.text = name.toString()
        txtAge.text =age.toString()
    }
}


