package com.example.mymvvmretrofitproject.nwt

import com.example.mymvvmretrofitproject.model1.User
import com.example.mymvvmretrofitproject.model1.getModel.VolumesResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {
    @POST("users")
    fun createPost(@Body user: User): Call<User>
    @GET("/books/v1/volumes")
    fun searchVolumes(@Query("q") query:String,
    @Query("inauthor") author:String,
   /* @Query("key") key:String*/):Call<VolumesResponse>
}