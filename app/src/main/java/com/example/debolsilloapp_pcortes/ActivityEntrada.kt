package com.example.debolsilloapp_pcortes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.debolsilloapp_pcortes.databinding.ActivityEntradaBinding

class ActivityEntrada : AppCompatActivity() {

    private lateinit var binding:ActivityEntradaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEntradaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}