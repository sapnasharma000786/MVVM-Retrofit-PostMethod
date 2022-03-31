package com.example.mymvvmretrofitproject.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mymvvmretrofitproject.repository2.MainRepository2
import com.example.mymvvmretrofitproject.viewmodel.MainViewModel2
import java.lang.IllegalArgumentException

class MyViewModelFactory2 constructor(val mainRepository2: MainRepository2):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel2::class.java)){
            MainViewModel2(this.mainRepository2) as T
        }else{
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}