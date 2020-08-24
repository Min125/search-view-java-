package coder.mtk.jsonretrofitsample.api

import coder.mtk.jsonretrofitsample.model.PostItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
        @GET("posts")
    fun getPost(): Call<ArrayList<PostItem>>

    @GET("posts/{postID}")
    fun getPostWidthID(
        @Path("postID")postID : String
    ) : Call<PostItem>
}