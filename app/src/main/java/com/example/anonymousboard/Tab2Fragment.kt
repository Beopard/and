package com.example.anonymousboard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anonymousboard.databinding.FragmentTab2Binding

class Tab2Fragment : Fragment() {
    private var _binding: FragmentTab2Binding? = null
    private val binding get() = _binding!!
    private val adapter = ChatAdapter2()
    private val adapter22 = ChatAdapter22()
    private val viewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTab2Binding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView2.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView2.adapter = adapter

        binding.recyclerView22.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView22.adapter = adapter22


        adapter.setListener{v,ordId->
            Log.d("RESPONSE", "???${ordId}")
            viewModel.getOrder(ordId)

            findNavController().navigate(R.id.action_deliveryListFragment_to_deliveryDetailFragment)
        }
        adapter22.setListener{v,ordId->
            Log.d("RESPONSE", "???${ordId}")
            viewModel.getOrder(ordId)

            findNavController().navigate(R.id.action_deliveryListFragment_to_deliveryDetailFragment)
        }

        viewModel.getOrders2()
        viewModel.orders2.observe(viewLifecycleOwner) {
            Log.d("RESPONSE", "orders2.observe요${it.toString()}")
            adapter22.setData(it.toMutableList())
        }
        viewModel.getOrders22()
        viewModel.orders22.observe(viewLifecycleOwner) {
            Log.d("RESPONSE", "orders22.observe요${it.toString()}")
            adapter.setData(it.toMutableList())
        }





    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}