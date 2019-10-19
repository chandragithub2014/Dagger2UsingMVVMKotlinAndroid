package com.example.myapplication.network.di


import com.example.myapplication.network.repository.RetrofitRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class APIModule constructor(baseURL:String) {
    var baseURL:String?=""

    init {
        this.baseURL = baseURL
    }
@Singleton
@Provides
 fun provideOKHttpClient():OkHttpClient{
     return  OkHttpClient.Builder()
         .readTimeout(1200,TimeUnit.SECONDS)
         .connectTimeout(1200,TimeUnit.SECONDS)
         .build()

 }
@Singleton
@Provides
fun provideGSON(): GsonConverterFactory {

   return  GsonConverterFactory.create()

    }
@Singleton
 @Provides
 fun provideRetrofit(gsonConverterFactory: GsonConverterFactory,okHttpClient: OkHttpClient):Retrofit{

      return     Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(gsonConverterFactory)
                .client(okHttpClient)
                 .build()
 }

    @Provides
    fun provideRetroRepository():RetrofitRepository{
        return RetrofitRepository()
    }

}