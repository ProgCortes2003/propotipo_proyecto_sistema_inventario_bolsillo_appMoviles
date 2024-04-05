package com.example.debolsilloapp_pcortes

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.debolsilloapp_pcortes.databinding.ActivityVentanaPrincipalBinding

class ActivityVentanaPrincipal : AppCompatActivity() {

    private lateinit var binding: ActivityVentanaPrincipalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVentanaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEntrada.setOnClickListener {
            startActivity(Intent(this@ActivityVentanaPrincipal, ActivityEntrada::class.java))
        }

        binding.btnSalida.setOnClickListener {
            startActivity(Intent(this@ActivityVentanaPrincipal, ActivitySalida::class.java))
        }

        binding.btnInventario.setOnClickListener {
            startActivity(Intent(this@ActivityVentanaPrincipal, ActivityInventario::class.java))
        }

        binding.btnKardex.setOnClickListener {
            startActivity(Intent(this@ActivityVentanaPrincipal,ActivityKardex::class.java))
        }

        binding.btnParametros.setOnClickListener {
            startActivity(Intent(this@ActivityVentanaPrincipal, ActivityParametros::class.java))
        }

    }


}