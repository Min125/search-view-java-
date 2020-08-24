package coder.mtk.fragmenttransaction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coder.mtk.fragmenttransaction.fragment.OneFragment
import coder.mtk.fragmenttransaction.fragment.ThreeFragment
import coder.mtk.fragmenttransaction.fragment.TwoFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btnOne.setOnClickListener{
            val oneFragment = OneFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer,oneFragment)
//            transaction.addToBackStack(null)   //phone back button ko click yin ayin click kae tae fragment ko pyn twr
            transaction.commit()
        }
        btnTwo.setOnClickListener{
            val twoFragment = TwoFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer,twoFragment)
//           transaction.addToBackStack(null)
            transaction.commit()
        }
        btnThree.setOnClickListener{
            val threeFragment = ThreeFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer,threeFragment)
//            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}