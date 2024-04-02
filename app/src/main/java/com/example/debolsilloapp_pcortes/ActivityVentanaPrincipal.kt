package com.example.debolsilloapp_pcortes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.debolsilloapp_pcortes.databinding.ActivityVentanaPrincipalBinding

class ActivityVentanaPrincipal : AppCompatActivity() {

    private lateinit var binding: ActivityVentanaPrincipalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVentanaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}