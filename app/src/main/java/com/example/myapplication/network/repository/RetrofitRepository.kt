package com.example.myapplication.network.repository


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.MyRetroApplication
import com.example.myapplication.network.di.APIComponent
import com.example.myapplication.network.di.APIModule
import com.example.myapplication.network.di.DaggerAPIComponent
import com.example.myapplication.network.model.PostInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class RetrofitRepository {
    lateinit var apiComponent: APIComponent
    var postInfoMutableList: MutableLiveData<List<PostInfo>> = MutableLiveData()
    @Inject
    lateinit var retrofit: Retrofit
    init {
       /* apiComponent =   DaggerAPIComponent
            .builder()
            .aPIModule(APIModule(APIURL.BASE_URL))
            .build()
        apiComponent.inject(this)*/

        var apiComponent :APIComponent =  MyRetroApplication.apiComponent
        apiComponent.inject(this)
    }


    fun fetchPostInfoList(): LiveData<List<PostInfo>> {

         var apiService:APIService = retrofit.create(APIService::class.java)
         var postListInfo : Call<List<PostInfo>> =  apiService.makeRequest()
        postListInfo.enqueue(object :Callback<List<PostInfo>>{
            override fun onFailure(call: Call<List<PostInfo>>, t: Throwable) {
             Log.d("RetroRepository","Failed:::"+t.message)
            }

            override fun onResponse(call: Call<List<PostInfo>>, response: Response<List<PostInfo>>) {
                var postInfoList = response.body()
                postInfoMutableList.value = postInfoList

            }
        })

         return  postInfoMutableList

    }


}