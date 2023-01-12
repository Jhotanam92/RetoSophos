package com.example.retosophos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_offices.*
import kotlinx.android.synthetic.main.activity_view_documents.*

class View_documents : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_documents)

        // moverse de ver documentos a opciones
        btn_return_view_doc.setOnClickListener {
            val intent: Intent = Intent(this, Menu_Screen::class.java)
            startActivity(intent)
        }
    }
}