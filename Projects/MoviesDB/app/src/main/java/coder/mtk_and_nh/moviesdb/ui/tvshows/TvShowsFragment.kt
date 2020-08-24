package coder.mtk_and_nh.moviesdb.ui.tvshows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import coder.mtk_and_nh.moviesdb.R
import coder.mtk_and_nh.moviesdb.adapter.MoviesAdapter
import coder.mtk_and_nh.moviesdb.adapter.PopularTvShowAdapter
import coder.mtk_and_nh.moviesdb.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_tv_shows.*

class TvShowsFragment : Fragment() {

    lateinit var viewModel : MovieViewModel
    lateinit var popularTvShowAdapter: PopularTvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_shows, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var pageNumber : Int= 1

        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        popularTvShowAdapter = PopularTvShowAdapter()

        recyclerTvShow.layoutManager = GridLayoutManager(context,2)

        viewModel.loadPopularTvShow(pageNumber)

        viewModel.getPopularTvShow().observe(
            viewLifecycleOwner, Observer {
                popularTvShowAdapter.updateResult(it.results)
                recyclerTvShow.adapter = popularTvShowAdapter
            }
        )

        btnTvShowNextButton.setOnClickListener {
            pageNumber += 1
            viewModel.loadPopularTvShow(pageNumber)

            viewModel.getPopularTvShow().observe(
                viewLifecycleOwner, Observer {
                    popularTvShowAdapter.updateResult(it.results)
                    recyclerTvShow.adapter = popularTvShowAdapter
                }
            )
            txtTvShowPageNumber.text = pageNumber.toString()
        }
        btnTvShowPreviousButton.setOnClickListener {
            if (pageNumber > 1 ) {
                pageNumber -= 1
                viewModel.loadPopularTvShow(pageNumber)

                viewModel.getPopularTvShow().observe(
                    viewLifecycleOwner, Observer {
                        popularTvShowAdapter.updateResult(it.results)
                        recyclerTvShow.adapter = popularTvShowAdapter
                    }
                )
                txtTvShowPageNumber.text = pageNumber.toString()
            }
        }
    }

}