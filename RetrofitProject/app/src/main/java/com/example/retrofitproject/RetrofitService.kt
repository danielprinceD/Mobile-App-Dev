package com.example.retrofitproject

import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {
    @GET("/posts")
    suspend fun getItems() : Response<Data>
}