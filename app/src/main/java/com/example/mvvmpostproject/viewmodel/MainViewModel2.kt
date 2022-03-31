package com.example.mymvvmretrofitproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymvvmretrofitproject.model1.getModel.VolumesResponse
import com.example.mymvvmretrofitproject.repository2.MainRepository2
import retrofit2.Call
import retrofit2.Response

class MainViewModel2 constructor(val repository2: MainRepository2):ViewModel() {
    val valumeResponse = MutableLiveData<VolumesResponse>()
    val errorMessage = MutableLiveData<String>()

    fun getDataUse(query:String,author:String){
         val getResponse = repository2.getDataValue(query,author)
        getResponse.enqueue(object : retrofit2.Callback<VolumesResponse>{
            override fun onResponse(
                call: Call<VolumesResponse>,
                response: Response<VolumesResponse>
            ) {
                valumeResponse.value = response.body()
            }

            override fun onFailure(call: Call<VolumesResponse>, t: Throwable) {
                errorMessage.value = t.message
            }

        })
    }
}