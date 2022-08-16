package com.example.anonymousboard

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anonymousboard.databinding.FragmentTab1Binding

class Tab1Fragment : Fragment() {
    private var _binding: FragmentTab1Binding? = null
    private val binding get() = _binding!!
    private val adapter = ChatAdapter()
    private val viewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTab1Binding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView1.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView1.adapter = adapter

        adapter.setListener{v,ordId->
            Log.d("RESPONSE", "ordid???${ordId}")
            viewModel.getOrder(ordId)

            findNavController().navigate(R.id.action_deliveryListFragment_to_deliveryDetailFragment)
        }

        viewModel.getOrders1()
        viewModel.orders1.observe(viewLifecycleOwner) {
            Log.d("RESPONSE", "orders1.observe요${it.toString()}")
            adapter.setData(it.toMutableList())
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}