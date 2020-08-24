package coder.mtk.a482020

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnNextLogin.setOnClickListener {
            val name : String = etName.text.toString()
            val age : String = etAge.text.toString()
            val intent = Intent (this,LoginNextActivity::class.java)
            intent.putExtra("NAME",name)
            intent.putExtra("AGE",age)
            startActivity(intent)
        }
    }
}