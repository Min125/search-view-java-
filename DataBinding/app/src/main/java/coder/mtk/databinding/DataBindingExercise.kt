package coder.mtk.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.bind
import coder.mtk.databinding.databinding.ActivityDataBindingExerciseBinding

import androidx.databinding.DataBindingUtil.setContentView as setContentView1

class DataBindingExercise : AppCompatActivity() {
    lateinit var binding : ActivityDataBindingExerciseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding_exercise)
        binding.btnSubmit.setOnClickListener {

            var person = Person(binding.etName.text.toString(), binding.etOccupation.text.toString())
            binding.person1 = person
        }
    }
}