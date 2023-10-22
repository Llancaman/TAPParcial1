package com.example.tapprimerparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var tvnombreDetail: TextView
    private lateinit var ivImagen: ImageView
    private lateinit var listView: ListView
    private lateinit var btnVolver: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val comida = intent.getParcelableExtra<Comida>("comida")

        tvnombreDetail = findViewById(R.id.tv_nombre_detail)
        listView = findViewById(R.id.lv_ingredientes)
        ivImagen = findViewById(R.id.iv_imagen_detail)
        tvnombreDetail.text = comida?.nombre
        btnVolver= findViewById(R.id.button_detail)

        Glide.with(this).load(comida?.logo).into(ivImagen)

        btnVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}