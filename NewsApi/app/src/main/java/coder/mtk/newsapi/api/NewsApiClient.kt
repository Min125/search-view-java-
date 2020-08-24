package coder.mtk.newsapi.api

import coder.mtk.newsapi.model.News
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class NewsApiClient {
    private val BASE_URL = "https://newsapi.org/v2/"

    private val apiInterface : NewsApiInterface

    init {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            apiInterface = retrofit.create(NewsApiInterface::class.java)
        }

    fun getTopHeadLine(): Call<News>{
        return apiInterface.getTopHeadLine("us","8f4b1cee839b43ab80645baee4a33881")
    }

}