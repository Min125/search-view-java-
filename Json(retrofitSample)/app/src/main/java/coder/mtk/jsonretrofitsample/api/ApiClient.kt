package coder.mtk.jsonretrofitsample.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val BASE_URL = "https://my-json-server.typicode.com/typicode/demo/"

    private var retrofit : Retrofit? = null

    init {
//        fun getRetrofitClient () : Retrofit? {
            if (retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
//            return  retrofit
//        }
    }
    val postApiService = retrofit!!.create(
        ApiInterface::class.java
    )
}