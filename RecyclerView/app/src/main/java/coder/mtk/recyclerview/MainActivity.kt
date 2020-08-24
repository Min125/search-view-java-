package coder.mtk.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import coder.mtk.recyclerview.adapter.PersonAdapter
import coder.mtk.recyclerview.model.Person
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var personList = ArrayList<Person>()
        personList.add(Person("John","Web Developer"))
        personList.add(Person("Steven", "Android Developer" ))
        personList.add(Person("James","Java Developer"))
        personList.add(Person("John","Web Developer"))
        personList.add(Person("Steven", "Android Developer" ))
        personList.add(Person("James","Java Developer"))
        personList.add(Person("John","Web Developer"))
        personList.add(Person("Steven", "Android Developer" ))
        personList.add(Person("James","Java Developer"))
        personList.add(Person("John","Web Developer"))
        personList.add(Person("Steven", "Android Developer" ))
        personList.add(Person("James","Java Developer"))

        //List View
        //recyclerView.layoutManager = LinearLayoutManager(this) // vertical
        //recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false) // Horizon

        // Grid View
        recyclerView.layoutManager = GridLayoutManager(this,4)
        recyclerView.adapter = PersonAdapter(personList)
    }
}