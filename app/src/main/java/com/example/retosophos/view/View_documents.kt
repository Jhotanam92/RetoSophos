package com.example.retosophos.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retosophos.R
import com.example.retosophos.databinding.ActivitySendDocumentsBinding
import com.example.retosophos.databinding.ActivityViewDocumentsBinding
import kotlinx.android.synthetic.main.activity_view_documents.*

    private lateinit var binding: ActivityViewDocumentsBinding

class View_documents : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewDocumentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // moverse de ver documentos a opciones
        btn_return_view_doc.setOnClickListener {
            val intent: Intent = Intent(this, Menu_Screen::class.java)
            startActivity(intent)
        }
    }
}