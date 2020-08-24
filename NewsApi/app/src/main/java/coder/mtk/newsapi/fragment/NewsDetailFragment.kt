package coder.mtk.newsapi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coder.mtk.newsapi.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_news_detail.*


class NewsDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var messageArgs = arguments?.let {
            NewsDetailFragmentArgs.fromBundle(it)
        }

        var title : String = messageArgs?.title.toString()
        var image : String = messageArgs?.image.toString()
        var source : String = messageArgs?.source.toString()


        newsDetailTitle.text = title
        Picasso.get()
            .load(image)
            .placeholder(R.drawable.ic_launcher_background)
            .into(newsDetailImage)
        newsDetailSource.text = source
    }

}