package coder.mtk.jsonretrofitsample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import coder.mtk.jsonretrofitsample.adapter.PostAdapter
import coder.mtk.jsonretrofitsample.api.ApiClient
import coder.mtk.jsonretrofitsample.model.PostItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_post.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getPosts()
        getPostId()
    }

    fun getPosts (){
        val apiClient = ApiClient()
        val apiCall = apiClient.postApiService.getPost()

        apiCall.enqueue(
            object  : Callback<ArrayList<PostItem>>{
                override fun onFailure(call: Call<ArrayList<PostItem>>, t: Throwable) {
//                    txtResponse.text = t.toString()
                    Toast.makeText(
                        applicationContext,
                        t.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onResponse(
                    call: Call<ArrayList<PostItem>>,
                    response: Response<ArrayList<PostItem>>
                ) {
//                    txtResponse.text = response.body().toString() // data htwet chin yin body()

                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = PostAdapter(response.body()!!)
                    }
                   Toast.makeText(
                       applicationContext,
                       response.toString(),
                       Toast.LENGTH_LONG
                   )
                }

            }
        )
    }


    fun getPostId () {
        val postIDApiClient = ApiClient()
        val postIDApiCall = postIDApiClient.postApiService.getPostWidthID("2")

        postIDApiCall.enqueue(
            object : Callback<PostItem>{
                override fun onFailure(call: Call<PostItem>, t: Throwable) {
                    txtPostID.text = t.toString()
                }

                override fun onResponse(call: Call<PostItem>, response: Response<PostItem>) {
                    txtPostID.text = response.body().toString()
                }

            }
        )
    }
}