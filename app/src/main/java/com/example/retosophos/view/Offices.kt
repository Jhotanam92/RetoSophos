package com.example.retosophos.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retosophos.R
import com.example.retosophos.databinding.ActivityOfficesBinding
import com.example.retosophos.databinding.ActivitySendDocumentsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_offices.*

    private lateinit var maps:GoogleMap

class Offices : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityOfficesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOfficesBinding.inflate(layoutInflater)
        setContentView(binding.root)

//=====================================  Regresar  =================================================
        //
        btn_return_offices_doc.setOnClickListener{
            val intent: Intent = Intent(this, Menu_Screen::class.java)
            startActivity(intent)
        }
//==================================================================================================
//==================================  Google Maps  =================================================

     fun createFragment(){
            val mapFragment : SupportMapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
            mapFragment.getMapAsync(this)
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        maps = googleMap
        createMarket()
    }

    private fun createMarket() {
        val centro_bogota = LatLng(4.6121414,-74.0704357)

        maps.addMarker(MarkerOptions().position(centro_bogota).title("Sophos Solutions sede centro - Bogota"))
        maps.moveCamera(CameraUpdateFactory.newLatLng(centro_bogota))
        maps.animateCamera(CameraUpdateFactory.newLatLng(centro_bogota),4000,null)

        val bogota_chapinero = LatLng(4.6562206,-74.0617085)
        maps.addMarker(MarkerOptions().position(bogota_chapinero).title("Sophos Solutions sede Chapinero - Bogota"))
        maps.moveCamera(CameraUpdateFactory.newLatLng(bogota_chapinero))
        maps.animateCamera(CameraUpdateFactory.newLatLng(bogota_chapinero),4000,null)

        val sede_medellin = LatLng(6.2182289,-75.5831817)
        maps.addMarker(MarkerOptions().position(sede_medellin).title("Sophos Solutions Medellin"))
        maps.moveCamera(CameraUpdateFactory.newLatLng(sede_medellin))
        maps.animateCamera(CameraUpdateFactory.newLatLng(sede_medellin),4000,null)
//==================================================================================================

    }
}