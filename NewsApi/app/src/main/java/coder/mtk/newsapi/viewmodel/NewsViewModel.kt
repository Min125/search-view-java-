package coder.mtk.newsapi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import coder.mtk.newsapi.api.NewsApiClient
import coder.mtk.newsapi.model.News
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel(){
    private var result : MutableLiveData<News> = MutableLiveData()
    private var errorMessage : MutableLiveData<String> = MutableLiveData()
    private var progressBar : MutableLiveData<Boolean> = MutableLiveData()
    private var errorStatus: MutableLiveData<Boolean> = MutableLiveData()
    fun  getResult() : LiveData<News> = result
    fun getErrorMessage () : LiveData<String> = errorMessage
    fun getErrorStatus () : LiveData<Boolean> = errorStatus
    fun getProgress () : LiveData<Boolean> = progressBar

    fun loadResult (){
        var apiClient = NewsApiClient()
        var apiCall = apiClient.getTopHeadLine()

        apiCall.enqueue(
            object : Callback<News>{
                override fun onFailure(call: Call   <News>, t: Throwable) {
                    errorMessage.value = t.toString()
                    progressBar.value = true
                    errorStatus.value=true
                }

                override fun onResponse(call: Call<News>, response: Response<News>) {
                    result.value = response.body()
                    progressBar.value =false
                    errorStatus.value = false
                }

            }
        )
    }
}