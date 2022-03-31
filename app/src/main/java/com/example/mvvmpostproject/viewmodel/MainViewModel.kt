package com.example.mymvvmretrofitproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymvvmretrofitproject.model1.User
import com.example.mymvvmretrofitproject.repository2.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(val repository: MainRepository):ViewModel() {
val dataResponse = MutableLiveData<String>()
val errorMessage = MutableLiveData<String>()
fun getDataUser(name:String,job:String){
    val user = User(name = name, job = job)
val response =repository.getdata(user)
    response.enqueue(object : Callback<User> {
        override fun onResponse(call: Call<User>, response: Response<User>) {
           dataResponse.value = response.body().toString()
        }

        override fun onFailure(call: Call<User>, t: Throwable) {
           errorMessage.value = t.message
        }

    })
}
}