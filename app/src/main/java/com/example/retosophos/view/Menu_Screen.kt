package com.example.retosophos.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retosophos.R
import com.example.retosophos.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_menu_screen.*

class Menu_Screen : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//============================ metodo para pasar entre actividades =================================

        // moverse de opciones a Enviar Documentos
        btn_send_documents.setOnClickListener{
            val intent:Intent =Intent(this, Send_documents::class.java)
            startActivity(intent)
        }

        // moverse de opciones a Ver Documentos
        btn_view_documents.setOnClickListener{
            val intent:Intent =Intent(this, View_documents::class.java)
            startActivity(intent)
        }

        // moverse de opciones a Oficinas
        btn_offices.setOnClickListener{
            val intent:Intent =Intent(this, Offices::class.java)
            startActivity(intent)
        }

//==================================================================================================
//===================================== Regresar ===================================================

        //  Enviar Documentos a moverse de opciones
        btn_send_documents.setOnClickListener{
            val intent:Intent =Intent(this, Send_documents::class.java)
            startActivity(intent)
        }

//==================================================================================================

    }
}