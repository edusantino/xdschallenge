package com.app.xdschallenge.ui.success

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.app.xdschallenge.databinding.SuccessOrderFragmentBinding
import com.app.xdschallenge.ui.productlist.ProductListFragment

class FinishOrderFragment : AppCompatActivity(), SuccessContrat.View {

    private lateinit var binding: SuccessOrderFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SuccessOrderFragmentBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
    }

    override fun onStart() {
        super.onStart()
        binding.btnVoltar.setOnClickListener {
            onClickReturn()
        }
    }

    override fun onClickReturn() {
        startActivity(Intent(this, ProductListFragment::class.java))
    }
}