package com.example.anonymousboard.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class JsServer {
    companion object{
        private const val url = "http://10.30.3.45:8000/api/"
        var gson = GsonBuilder().setLenient().create()
        private var server:Retrofit=Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        var postApi:PostApi = server.create(PostApi::class.java)
        var userApi:UserApi = server.create(UserApi::class.java)
        var orderApi:OrderApi = server.create(OrderApi::class.java)
    }
}
