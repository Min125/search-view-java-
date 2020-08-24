package coder.mtk_and_nh.moviesdb.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import coder.mtk_and_nh.moviesdb.api.ApiClient
import coder.mtk_and_nh.moviesdb.model.nowPlaying.NowPlaying
import coder.mtk_and_nh.moviesdb.model.popular.Popular
import coder.mtk_and_nh.moviesdb.model.popularactor.PopularActor
import coder.mtk_and_nh.moviesdb.model.searchmovie.SearchMovie
import coder.mtk_and_nh.moviesdb.model.tvshowpopular.PopularTvShow
import coder.mtk_and_nh.moviesdb.model.upcomming.UpComing
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel(){

    private var nowPlaying : MutableLiveData<NowPlaying> = MutableLiveData()
    private var upComing : MutableLiveData<UpComing> = MutableLiveData()
    private var popularMovie : MutableLiveData<Popular> = MutableLiveData()
    private var popularActor : MutableLiveData<PopularActor> = MutableLiveData()
    private var searchMovies : MutableLiveData<SearchMovie> = MutableLiveData()
    private var nowPlayingMovie : MutableLiveData<NowPlaying> = MutableLiveData()
    private var popularTvShow : MutableLiveData<PopularTvShow> = MutableLiveData()

    private var nowPlayingProgressBar : MutableLiveData<Boolean> = MutableLiveData()

    fun getNowPlaying () : LiveData <NowPlaying> = nowPlaying
    fun getPopularMovie() : LiveData < Popular> = popularMovie
    fun getUpComing() : LiveData<UpComing> = upComing
    fun getPopularActor () : LiveData<PopularActor> = popularActor
    fun getSearchMovie ():LiveData<SearchMovie> = searchMovies
    fun getNowPlayingMovie () : LiveData<NowPlaying> = nowPlayingMovie
    fun getPopularTvShow () : LiveData<PopularTvShow> = popularTvShow


    fun getNowPlayingProgressBar () : LiveData<Boolean> = nowPlayingProgressBar


    fun loadNowPlaying () {
        val apiClient = ApiClient()
        var apiCall = apiClient.getNowPlaying()

        apiCall.enqueue(
            object : Callback <NowPlaying>{
                override fun onFailure(call: Call<NowPlaying>, t: Throwable) {
                    Log.d("NowShowing>>>>>>>>>>", t.toString())
                    nowPlayingProgressBar.value = false
                }

                override fun onResponse(call: Call<NowPlaying>, response: Response<NowPlaying>) {
                    nowPlaying.value = response.body()
                    nowPlayingProgressBar.value = true
                    Log.d("NowShowing>>>>>>>>>>", response.body().toString())
                }
            }
        )
    }
    fun loadPopularMovie (){
        val apiClient = ApiClient()
        var apiCall = apiClient.getPopularMovies()

        apiCall.enqueue(
            object : Callback<Popular>{
                override fun onFailure(call: Call<Popular>, t: Throwable) {

                }

                override fun onResponse(call: Call<Popular>, response: Response<Popular>) {
                    popularMovie.value = response.body()
                }
            }
        )
    }
    fun loadUpComing ( ){
        val apiClient = ApiClient()
        val apiCall = apiClient.getUpComing()

        apiCall.enqueue(
            object : Callback<UpComing>{
                override fun onFailure(call: Call<UpComing>, t: Throwable) {

                }

                override fun onResponse(call: Call<UpComing>, response: Response<UpComing>) {
                    upComing.value = response.body()
                }
            }
        )
    }
    fun loadPopularActor (){
        val apiClient = ApiClient()
        val apiCall = apiClient.getPopularActor()

        apiCall.enqueue(
            object : Callback<PopularActor>{
                override fun onFailure(call: Call<PopularActor>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<PopularActor>,
                    response: Response<PopularActor>
                ) {
                    popularActor.value = response.body()
                    Log.d("PopularActor>>>>>>>>>>",response.body().toString())
                }

            }
        )
    }
    fun loadSearchMovie (name : String){
        val apiClient = ApiClient()
        val apiCall = apiClient.getSearchMovie(name)

        apiCall.enqueue(
            object : Callback<SearchMovie> {
                override fun onFailure(call: Call<SearchMovie>, t: Throwable) {
                    Log.d("SearchResult >>>",t.toString())
                }

                override fun onResponse(call: Call<SearchMovie>, response: Response<SearchMovie>) {
                    searchMovies.value = response.body()
                    Log.d("SearchResult >>>",response.body().toString())
                }
            }
        )
    }
    fun loadNowPlayingMovie (page : Int) {
        val apiClient = ApiClient()
        val apiCall = apiClient.getNowPlayingMovies(page)

        apiCall.enqueue(
            object : Callback<NowPlaying>{
                override fun onFailure(call: Call<NowPlaying>, t: Throwable) {

                }
                override fun onResponse(call: Call<NowPlaying>, response: Response<NowPlaying>) {
                    nowPlayingMovie.value = response.body()
                }
            }
        )
    }
    fun loadPopularTvShow ( page : Int ){
        val apiClient = ApiClient()
        val apiCall = apiClient.getPopularTvShow(page)

        apiCall.enqueue(
            object  : Callback <PopularTvShow> {
                override fun onFailure(call: Call<PopularTvShow>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<PopularTvShow>,
                    response: Response<PopularTvShow>
                ) {
                   popularTvShow.value = response.body()
                }

            }
        )
    }

}