package com.example.anonymousboard

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anonymousboard.api.JsServer
import com.example.anonymousboard.model.Post
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {
    val error = MutableLiveData<String>()
    val posts = MutableLiveData<List<Post>>()
    val post = MutableLiveData<Post>()
    lateinit var request: Call<Post>

    fun getPost(id:Int) = viewModelScope.launch {
        val request = JsServer.postApi.getPost(id)
        request.enqueue(object: Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                post.value = response.body()
                Log.d("RESPONSE", "Response: ${response.code()}")
            }
            override fun onFailure(call: Call<Post>, t: Throwable) {
                error.value = t.localizedMessage
                Log.d("RESPONSE", "Response: ${t.localizedMessage}")
            }
        })
    }

    fun getPosts() = viewModelScope.launch {
        val request = JsServer.postApi.getPosts()
        request.enqueue(object:Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                posts.value = response.body()
                Log.d("RESPONSE", "Response: ${response.code()}? ${posts.value}")
            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                error.value = t.localizedMessage
                Log.d("RESPONSE", "Response: ${t.localizedMessage}")
            }
        })
    }
    override fun onCleared() {
        super.onCleared()
        if(::request.isInitialized) request.cancel()
    }
}