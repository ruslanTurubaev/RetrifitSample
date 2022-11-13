package com.example.retrofittester2.data.common

import com.example.retrofittester2.data.interfaces.RetrofitServices
import com.example.retrofittester2.data.retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://www.simplifiedcoding.net/demos/"
    val retrofitServices : RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}