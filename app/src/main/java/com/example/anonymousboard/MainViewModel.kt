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
    val order = MutableLiveData<Order>()
    val orders1 = MutableLiveData<List<Order>>()
    val orders2 = MutableLiveData<List<Order>>()
    val orders22 = MutableLiveData<List<Order>>()
    val orders3 = MutableLiveData<List<Order>>()
    lateinit var request: Call<Post>

    fun getOrder(id: String) = viewModelScope.launch {
        val request = JsServer.orderApi.getOrder(id)
        request.enqueue(object : Callback<Order> {
            override fun onResponse(call: Call<Order>, response: Response<Order>) {
                order.value = response.body()
                Log.d("RESPONSE", "getOrder요: ${response.code()} ${order.value}")
            }

            override fun onFailure(call: Call<Order>, t: Throwable) {
                error.value = t.localizedMessage
                Log.d("RESPONSE", "getOrder에러요: ${t.localizedMessage}")
            }
        })
    }


    fun getOrders1() = viewModelScope.launch {
        val request = JsServer.orderApi.getOrders1()
        request.enqueue(object : Callback<List<Order>> {
            override fun onResponse(call: Call<List<Order>>, response: Response<List<Order>>) {
                orders1.value = response.body()
//                for(item in orders1.value!!) {
//                    Log.d("RESPONSE", "getOrders1요: ${item}")
//                }
                Log.d("RESPONSE", "getOrders1요: ${response.code()} ${orders1.value}")
            }

            override fun onFailure(call: Call<List<Order>>, t: Throwable) {
                error.value = t.localizedMessage
                Log.d("RESPONSE", "getOrders1요에러요: ${t.localizedMessage}")
            }
        })
    }

    fun getOrders2() = viewModelScope.launch {
        val request = JsServer.orderApi.getOrders2()
        request.enqueue(object : Callback<List<Order>> {
            override fun onResponse(call: Call<List<Order>>, response: Response<List<Order>>) {
                orders2.value = response.body()
//                for(item in orders2.value!!) {
//                    Log.d("RESPONSE", "getOrders2요: ${item}")
//                }
                Log.d("RESPONSE", "getOrders2요: ${response.code()} ${orders2.value}")
            }

            override fun onFailure(call: Call<List<Order>>, t: Throwable) {
                error.value = t.localizedMessage
                Log.d("RESPONSE", "getOrders2요에러요: ${t.localizedMessage}")
            }
        })
    }

    fun getOrders22() = viewModelScope.launch {
        val request = JsServer.orderApi.getOrders22()
        request.enqueue(object : Callback<List<Order>> {
            override fun onResponse(call: Call<List<Order>>, response: Response<List<Order>>) {
                orders22.value = response.body()
//                for(item in orders22.value!!) {
//                    Log.d("RESPONSE", "getOrders22요: ${item}")
//                }
                Log.d("RESPONSE", "getOrders22요: ${response.code()} ${orders22.value}")
            }

            override fun onFailure(call: Call<List<Order>>, t: Throwable) {
                error.value = t.localizedMessage
                Log.d("RESPONSE", "getOrders22요에러요: ${t.localizedMessage}")
            }
        })
    }

    fun getOrders3() = viewModelScope.launch {
        val request = JsServer.orderApi.getOrders3()
        request.enqueue(object : Callback<List<Order>> {
            override fun onResponse(call: Call<List<Order>>, response: Response<List<Order>>) {
                orders3.value = response.body()
//                for(item in orders3.value!!) {
//                    Log.d("RESPONSE", "getOrders3요: ${item}")
//                }
                Log.d("RESPONSE", "getOrders3요: ${response.code()} ${orders3.value}")
            }

            override fun onFailure(call: Call<List<Order>>, t: Throwable) {
                error.value = t.localizedMessage
                Log.d("RESPONSE", "getOrders3요에러요: ${t.localizedMessage}")
            }
        })
    }

    fun changeStatus(id:String,status:String) = viewModelScope.launch {
        val request = JsServer.orderApi.changeStatus(id,status)
        request.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.d("RESPONSE", "changeStatus요: ${response.code()} ${response.body()}")
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                error.value = t.localizedMessage
                Log.d("RESPONSE", "changeStatus요에러요: ${t.localizedMessage}")
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