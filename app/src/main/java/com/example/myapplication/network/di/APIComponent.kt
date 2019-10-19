package com.example.myapplication.network.di

import com.example.myapplication.AppModule
import com.example.myapplication.network.repository.RetrofitRepository
import com.example.myapplication.network.view.RetroFragment
import com.example.myapplication.network.viewmodel.RetroViewModel
import com.example.myapplication.network.viewmodel.RetroViewModelFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,APIModule::class])
interface APIComponent {
    fun inject(retrofitRepository: RetrofitRepository)
    fun inject(retroViewModel: RetroViewModel)
    fun inject(retroFragment: RetroFragment)
    fun inject(retroViewModelFactory:RetroViewModelFactory)
}