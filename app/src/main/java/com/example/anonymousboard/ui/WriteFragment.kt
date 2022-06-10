package com.example.anonymousboard.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.anonymousboard.MainViewModel
import com.example.anonymousboard.databinding.WriteFragmentBinding

class WriteFragment : Fragment() {

    private var _binding: WriteFragmentBinding?=null
    private val binding get()= _binding!!
    private val viewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= WriteFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonWrite.setOnClickListener {
            viewModel.insertPost(binding.editTextWriteTitle.text.toString(),binding.editTextWriteContents.text.toString(),binding.editTextWritePassword.text.toString())
            findNavController().popBackStack()
        }
        binding.buttonWriteCancel.setOnClickListener{
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}