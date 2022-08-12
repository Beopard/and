package com.example.anonymousboard

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anonymousboard.api.JsServer
import com.example.anonymousboard.model.Order
import com.example.anonymousboard.model.Post
import com.example.anonymousboard.model.Response2
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    val error = MutableLiveData<String>()
    val posts = MutableLiveData<List<Post>>()
    val post = MutableLiveData<Post>()
    val orders = MutableLiveData<List<Order>>()
    lateinit var request: Call<Post>

    fun getOrders(user_id: String) = viewModelScope.launch {
        val request = JsServer.orderApi.getOrders(user_id)
        request.enqueue(object : Callback<List<Order>> {
            override fun onResponse(call: Call<List<Order>>, response: Response<List<Order>>) {
                orders.value = response.body()
                for(item in orders.value!!) {
                    Log.d("RESPONSE", "getOrders요: ${item}")
                }
                Log.d("RESPONSE", "getOrders요: ${response.code()} ${orders.value}")
            }

            override fun onFailure(call: Call<List<Order>>, t: Throwable) {
                error.value = t.localizedMessage
                Log.d("RESPONSE", "getOrders요에러요: ${t.localizedMessage}")
            }
        })
    }


    fun attemptLogin(id: String,password:String) = viewModelScope.launch {
        val request = JsServer.userApi.login(id,password)
        request.enqueue(object : Callback<Response2> {

            override fun onResponse(call: Call<Response2>, response: Response<Response2>) {
                Log.d("RESPONSE", "login요: ${response}")
            }

            override fun onFailure(call: Call<Response2>, t: Throwable) {
                Log.d("RESPONSE", "login에러요: ${t.localizedMessage}")
            }
        })
    }


    fun getPost(id: String) = viewModelScope.launch {
        val request = JsServer.postApi.getPost(id)
        request.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                post.value = response.body()
                Log.d("RESPONSE", "getPost요: ${response.code()} ${post.value}")
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                error.value = t.localizedMessage
                Log.d("RESPONSE", "getPost에러요: ${t.localizedMessage}")
            }
        })
    }

    fun getPosts() = viewModelScope.launch {
        val request = JsServer.postApi.getPosts()
        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                posts.value = response.body()
                Log.d("RESPONSE", "getPosts요: ${response.code()}? ${posts.value}")
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                error.value = t.localizedMessage
                Log.d("RESPONSE", "getPosts에러요: ${t.localizedMessage}")
            }
        })
    }

    fun getPostsViews() = viewModelScope.launch {
        val request = JsServer.postApi.getPostsViews()
        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                posts.value = response.body()
                Log.d("RESPONSE", "getPostsViews요: ${response.code()}? ${posts.value}")
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                error.value = t.localizedMessage
                Log.d("RESPONSE", "getPostsViews에러요: ${t.localizedMessage}")
            }
        })
    }


    fun getPostsBySearch(title:String) = viewModelScope.launch {
        val request = JsServer.postApi.getPostsBySearch(title)
        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                posts.value = response.body()
                Log.d("RESPONSE", "getPostsBySearch요: ${response.code()}? ${posts.value}")
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                error.value = t.localizedMessage
                Log.d("RESPONSE", "getPostsBySearch에러요: ${t.localizedMessage}")
            }
        })
    }

    fun insertPost(title: String,contents:String,password:String) = viewModelScope.launch {
        val request = JsServer.postApi.insertPost(title,contents,password)
        request.enqueue(object : Callback<String> {

            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.d("RESPONSE", "insertPost요: ${response}")
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d("RESPONSE", "insertPost에러요: ${t.localizedMessage}")
            }
        })
    }

    fun updatePost(post_id:String,title: String,contents:String) = viewModelScope.launch {
        val request = JsServer.postApi.updatePost(post_id,title,contents)
        request.enqueue(object : Callback<String> {

            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.d("RESPONSE", "updatePost요: ${response}")
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d("RESPONSE", "updatePost에러요: ${t.localizedMessage}")
            }
        })
    }

    fun deletePost(id:String,password: String) = viewModelScope.launch {
        val request = JsServer.postApi.deletePost(id,password)
        request.enqueue(object : Callback<String> {

            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.d("RESPONSE", "deletePost요: ${response}")
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d("RESPONSE", "deletePost에러요: ${t.localizedMessage}")
            }
        })
    }



    override fun onCleared() {
        super.onCleared()
        if (::request.isInitialized) request.cancel()
    }
}