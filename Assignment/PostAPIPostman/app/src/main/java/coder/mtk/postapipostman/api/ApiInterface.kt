package coder.mtk.postapipostman.api

import coder.mtk.postapipostman.model.City
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {

    @FormUrlEncoded   //String twe bl add mr mo lo FormUrlEncoded ko 3 tl
    @POST ("city")
    fun addCity(
        @Field("city_name") cityName : String
    ) : Call<City>

}