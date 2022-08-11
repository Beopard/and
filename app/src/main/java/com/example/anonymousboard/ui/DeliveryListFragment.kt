package com.example.anonymousboard.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.anonymousboard.MainViewModel
import com.example.anonymousboard.R
import com.example.anonymousboard.ViewPagerAdapter
import com.example.anonymousboard.databinding.FragmentDeliveryListBinding
import com.example.anonymousboard.databinding.FragmentJoinBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DeliveryListFragment : Fragment() {

    private var _binding: FragmentDeliveryListBinding?=null
    private val binding get()= _binding!!
    private val viewModel by activityViewModels<MainViewModel>()

    private val tabTitleArray = arrayOf(
        "Tab1",
        "Tab2",
        "Tab3"
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentDeliveryListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPager.adapter = ViewPagerAdapter(childFragmentManager,lifecycle)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}