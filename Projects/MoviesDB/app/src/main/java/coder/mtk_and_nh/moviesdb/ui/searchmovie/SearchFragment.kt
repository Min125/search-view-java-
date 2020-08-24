package coder.mtk_and_nh.moviesdb.ui.searchmovie

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import coder.mtk_and_nh.moviesdb.R
import coder.mtk_and_nh.moviesdb.adapter.SearchMoviesAdapter
import coder.mtk_and_nh.moviesdb.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_search.*


class SearchFragment : Fragment() {

    lateinit var viewModel : MovieViewModel
    lateinit var searchMovieAdapter : SearchMoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        searchMovieAdapter = SearchMoviesAdapter()
        recyclerSearch.layoutManager = GridLayoutManager(context,2)

        edtSearch.setOnKeyListener(View.OnKeyListener{ v, keyCode, event ->
            if(keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP){
                val search : String = edtSearch.text.toString()
                viewModel.loadSearchMovie(search)
                Log.d("search>>>",search)


                viewModel.getSearchMovie().observe(
                    viewLifecycleOwner, Observer {
                        searchMovieAdapter.updateResult(it.results)
                        recyclerSearch.adapter = searchMovieAdapter
                    }
                )

                return@OnKeyListener true
            }
            false
        })




    }

}
