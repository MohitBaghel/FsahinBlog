package com.example.fsahinblog.main.retrofit

import android.app.Service
import com.example.fsahinblog.main.utilities.Constant.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

 object ApiClient {



     private var mRetrofit: Retrofit? = null


     val client: Retrofit
         get() {
             if (mRetrofit == null) {
                 mRetrofit = Retrofit.Builder()
                         .baseUrl(BASE_URL)
                         .addConverterFactory(GsonConverterFactory.create())
                         .build()
             }
             return this.mRetrofit!!
         }


//    fun getMethod(){
//         val client = OkHttpClient.Builder().build()
//
//        val retrofit=Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl("http://api.mever.in/api/")
//            .client(client)
//            .build()
//
//        fun<T> buildService(service: Class<T>): T{
//            return retrofit.create(service)
//        }
//        val service=retrofit.create(service)
//    }
}