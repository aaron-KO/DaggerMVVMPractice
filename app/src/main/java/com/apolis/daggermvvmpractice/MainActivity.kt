package com.apolis.daggermvvmpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.apolis.daggermvvmpractice.databinding.ActivityMainBinding
import com.apolis.daggermvvmpractice.viewModel.ActivityViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: ActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(ActivityViewModel::class.java)
        //binding.userCredential = viewModel

        setupObservers()
    }

    private fun setupObservers() {
        viewModel.error.observe(this) {
            Toast.makeText(baseContext, it, Toast.LENGTH_LONG).show()
        }

        viewModel.success.observe(this) {
            Toast.makeText(baseContext, "Success", Toast.LENGTH_LONG).show()
        }
    }
}