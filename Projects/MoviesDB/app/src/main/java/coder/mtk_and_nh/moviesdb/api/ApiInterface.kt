package coder.mtk_and_nh.moviesdb.api

import coder.mtk_and_nh.moviesdb.model.nowPlaying.NowPlaying
import coder.mtk_and_nh.moviesdb.model.popular.Popular
import coder.mtk_and_nh.moviesdb.model.popularactor.PopularActor
import coder.mtk_and_nh.moviesdb.model.searchmovie.SearchMovie
import coder.mtk_and_nh.moviesdb.model.tvshowpopular.PopularTvShow
import coder.mtk_and_nh.moviesdb.model.upcomming.UpComing
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Part
import retrofit2.http.Query

interface ApiInterface {

    @GET("movie/now_playing")
    fun getNowPlaying (
        @Query("api_key") api_key : String
    ) : Call<NowPlaying>

    @GET("movie/popular")
    fun getPopularMovies (
        @Query("api_key") api_key : String
    ) : Call<Popular>

    @GET ("movie/upcoming")
    fun getUpComing (
        @Query("api_key") api_key : String
    ) : Call<UpComing>

    @GET("person/popular")
    fun getPopularActor (
        @Query("api_key") api_key : String
    ) : Call<PopularActor>

    @GET("search/movie")
    fun getSearchMovie (
        @Query("api_key") api_key : String,
        @Query("query") query : String
    ) : Call<SearchMovie>

    @GET("movie/popular")
    fun getNowPlayingMovie (
        @Query("api_key") api_key : String,
        @Query("page") page : Int
    ) : Call<NowPlaying>

    @GET("tv/popular")
    fun getTVPopularPage (
        @Query("api_key") api_key : String,
        @Query("page") page : Int
    ) : Call<PopularTvShow>

    @GET("movie/{movie_id}")
    fun getDetailMovie(
        @Query("api_key") api_key : String,
        @Part("movie_id") movie_id : Int
    )
}