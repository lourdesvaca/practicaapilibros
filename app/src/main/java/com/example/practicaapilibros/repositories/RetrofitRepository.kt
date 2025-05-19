package com.example.practicaapilibros.repositories

import com.example.practicaapilibros.api.JSONPlaceHolderApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitRepository {
    fun getJsonPlaceholderApi(): JSONPlaceHolderApi {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JSONPlaceHolderApi::class.java)
    }
}
