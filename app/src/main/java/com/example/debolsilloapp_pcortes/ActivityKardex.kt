package com.example.debolsilloapp_pcortes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.debolsilloapp_pcortes.databinding.ActivityKardexBinding

class ActivityKardex : AppCompatActivity() {

    private lateinit var binding:ActivityKardexBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityKardexBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}