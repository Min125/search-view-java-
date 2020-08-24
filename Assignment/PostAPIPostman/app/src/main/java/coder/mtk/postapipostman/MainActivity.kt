package coder.mtk.postapipostman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coder.mtk.postapipostman.api.ApiClient
import coder.mtk.postapipostman.model.City
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postcity("Yangon")
    }
    fun postcity (cityName : String){
        var apiClient = ApiClient()
        var apiCall = apiClient.postCityName(cityName)

        apiCall.enqueue(
            object : Callback<City>{
                override fun onFailure(call: Call<City>, t: Throwable) {
                    txtResponse.text = t.toString()
                }

                override fun onResponse(call: Call<City>, response: Response<City>) {
                    txtResponse.text = response.body()?.message
                }

            }
        )
    }
}