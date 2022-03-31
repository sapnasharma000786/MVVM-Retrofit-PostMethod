package com.example.mymvvmretrofitproject.repository2

import com.example.mymvvmretrofitproject.model1.User
import com.example.mymvvmretrofitproject.nwt.ApiInterface

class MainRepository constructor(private val apiInterface: ApiInterface) {

    fun getdata(user: User) = apiInterface.createPost(user)
}