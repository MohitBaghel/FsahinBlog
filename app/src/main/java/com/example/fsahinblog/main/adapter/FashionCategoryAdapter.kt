package com.example.fsahinblog.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fsahinblog.R
import com.example.fsahinblog.main.model.parentCategory.CategoryListItem

class FashionCategoryAdapter(val context:Context, val list:List<CategoryListItem>) : RecyclerView.Adapter<FashionCategoryAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FashionCategoryAdapter.ViewHolder {
        val View=LayoutInflater.from(parent.context).inflate(R.layout.fashion_category_adapter,parent,false)
        return FashionCategoryAdapter.ViewHolder(View)
    }

    override fun onBindViewHolder(holder: FashionCategoryAdapter.ViewHolder, position: Int) {

//        holder.icon=list[position].image
        holder.fashion_text.text=list!!.get(position).name
    }

    override fun getItemCount()=list.size

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
//        var icon:TextView
//        var text:TextView
        var icon:ImageView=itemView.findViewById(R.id.icon_iv)
        var fashion_text:TextView=itemView.findViewById(R.id.fashion_item)
//        init {
//            icon=itemView.icon_iv
//            text=itemView.fashion_item
//
//        }

    }


}

//eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiNDYzMTdlM2M0NDVhMWU3MmY4ZWQzMjQxYjcxOWY0NzZiM2E5YjYxYWMxZjBmNGE3YmQxZjIxMzkwYzAxOTNlZWM5YmY0ZTk3MDI2NGJkNjQiLCJpYXQiOjE2MTc3MzE4NzIuMDA0MzQyLCJuYmYiOjE2MTc3MzE4NzIuMDA0MzQ2LCJleHAiOjE2NDkyNjc4NzEuOTk4NzkyLCJzdWIiOiIzIiwic2NvcGVzIjpbXX0.oICehhgqIy3IH5lGqMb0Q3rR1MINnNC-sHrjNVDiC0avIXiUxbXjKpWaJDOQEzT3aJv4zs-7ClReWRJ4IdqJ8X5emB51kFM5imIO09waCjmwgoNb2s6VqjLEl3v3YZaTkit-RANtkiO61PrZ_QgnytN0ConLT_c7Yt3VLhyinlCTzC4tzZueUgjf0v4N5pA4_6CWsJorNBKjwpK98je9DpBQgyRUV0E0gXia3kJ5Pcx30tdw_xwQEB_mInWF_pShXp6tlG_Q9vjr0g79APf3y80xRXGDwbMszTV3fWB86JDpN1p5y1D8CywOAbF9G8eVVcMEuMI5cYmlzvg-qEGuYI2HXAj0JaGsW1Bu5yzZ5ncq3S27u-zSIQdzdXAUQv5aAlcDEjdancGyOYR1KbJ60hz6t7UisTgF15RwEMM-xkW74AzzcqQYeWjmwLDFif_POPxtUM0vDtVzHHztHnIV3pUbwf_JVnTD0n-EEwXBL4zL6C-wxDcRucXI3B16IUhhIJHJV_vHKsXXp07tkBHswIsIq53DhQdkuu2fYMNQzZcYCMiCGQYbRcwcLTqVabNgj1uu6oFm27vvQJDr4WR8Owt5d-zOeZJF3zADcVnwXlfGaf62PvDy9VDpXXhZFgZVoK3awU-dzZzlkMpATcckML9L2jnm1yH-GP3gD87TN6A