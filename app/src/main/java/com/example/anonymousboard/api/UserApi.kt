package com.example.anonymousboard.api

import com.example.anonymousboard.model.Response2
import retrofit2.Call
import retrofit2.http.*

interface UserApi {


    @POST("login")
    fun login(@Query("username")username:String,@Query("password")password:String):Call<Response2>


}