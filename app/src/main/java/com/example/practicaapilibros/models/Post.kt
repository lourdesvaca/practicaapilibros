package com.example.practicaapilibros.models

import com.google.gson.annotations.SerializedName

typealias PostList = ArrayList<Post>

data class Post (
    @SerializedName("bookId")
    val bookID: Int,
    val nombre: String,
    val autor: String,
    val editorial: String,
    val imagen: Int,
    val sinopsis: String,
    val isbn: String,
    val calificacion: Int,
    //val generos: Int
)


