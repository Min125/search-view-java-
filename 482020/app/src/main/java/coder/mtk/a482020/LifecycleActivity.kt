package coder.mtk.a482020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class LifecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle>>>>>>","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle>>>>>>","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle>>>>>>","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle>>>>>>","onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Lifecycle>>>>>>","onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle>>>>>>","onDestory")
    }
}