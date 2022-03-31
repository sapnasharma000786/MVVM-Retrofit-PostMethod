package com.example.mymvvmretrofitproject.nwt

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    var apiInterface:ApiInterface ? = null
    var apiInterface2:ApiInterface ? = null
    fun  getApiData():ApiInterface{

        if (apiInterface == null){
            val retrofit = Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            apiInterface = retrofit.create(ApiInterface::class.java)
        }
        return apiInterface!!
    }

    fun getSecoendData():ApiInterface{

        if (apiInterface2 == null){
            val retrofit2 = Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            apiInterface2 = retrofit2.create(ApiInterface::class.java)
        }
        return apiInterface2!!
    }
}