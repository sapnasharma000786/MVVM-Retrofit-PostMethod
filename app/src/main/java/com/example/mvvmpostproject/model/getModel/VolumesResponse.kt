package com.example.mymvvmretrofitproject.model1.getModel

data class VolumesResponse (
    val items: List<Item>,
    val kind: String,
    val totalItems: Int
)