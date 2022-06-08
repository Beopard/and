package com.example.anonymousboard.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.anonymousboard.R
import com.example.anonymousboard.databinding.DetailFragmentBinding
import com.example.anonymousboard.databinding.MainFragmentBinding

class DetailFragment : Fragment() {
    private var _binding: DetailFragmentBinding?=null
    private val binding get()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= DetailFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("test","test");

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}