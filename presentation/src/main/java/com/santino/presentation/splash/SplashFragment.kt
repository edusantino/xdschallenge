package com.santino.presentation.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.app.xdschallenge.R
import com.app.xdschallenge.databinding.SplashFragmentBinding
import java.lang.Thread.sleep

class SplashFragment : Fragment() {

    private lateinit var binding: SplashFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SplashFragmentBinding.inflate(layoutInflater)
        val view = inflater.inflate(R.layout.splash_fragment, container, false)

        view.postDelayed({
            Navigation.findNavController(view).navigate(R.id.action_splashScreenFragment_to_productListFragment)
        }, 2000)

        return view
    }
}