package com.example.anonymousboard.api

import com.example.anonymousboard.model.Order
import com.example.anonymousboard.model.Post
import retrofit2.Call
import retrofit2.http.*

interface OrderApi {

    @GET("duser/{id}")
    fun getOrder(@Path("id")id:String):Call<Order>

    @GET("duser/orders1")
    fun getOrders1(): Call<List<Order>>

    @GET("duser/orders2")
    fun getOrders2(): Call<List<Order>>

    @GET("duser/orders22")
    fun getOrders22(): Call<List<Order>>

    @GET("duser/orders3")
    fun getOrders3(): Call<List<Order>>

    @PUT("duser/change/{id}")
    fun changeStatus(@Path("id")id:String,@Query("status")title:String): Call<String>
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