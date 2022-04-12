package com.app.xdschallenge.ui.success

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.xdschallenge.R
import com.app.xdschallenge.databinding.SuccessOrderFragmentBinding

class FinishOrderFragment : Fragment(), SuccessContrat.View {

    private var _binding: SuccessOrderFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SuccessOrderFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btnBack.setOnClickListener {
            onClickReturn()
        }
    }

    override fun onClickReturn() {
        findNavController().navigate(R.id.action_finishOrderFragment_to_productListFragment)
    }
}