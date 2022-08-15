package com.example.anonymousboard.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.activityViewModels
import com.example.anonymousboard.MainViewModel
import com.example.anonymousboard.R
import com.example.anonymousboard.databinding.FragmentDeliveryDetailBinding
import com.example.anonymousboard.databinding.FragmentJoinBinding

class DeliveryDetailFragment : Fragment() {

    private var _binding: FragmentDeliveryDetailBinding?=null
    private val binding get()= _binding!!
    private val viewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentDeliveryDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.webView.webViewClient= WebViewClient()
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl("https://www.google.co.kr/maps/?hl=ko")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}