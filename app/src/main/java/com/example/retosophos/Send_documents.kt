package com.example.retosophos


import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.example.retosophos.databinding.ActivitySendDocumentsBinding
import java.io.File


class Send_documents : AppCompatActivity() {
    private lateinit var binding: ActivitySendDocumentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySendDocumentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTakePhoto.setOnClickListener {

            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).also {
                it.resolveActivity(packageManager).also { component->
                    createPhotoFile()
                    val photoUri: Uri = FileProvider.getUriForFile(this,BuildConfig.APPLICATION_ID+".fileprovider",file)
                    it.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
                }
            }
            btnTakePhoto.launch(intent)
        }
    }
    val btnTakePhoto = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data!!
            val bitmap = data.extras!!.get("data") as Bitmap
            binding.btnCamara.setImageBitmap(bitmap)
        }
    }
        private lateinit var file:File
        private fun createPhotoFile(): File {
            val dir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!
            file = File.createTempFile("IMG_${System.currentTimeMillis()}_", ".jpg", dir)
            return file;
        }


}




/*

    */

/*
    btn_menus.setOnClickListener {
        val popup = PopupMenu( this,btn_menus)
        popup.inflate(R.menu.options)
        popup.setOnMenuItemClickListener {
            Toast.makeText(this, "Item : " + it.title, Toast.LENGTH_SHORT).show()
            true
        }
        popup.show()
    }

    // moverse de opciones a Oficinas
 menu. .setOnClickListener{
        val intent:Intent =Intent(this, Offices::class.java)
        startActivity(intent)
    }



    // moverse de opciones a Ver Documentos
    btn_view_documents.setOnClickListener{
        val intent:Intent =Intent(this, View_documents::class.java)
        startActivity(intent)
    }

// moverse de enviar documentos a de opciones
    btn_return_send_doc.setOnClickListener{
        val intent: Intent = Intent(this, Menu_Screen::class.java)
        startActivity(intent)
    } */

        // Funcionamiento camara



