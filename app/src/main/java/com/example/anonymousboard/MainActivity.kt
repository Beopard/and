package com.example.anonymousboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anonymousboard.databinding.ActivityMainBinding
import com.example.anonymousboard.model.Post

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<MainViewModel>()
    private val adapter = ChatAdapter()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        Log.d("test","test");
////        viewModel.posts.observe(this){
////            Log.d("RESPONSE","${it.toString()}")
////            adapter.setData(it as MutableList<Post>)
////        }
//        viewModel.getPost(2)


    }
}