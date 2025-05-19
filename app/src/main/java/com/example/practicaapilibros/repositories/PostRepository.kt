package com.example.practicaapilibros.repositories

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