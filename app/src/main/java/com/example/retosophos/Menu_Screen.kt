package com.example.retosophos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_menu_screen.*

class Menu_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_screen)

        // ==================== metodo para pasar entre actividades ================================

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

        // =========================================================================================
        // ============================ Regresar ===================================================

        //  Enviar Documentos a moverse de opciones
        btn_send_documents.setOnClickListener{
            val intent:Intent =Intent(this, Send_documents::class.java)
            startActivity(intent)
        }

        // =========================================================================================


        /*

        // Menu de opciones

        btn_menus.setOnClickListener {
            val popup = PopupMenu( this,btn_menus)
            popup.inflate(R.menu.options)
            popup.setOnMenuItemClickListener {
                Toast.makeText(this, "Item : " + it.title,Toast.LENGTH_SHORT).show()
                true
            }
            popup.show()
        }

        // menu entre actividades

        // moverse de opciones a Enviar Documentos

        btn_menus.setOnClickListener{
            val intent:Intent =Intent(this, Send_documents::class.java)
            startActivity(intent)
        }

        // menu a Ver Documentos
        btn_view_documents.setOnClickListener{
            val intent:Intent =Intent(this, View_documents::class.java)
            startActivity(intent)
        }

        // menu a Oficinas
        btn_offices.setOnClickListener{
            val intent:Intent =Intent(this, Offices::class.java)
            startActivity(intent)
        } */
    }
}