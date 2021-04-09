package com.example.fsahinblog.main.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fsahinblog.R
import com.example.fsahinblog.main.adapter.FashionCategoryAdapter
import com.example.fsahinblog.main.model.parentCategory.CategoryListItem
import com.example.fsahinblog.main.model.parentCategory.ResponsegetParentCategory
import com.example.fsahinblog.main.retrofit.ApiClient
import com.example.fsahinblog.main.retrofit.ApiInterface
import com.example.fsahinblog.main.utilities.basicUtilities
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    private lateinit var fashionadapter: FashionCategoryAdapter
    private var list = ArrayList<CategoryListItem>()
    private var api: ApiInterface? = null
//    var progress_bar: ProgressBar = TODO()
    val token:String = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiNDYzMTdlM2M0NDVhMWU3MmY4ZWQzMjQxYjcxOWY0NzZiM2E5YjYxYWMxZjBmNGE3YmQxZjIxMzkwYzAxOTNlZWM5YmY0ZTk3MDI2NGJkNjQiLCJpYXQiOjE2MTc3MzE4NzIuMDA0MzQyLCJuYmYiOjE2MTc3MzE4NzIuMDA0MzQ2LCJleHAiOjE2NDkyNjc4NzEuOTk4NzkyLCJzdWIiOiIzIiwic2NvcGVzIjpbXX0.oICehhgqIy3IH5lGqMb0Q3rR1MINnNC-sHrjNVDiC0avIXiUxbXjKpWaJDOQEzT3aJv4zs-7ClReWRJ4IdqJ8X5emB51kFM5imIO09waCjmwgoNb2s6VqjLEl3v3YZaTkit-RANtkiO61PrZ_QgnytN0ConLT_c7Yt3VLhyinlCTzC4tzZueUgjf0v4N5pA4_6CWsJorNBKjwpK98je9DpBQgyRUV0E0gXia3kJ5Pcx30tdw_xwQEB_mInWF_pShXp6tlG_Q9vjr0g79APf3y80xRXGDwbMszTV3fWB86JDpN1p5y1D8CywOAbF9G8eVVcMEuMI5cYmlzvg-qEGuYI2HXAj0JaGsW1Bu5yzZ5ncq3S27u-zSIQdzdXAUQv5aAlcDEjdancGyOYR1KbJ60hz6t7UisTgF15RwEMM-xkW74AzzcqQYeWjmwLDFif_POPxtUM0vDtVzHHztHnIV3pUbwf_JVnTD0n-EEwXBL4zL6C-wxDcRucXI3B16IUhhIJHJV_vHKsXXp07tkBHswIsIq53DhQdkuu2fYMNQzZcYCMiCGQYbRcwcLTqVabNgj1uu6oFm27vvQJDr4WR8Owt5d-zOeZJF3zADcVnwXlfGaf62PvDy9VDpXXhZFgZVoK3awU-dzZzlkMpATcckML9L2jnm1yH-GP3gD87TN6A"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
//         progress_bar=findViewById(R.id.progressBar)
        val recyclerview: RecyclerView = findViewById(R.id.fashion_rv)
        val grid = GridLayoutManager(this, 1)
        fashionadapter=FashionCategoryAdapter(this,list)
        recyclerview!!.adapter = fashionadapter
        recyclerview.layoutManager = grid
        recyclerview.hasFixedSize()

        if (basicUtilities.checkInternetConnectivity(this)) {
            fashionData()
            }
        }catch (E:java.lang.Exception) {
            E.stackTrace
        }
    }
        fun fashionData() {
            try {
//                progress_bar.visibility= View.VISIBLE
                var api: ApiInterface = ApiClient.client.create(ApiInterface::class.java)
                val call = api.getParentCategory("Bearer "+token)
                call.enqueue(object : retrofit2.Callback<ResponsegetParentCategory?> {
                //ctrl+shift+space

                override fun onResponse(call: Call<ResponsegetParentCategory?>, response: Response<ResponsegetParentCategory?>) {

                    if (response.body()?.data?.categoryList?.size!! > 0 && response.body()?.status == 200) {
//                        progress_bar.visibility=View.GONE
                        Log.d("response", response.body().toString())

                        try {
                            list = response.body()!!.data.categoryList as ArrayList<CategoryListItem>
                            fashionadapter = FashionCategoryAdapter(baseContext, list)
                            fashionadapter.notifyDataSetChanged()
                        } catch (e: Exception) {
                            e.stackTrace
                        }
                    }
                }

                override fun onFailure(call: Call<ResponsegetParentCategory?>, t: Throwable) {
//                    progress_bar.visibility=View.GONE
                    t.stackTrace
                }
            })

                  }catch (e:Exception){

                  }
        }
    }