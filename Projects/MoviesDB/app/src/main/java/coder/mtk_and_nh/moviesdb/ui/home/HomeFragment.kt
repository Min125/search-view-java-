package coder.mtk_and_nh.moviesdb.ui.home

import android.graphics.Movie
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coder.mtk_and_nh.moviesdb.R
import coder.mtk_and_nh.moviesdb.adapter.NowPlayingAdapter
import coder.mtk_and_nh.moviesdb.adapter.PopularActorAdapter
import coder.mtk_and_nh.moviesdb.adapter.PopularMoviesAdapter
import coder.mtk_and_nh.moviesdb.adapter.UpComingAdapter
import coder.mtk_and_nh.moviesdb.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.item_nowplaying.*

class HomeFragment : Fragment() {

    lateinit var viewModel: MovieViewModel

    lateinit var nowPlayingAdapter: NowPlayingAdapter
    lateinit var popularMoviesAdapter: PopularMoviesAdapter
    lateinit var upComingAdapter: UpComingAdapter
    lateinit var popularActorAdapter: PopularActorAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)

        viewModel.loadNowPlaying()

        nowPlayingAdapter = NowPlayingAdapter()

        recyclerNowPlayingHome.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        viewModel.getNowPlaying().observe(
            viewLifecycleOwner, Observer {
                nowPlayingAdapter.updateNowPlayingList(it.results)
                recyclerNowPlayingHome.adapter = nowPlayingAdapter
            }
        )
        viewModel.getNowPlayingProgressBar().observe(
            viewLifecycleOwner, Observer {
                if (it) {
                    pbNowPlaying.visibility = View.INVISIBLE
                } else {
                    pbNowPlaying.visibility = View.VISIBLE
                }
            }
        )


        viewModel.loadPopularMovie()

        popularMoviesAdapter = PopularMoviesAdapter()

        recyclerPopularMovieHome.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        viewModel.getPopularMovie().observe(
            viewLifecycleOwner, Observer {
                popularMoviesAdapter.updatePopularMovieAdapter(it.results)
                recyclerPopularMovieHome.adapter = popularMoviesAdapter
            }
        )

        //UpComing
        viewModel.loadUpComing()

        upComingAdapter = UpComingAdapter()

        recyclerComingSoon.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        viewModel.getUpComing().observe(
            viewLifecycleOwner, Observer {
                upComingAdapter.updateResult(it.results)
                recyclerComingSoon.adapter = upComingAdapter
            }
        )

        //Popular Actor
        viewModel.loadPopularActor()

        popularActorAdapter = PopularActorAdapter()

        recyclerPopularActor.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        viewModel.getPopularActor().observe(
            viewLifecycleOwner, Observer {
                popularActorAdapter.updateResultList(it.results)
                recyclerPopularActor.adapter = popularActorAdapter
            }
        )

    }

}

