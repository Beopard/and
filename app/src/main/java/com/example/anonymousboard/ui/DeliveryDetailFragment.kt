package com.example.anonymousboard.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
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

        viewModel.order.observe(viewLifecycleOwner) {
            Log.d("RESPONSE", "order.observe요${it.toString()}")
            binding.textViewDetailPrice.text=it.price
            binding.textViewDetailStartTime.text=it.start_time_detail
            binding.textViewDetailEndTime.text=it.end_time_detail
            binding.textViewDetailStartPlace.text=it.start_place_detail
            binding.textViewDetailEndPlace.text=it.end_place_detail
            binding.textViewDetailDistance.text=it.distance
            binding.textViewDetailDistanceFrom.text=it.distance_from_me
            binding.textViewDetailInfo.text=it.info
            binding.textViewDetailRequest.text=it.ord_request
            binding.textViewDetailOrdId.text=it.ord_id
            binding.textView17.text="->"

            when(it.status) {
                "운송가능" -> binding.buttonConfirm.text="운송하기"
                "픽업전" -> binding.buttonConfirm.text="운송시작"
                "운송중" -> binding.buttonConfirm.text="운송완료"
                "운송완료" -> binding.buttonConfirm.text=""
            }

            binding.buttonConfirm.setOnClickListener {
                viewModel.changeStatus(binding.textViewDetailOrdId.text.toString(),binding.buttonConfirm.text.toString())
                findNavController().popBackStack()

            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}