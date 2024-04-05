package com.example.debolsilloapp_pcortes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.debolsilloapp_pcortes.databinding.ActivityInventarioBinding

class ActivityInventario : AppCompatActivity() {

    private lateinit var binding:ActivityInventarioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInventarioBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}