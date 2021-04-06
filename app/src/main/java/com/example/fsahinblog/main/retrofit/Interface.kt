package com.example.fsahinblog.main.retrofit

import com.example.fsahinblog.main.model.parentCategory.ResponsegetParentCategory
import retrofit2.Call
import retrofit2.http.GET

interface Interface {

    @GET("ParentCategory")
    fun getParentCategory(): Call<ResponsegetParentCategory>
}