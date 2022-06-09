package com.example.anonymousboard.ui

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anonymousboard.ChatAdapter
import com.example.anonymousboard.MainActivity
import com.example.anonymousboard.MainViewModel
import com.example.anonymousboard.R
import com.example.anonymousboard.databinding.MainFragmentBinding
import com.example.anonymousboard.model.Post

class MainFragment : Fragment() {
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    private val adapter = ChatAdapter()
    private val viewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = adapter

        adapter.setListener{v,postId->
            Log.d("RESPONSE", "???${postId.toInt()}")
            viewModel.getPost(postId.toInt())
            findNavController().navigate(R.id.action_mainFragment_to_detailFragment)
        }
        binding.buttonSearch.setOnClickListener {
            Log.d("RESPONSE", "buttonSearch.setOnClickListener요 ${binding.editTextSearch.text.toString()}")
            viewModel.getPostsBySearch(binding.editTextSearch.text.toString())
        }
        binding.buttonGoWrite.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_writeFragment)
        }
//        binding.buttonChangeSort.setOnClickListener {
//            viewModel.
//        }

        viewModel.getPosts()
        viewModel.posts.observe(viewLifecycleOwner) {
            Log.d("RESPONSE", "?!${it.toString()}")
            adapter.setData(it.toMutableList())
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}