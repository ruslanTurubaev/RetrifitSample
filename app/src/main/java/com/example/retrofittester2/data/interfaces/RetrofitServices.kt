package com.example.retrofittester2.data.interfaces

import com.example.retrofittester2.data.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {
    @GET("marvel")
    fun getMovieList(): Call<MutableList<Movie>>
    
    /*
    *some comment
     */
}