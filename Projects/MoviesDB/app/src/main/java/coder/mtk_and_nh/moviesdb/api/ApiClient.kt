package coder.mtk_and_nh.moviesdb.api

import coder.mtk_and_nh.moviesdb.model.nowPlaying.NowPlaying
import coder.mtk_and_nh.moviesdb.model.popular.Popular
import coder.mtk_and_nh.moviesdb.model.popularactor.PopularActor
import coder.mtk_and_nh.moviesdb.model.searchmovie.SearchMovie
import coder.mtk_and_nh.moviesdb.model.tvshowpopular.PopularTvShow
import coder.mtk_and_nh.moviesdb.model.upcomming.UpComing
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private val BASE_URL = "http://api.themoviedb.org/3/"

    private val apiInterface : ApiInterface

    init {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(ApiInterface::class.java)
    }

    fun getNowPlaying() : Call<NowPlaying>{
        return apiInterface.getNowPlaying("9ef2ef916822104b0887b6c1419c6e7c")
    }

    fun getPopularMovies () : Call<Popular>{
        return apiInterface.getPopularMovies("9ef2ef916822104b0887b6c1419c6e7c")
    }

    fun getUpComing () : Call<UpComing>{
        return apiInterface.getUpComing("9ef2ef916822104b0887b6c1419c6e7c")
    }

    fun getPopularActor () : Call<PopularActor>{
        return apiInterface.getPopularActor("9ef2ef916822104b0887b6c1419c6e7c")
    }

    fun getSearchMovie (search : String) :Call<SearchMovie>{
        return apiInterface.getSearchMovie("9ef2ef916822104b0887b6c1419c6e7c",search)
    }

    fun getNowPlayingMovies (page : Int) : Call<NowPlaying>{
        return apiInterface.getNowPlayingMovie("9ef2ef916822104b0887b6c1419c6e7c",page )
    }

    fun getPopularTvShow (page: Int) : Call <PopularTvShow>{
        return apiInterface.getTVPopularPage("9ef2ef916822104b0887b6c1419c6e7c",page )
    }

}