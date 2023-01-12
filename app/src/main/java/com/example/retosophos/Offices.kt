package com.example.retosophos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu_screen.*
import kotlinx.android.synthetic.main.activity_offices.*

class Offices : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offices)

        // moverse de Oficinas a de opciones
        btn_return_offices_doc.setOnClickListener{
            val intent: Intent = Intent(this, Menu_Screen::class.java)
            startActivity(intent)
        }
    }
}