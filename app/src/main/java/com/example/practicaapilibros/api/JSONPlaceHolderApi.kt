package com.example.practicaapilibros.api

import com.example.practicaapilibros.models.Post
import com.example.practicaapilibros.models.PostList
import retrofit2.http.GET
import retrofit2.http.Path

interface JSONPlaceHolderApi {
    @GET("posts")
    suspend fun getPostList(): PostList

    @GET("posts/{id}")
    suspend fun getPost(@Path("id") id: Int): Post


    //implementar url para libros

}