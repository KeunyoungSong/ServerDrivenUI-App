package com.example.serverdrivenui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.serverdrivenui.adapter.ListAdapter
import com.example.serverdrivenui.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val adapter by lazy { ListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() = with(binding) {
        // 임시 연결
        recyclerView.adapter = adapter
    }
}