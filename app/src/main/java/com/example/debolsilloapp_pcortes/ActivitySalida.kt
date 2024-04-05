package com.example.debolsilloapp_pcortes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.debolsilloapp_pcortes.databinding.ActivitySalidaBinding

class ActivitySalida : AppCompatActivity() {

    private lateinit var binding:ActivitySalidaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySalidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}