package com.example.retosophos.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.retosophos.R
import com.example.retosophos.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {


    lateinit var etemail: EditText
    lateinit var etpassword: EditText
    lateinit var btn_login_screen: Button
    lateinit var btn_fingerprint: Button
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//================================= Biometrico =====================================================
//==================================================================================================

//============================================== login =============================================


        etemail=findViewById(R.id.etemail)
        etpassword = findViewById(R.id.etpassword)
        btn_login_screen = findViewById(R.id.btn_login_screen)
        btn_fingerprint = findViewById(R.id.btn_fingerprint)

        btn_login_screen.setOnClickListener{

        if (etemail.text.toString().length == 0)
            Toast.makeText( this, "Ingrese el Usuario", Toast.LENGTH_SHORT).show()
        if (etpassword.text.toString().length == 0)
            Toast.makeText( this,"Ingrese la Contrasema", Toast.LENGTH_SHORT).show()
        if(etemail.text.toString() == "jhonatan@hotmail.com" && etpassword.text.toString() == "123456")
            Toast.makeText( this,"el usuario o la contraseña son incorrectos", Toast.LENGTH_SHORT).show()

//==================================================================================================
//=====================  metodo para pasar entre actividades =======================================

        // Ir a las opciones con boton de login
           btn_login_screen.setOnClickListener {
            val intent: Intent = Intent(this, Menu_Screen::class.java)
            startActivity(intent)
            finish()
        }
        // Ir a las opciones con boton de login en huella

        btn_fingerprint.setOnClickListener {
            val intent: Intent = Intent(this, Menu_Screen::class.java)
            startActivity(intent)
            finish()
        }
      }
//==================================================================================================
    }
}

