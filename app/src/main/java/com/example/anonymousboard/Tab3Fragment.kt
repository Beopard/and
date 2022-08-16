package com.example.anonymousboard

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anonymousboard.databinding.FragmentTab1Binding
import com.example.anonymousboard.databinding.FragmentTab2Binding
import com.example.anonymousboard.databinding.FragmentTab3Binding

class Tab3Fragment : Fragment() {
    private var _binding: FragmentTab3Binding? = null
    private val binding get() = _binding!!
    private val adapter = ChatAdapter3()
    private val viewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTab3Binding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView3.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView3.adapter = adapter

        adapter.setListener{v,ordId->
            Log.d("RESPONSE", "???${ordId}")
            viewModel.getOrder(ordId)

            findNavController().navigate(R.id.action_deliveryListFragment_to_deliveryDetailFragment)
        }

        viewModel.getOrders3()
        viewModel.orders3.observe(viewLifecycleOwner) {
            Log.d("RESPONSE", "orders3.observe요${it.toString()}")
            adapter.setData(it.toMutableList())
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}