package com.example.mymvvmretrofitproject.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mymvvmretrofitproject.repository2.MainRepository
import com.example.mymvvmretrofitproject.viewmodel.MainViewModel
import java.lang.IllegalArgumentException

class MyViewModelFactory constructor(val repository: MainRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}