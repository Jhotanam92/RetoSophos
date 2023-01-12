package com.example.retosophos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // metodo para pasar entre actividades

        // Ir a las opciones con boton de login
        btn_login_screen.setOnClickListener {
            val intent:Intent = Intent(this, Menu_Screen::class.java)
            startActivity(intent)
            finish()
        }

        // Ir a las opciones con boton de login en huella

        btn_fingerprint.setOnClickListener {
            val intent:Intent = Intent(this, Menu_Screen::class.java)
            startActivity(intent)
            finish()
        }
    }
}