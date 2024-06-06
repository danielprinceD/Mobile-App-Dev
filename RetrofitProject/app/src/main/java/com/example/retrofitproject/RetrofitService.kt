package com.example.retrofitproject

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {
    @GET("/posts")
    suspend fun getItems() : Response<Data>
    @GET("/posts") suspend fun getItemsByUserId(@Query("userId") userId : Int) : Response<Data>

    @GET("/posts/{id}") suspend fun getDataById(@Path("id") id : Int) : Response<DataItem>
}