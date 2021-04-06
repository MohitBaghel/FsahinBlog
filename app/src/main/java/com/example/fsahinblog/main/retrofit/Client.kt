package com.example.fsahinblog.main.retrofit

import android.app.Service
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

 public class Client {

    fun getMethod(){
         val client = OkHttpClient.Builder().build()

        val retrofit=Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://api.mever.in/api/")
            .client(client)
            .build()

        fun<T> buildService(service: Class<T>): T{
            return retrofit.create(service)
        }
//        val service=retrofit.create(service)
    }
}