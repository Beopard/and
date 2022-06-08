package com.example.anonymousboard.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JsServer {
    companion object{
        private const val url = "http://10.30.3.45:8080/api/"
        private var server:Retrofit=Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var postApi:PostApi = server.create(PostApi::class.java)
    }
}
