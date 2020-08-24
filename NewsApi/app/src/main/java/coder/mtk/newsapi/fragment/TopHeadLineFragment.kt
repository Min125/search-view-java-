package coder.mtk.newsapi.fragment

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import coder.mtk.newsapi.R
import coder.mtk.newsapi.adapter.NewsAdapter
import coder.mtk.newsapi.api.NewsApiClient
import coder.mtk.newsapi.model.Article
import coder.mtk.newsapi.model.News
import coder.mtk.newsapi.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_top_head_line.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TopHeadLineFragment : Fragment(), NewsAdapter.ClickListener {

    lateinit var newsAdapter: NewsAdapter

    lateinit var viewModel: NewsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_head_line, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

        viewModel.loadResult()

        newsRecyclerView.layoutManager = LinearLayoutManager(context)

        newsAdapter = NewsAdapter()

        viewModel.getResult().observe(
            viewLifecycleOwner, Observer<News> { news ->
                newsAdapter.updateArrayList(news.articles)
                newsRecyclerView.adapter = newsAdapter
            }
        )

        viewModel.getProgress().observe(
            viewLifecycleOwner, Observer { isloading ->
                progressBar.visibility = if (isloading) {
                    View.VISIBLE
                } else {
                    View.INVISIBLE
                }
            }
        )
        viewModel.getErrorStatus().observe(
            viewLifecycleOwner, Observer { status ->
                if (status) {
                    viewModel.getErrorMessage().observe(
                        viewLifecycleOwner, Observer { message ->
                            texterror.visibility= View.VISIBLE
                            texterror.text = message
                            progressBar.visibility = View.INVISIBLE
                        }
                    )
                }
            }
        )

        newsAdapter.setOnClickListener(this)


    }

    override fun click(article: Article) {
        var action = TopHeadLineFragmentDirections.actionTopHeadLineFragmentToNewsDetailFragment(
            article.title,
            article.urlToImage,
            article.description
        )
        findNavController().navigate(action)
    }
}