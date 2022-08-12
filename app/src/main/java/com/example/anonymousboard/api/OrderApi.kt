package com.example.anonymousboard.api

import com.example.anonymousboard.model.Order
import com.example.anonymousboard.model.Post
import retrofit2.Call
import retrofit2.http.*

interface OrderApi {


    @GET("duser/orders/{user_id}")
    fun getOrders(@Path("user_id")user_id:String): Call<List<Order>>
//
//    @GET("postsViews")
//    fun getPostsViews(): Call<List<Post>>
//
//    @GET("post/{id}")
//    fun getPost(@Path("id")id:String):Call<Post>
//
//    @GET("postSearch")
//    fun getPostsBySearch(@Query("title")title:String):Call<List<Post>>
//
//    @POST("post")
//    fun insertPost(@Query("title")title:String,@Query("contents")contents:String,@Query("password")password:String):Call<String>
//
//    @PUT("post/{id}")
//    fun updatePost(@Path("id")id:String,@Query("title")title:String,@Query("contents")contents:String):Call<String>
//
//    @DELETE("post/{id}")
//    fun deletePost(@Path("id")id:String,@Query("password")password:String):Call<String>


}