package com.example.myapplication.network.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.network.di.APIComponent
import com.example.myapplication.network.di.APIModule
import com.example.myapplication.network.di.DaggerAPIComponent
import com.example.myapplication.network.model.PostInfo
import com.example.myapplication.network.repository.APIURL
import com.example.myapplication.network.repository.RetrofitRepository
import javax.inject.Inject

class RetroViewModel(retrofitRepository: RetrofitRepository): ViewModel() {

    lateinit var retrofitRepository:RetrofitRepository
    var postInfoLiveData: LiveData<List<PostInfo>> = MutableLiveData()

    init {
        this.retrofitRepository  = retrofitRepository
        fetchPostInfoFromRepository()
        }

    fun fetchPostInfoFromRepository(){
        postInfoLiveData =  retrofitRepository.fetchPostInfoList()
    }


}