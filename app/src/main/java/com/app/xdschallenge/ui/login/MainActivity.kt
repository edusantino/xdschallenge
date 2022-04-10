package com.app.xdschallenge.ui.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.app.xdschallenge.R
import com.app.xdschallenge.databinding.ActivityMainBinding
import com.app.xdschallenge.databinding.SplashFragmentBinding
import com.app.xdschallenge.ui.productlist.ProductListFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
