package com.example.anonymousboard.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JsServer {
    companion object{
        private const val url = "http://10.0.2.2:8080/api/"
        var gson = GsonBuilder().setLenient().create()
        private var server:Retrofit=Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        var postApi:PostApi = server.create(PostApi::class.java)
    }
}
