package com.example.debolsilloapp_pcortes

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.debolsilloapp_pcortes.databinding.ActivityParametrosBinding

class ActivityParametros : AppCompatActivity() {

    private lateinit var binding: ActivityParametrosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParametrosBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}