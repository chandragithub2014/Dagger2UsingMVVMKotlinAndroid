package com.example.myapplication.network.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.MyRetroApplication
import com.example.myapplication.network.di.APIComponent
import com.example.myapplication.network.di.APIModule
import com.example.myapplication.network.di.DaggerAPIComponent
import com.example.myapplication.network.repository.APIURL
import com.example.myapplication.network.repository.RetrofitRepository
import javax.inject.Inject


class RetroViewModelFactory : ViewModelProvider.Factory {
    lateinit var apiComponent: APIComponent
    @Inject
    lateinit var retrofitRepository: RetrofitRepository

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
     //   initDaggerComponent()
       var apiComponent :APIComponent =  MyRetroApplication.apiComponent
        apiComponent.inject(this)
        if (modelClass.isAssignableFrom(RetroViewModel::class.java)) {
            return RetroViewModel(retrofitRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

    fun initDaggerComponent(){
        apiComponent =   DaggerAPIComponent
            .builder()
            .aPIModule(APIModule(APIURL.BASE_URL))
            .build()
        apiComponent.inject(this)
    }
}