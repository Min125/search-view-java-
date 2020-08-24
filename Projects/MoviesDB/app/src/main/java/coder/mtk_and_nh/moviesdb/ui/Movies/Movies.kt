package coder.mtk_and_nh.moviesdb.ui.Movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import coder.mtk_and_nh.moviesdb.R
import coder.mtk_and_nh.moviesdb.adapter.MoviesAdapter
import coder.mtk_and_nh.moviesdb.adapter.NowPlayingAdapter
import coder.mtk_and_nh.moviesdb.model.nowPlaying.Result
import coder.mtk_and_nh.moviesdb.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movies.*

class Movies : Fragment() , MoviesAdapter.ClickListener{

    lateinit var movieViewModel : MovieViewModel
    lateinit var moviesAdapter: MoviesAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var pageNow : Int = 1

        moviesAdapter = MoviesAdapter()

        movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)

        movieViewModel.loadNowPlayingMovie(pageNow)

        recyclerMovies.layoutManager = GridLayoutManager(context,2)

        movieViewModel.getNowPlayingMovie().observe(
            viewLifecycleOwner, Observer {
                moviesAdapter.updateNowPlayingList(it.results)
                recyclerMovies.adapter = moviesAdapter
            }
        )

        btnMoviesNextButton.setOnClickListener {
            pageNow += 1
            movieViewModel.loadNowPlayingMovie(pageNow)

            movieViewModel.getNowPlayingMovie().observe(
                viewLifecycleOwner, Observer {
                    moviesAdapter.updateNowPlayingList(it.results)
                    recyclerMovies.adapter = moviesAdapter
                }
            )
            txtPageNumber.text = pageNow.toString()
        }

        btnMoviesPreviousButton.setOnClickListener {
            if(pageNow>1) {
                pageNow -= 1
                movieViewModel.loadNowPlayingMovie(pageNow)

                movieViewModel.getNowPlayingMovie().observe(
                    viewLifecycleOwner, Observer {
                        moviesAdapter.updateNowPlayingList(it.results)
                        recyclerMovies.adapter = moviesAdapter
                    }
                )
                txtPageNumber.text = pageNow.toString()
            }
        }
        moviesAdapter.setOnClickListener(this)
    }

    override fun onClick(result: Result) {
        var action = MoviesDirections.actionNavSlideshowToMoviesDetaailFragment(result.id)
        findNavController().navigate(action)
    }
}