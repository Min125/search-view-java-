package coder.mtk.newsapi.api

import coder.mtk.newsapi.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiInterface{
    @GET("top-headlines")
    fun getTopHeadLine (
        @Query("country") country : String,
        @Query("apiKey") apiKey : String
    ):Call<News>
}