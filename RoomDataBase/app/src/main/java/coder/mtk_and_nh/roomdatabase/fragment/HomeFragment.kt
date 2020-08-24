package coder.mtk_and_nh.roomdatabase.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coder.mtk_and_nh.roomdatabase.R
import coder.mtk_and_nh.roomdatabase.model.Book
import coder.mtk_and_nh.roomdatabase.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)

        bookViewModel.save(Book(1,"android"))

         bookViewModel.allBook.observe(
            viewLifecycleOwner, Observer {
                txtName.text = it.get(0).toString()
            }
        )


    }
}