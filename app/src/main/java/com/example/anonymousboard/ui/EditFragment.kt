package com.example.anonymousboard.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.anonymousboard.MainViewModel
import com.example.anonymousboard.databinding.EditFragmentBinding

class EditFragment : Fragment() {

    private var _binding: EditFragmentBinding?=null
    private val binding get()= _binding!!
    private val viewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= EditFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editTextEditTitle.setText(this.viewModel.post.value?.title.toString())
        binding.editTextEditContents.setText(this.viewModel.post.value?.contents.toString())

        binding.buttonEdit.setOnClickListener {
            viewModel.post.value?.let { it1 -> viewModel.updatePost(it1.post_id,binding.editTextEditTitle.text.toString(),binding.editTextEditContents.text.toString()) }
            findNavController().popBackStack()
            findNavController().popBackStack()
        }
        binding.buttonCancel.setOnClickListener {
            findNavController().popBackStack()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}