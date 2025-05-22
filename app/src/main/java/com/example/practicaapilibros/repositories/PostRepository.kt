package com.example.practicaapilibros.repositories

import com.example.practicaapilibros.models.Post
import com.example.practicaapilibros.models.PostList

object PostRepository {
    suspend fun getPostList(): PostList {
        return RetrofitRepository
            .getJsonPlaceholderApi()
            .getPostList()
    }

    suspend fun getPost(id: Int): Post {
        return RetrofitRepository
            .getJsonPlaceholderApi()
            .getPost(id)
    }
}