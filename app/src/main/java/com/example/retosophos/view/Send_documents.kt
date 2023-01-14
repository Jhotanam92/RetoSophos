package com.example.retosophos.view


import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.retosophos.R
import com.example.retosophos.databinding.ActivitySendDocumentsBinding
import kotlinx.android.synthetic.main.activity_send_documents.*
import java.io.File


class Send_documents : AppCompatActivity() {
    private lateinit var binding: ActivitySendDocumentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySendDocumentsBinding.inflate(layoutInflater)
        setContentView(binding.root)


//====================================  Regresar  ==================================================

        //  Enviar Documentos al menu de opciones
        binding.btnReturnSendDoc.setOnClickListener {
            val intent: Intent = Intent(this, Menu_Screen::class.java)
            startActivity(intent)
        }

//==============================   Tomar Foto  ==================================================

        val btn_upload_photo = findViewById<Button>(R.id.btn_upload_photo)

        btn_take_photo.setOnClickListener {
            startForResult.launch(Intent(Intent(MediaStore.ACTION_IMAGE_CAPTURE)))
        }

//==================================================================================================
//==============================   Cargar imagen  ==================================================
        binding.btnUploadPhoto.setOnClickListener { requestPermissions() }
    }

    private fun requestPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            when {
                ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                )
                        == PackageManager.PERMISSION_GRANTED -> {
                    pickPhotoFromGallery()
                }
                else -> requestPermissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        } else {
            pickPhotoFromGallery()
        }
    }

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->

        if (isGranted) {
            pickPhotoFromGallery()
        } else {
            Toast.makeText(this, "You need to  enable the permission", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private val starForActivityGallery = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data?.data
            binding.btnCamara.setImageURI(data)
        }
    }

    private fun pickPhotoFromGallery() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        starForActivityGallery.launch(intent)
    }

    val btnTakePhoto =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data!!
                val bitmap = data.extras!!.get("data") as Bitmap
                binding.btnCamara.setImageBitmap(bitmap)
            }
        }

    private lateinit var file: File
    private fun createPhotoFile(): File {
        val dir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!
        file = File.createTempFile("IMG_${System.currentTimeMillis()}_", ".jpg", dir)
        return file;
    }
//==================================================================================================
//==============================  Sigue tomar foto  ================================================

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->

            if (result.resultCode == Activity.RESULT_OK) {

                val intent = result.data
                val imageBitmap = intent?.extras?.get("data") as Bitmap
                val btn_camara = findViewById<ImageView>(R.id.btn_camara)
                btn_camara.setImageBitmap(imageBitmap)
            }
        }
}

