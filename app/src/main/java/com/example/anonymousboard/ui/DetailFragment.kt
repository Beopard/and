package com.example.anonymousboard.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.anonymousboard.MainViewModel
import com.example.anonymousboard.R
import com.example.anonymousboard.databinding.DetailFragmentBinding

class DetailFragment : Fragment() {
    private var _binding: DetailFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textViewDetailTitle.text = this.viewModel.post.value?.title.toString()
        binding.textViewDetailContents.text = this.viewModel.post.value?.contents.toString()

        binding.buttonGoEdit.setOnClickListener {
            Log.d(
                "RESPONSE",
                "${binding.editTextTextPassword.text},${viewModel.post.value?.password}"
            )
            if (binding.editTextTextPassword.text.toString() == viewModel.post.value?.password) {
                findNavController().navigate(R.id.action_detailFragment_to_editFragment)
            }
        }
        binding.buttonDelete.setOnClickListener {
            if (binding.editTextTextPassword.text.toString() == viewModel.post.value?.password) {
                viewModel.deletePost(
                    viewModel.post.value!!.post_id,
                    viewModel.post.value!!.password
                )
                findNavController().popBackStack()
            }
        }
        viewModel.post.observe(viewLifecycleOwner) {
            Log.d("RESPONSE", "post.observe요${it.toString()}")
            binding.textViewDetailTitle.text = this.viewModel.post.value?.title.toString()
            binding.textViewDetailContents.text = this.viewModel.post.value?.contents.toString()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}