package coder.mtk.badee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val countViewModel = ViewModelProvider(this).get(CountViewModel::class.java)

        count.text = countViewModel.getTimes().toString()
        setCount.text = countViewModel.getSets().toString()

        btnCount.setOnClickListener {
            var countNum : Int = countViewModel.setTimes()
            if (countNum >= 108){
                var setsNum = countViewModel.setSets()
                setCount.text = setsNum.toString()
                countViewModel.resetTimes()
                count.text = countViewModel.getTimes().toString()
                if (countViewModel.getSets() == 9 ){
                        showAlertDialog()
                }
            }
            count.text = countNum.toString()
        }

        btnReset.setOnClickListener {
            countViewModel.resetSets()
            countViewModel.resetTimes()
            count.text = countViewModel.resetTimes().toString()
            setCount.text = countViewModel.resetSets().toString()
        }

    }
    fun showAlertDialog () {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Congratulation !!! ")
        builder.setMessage("You are Complete Koe Na Win Badee for Today. If you want to continue click to 'Yes' and to exit 'No'.")

        builder.setPositiveButton("Yes"){ dialog, which ->

        }

        builder.setNegativeButton("No") { dialog, which ->
            this.finish()
        }
        builder.show()

    }
}