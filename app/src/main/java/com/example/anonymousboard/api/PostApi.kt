package com.example.anonymousboard.api

import com.example.anonymousboard.model.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApi {
    @GET("posts")
    fun getPosts(): Call<List<Post>>

    @GET("post/{id}")
    fun getPost(@Path("id")id:Int):Call<Post>
}