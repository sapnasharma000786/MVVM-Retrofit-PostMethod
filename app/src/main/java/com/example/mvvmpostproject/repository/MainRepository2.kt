package com.example.mymvvmretrofitproject.repository2

import com.example.mymvvmretrofitproject.nwt.ApiInterface

class MainRepository2 constructor(val apiInterface: ApiInterface) {
    fun getDataValue(query:String,author:String) = apiInterface.searchVolumes(query,author)
}