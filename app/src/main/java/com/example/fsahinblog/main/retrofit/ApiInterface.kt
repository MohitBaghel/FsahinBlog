package com.example.fsahinblog.main.retrofit

import com.example.fsahinblog.main.model.parentCategory.ResponsegetParentCategory
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiInterface {

    @GET("ParentCategory")
    fun getParentCategory(@Header ("Authorization")token:String): Call<ResponsegetParentCategory>

}