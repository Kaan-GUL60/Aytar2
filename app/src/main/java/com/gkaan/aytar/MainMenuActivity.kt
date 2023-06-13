package com.gkaan.aytar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.gkaan.aytar.databinding.ActivityMainMenuBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainMenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainMenuBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = Firebase.auth

        val test = auth.currentUser


        val guncelKullanici = auth.currentUser!!.displayName


        binding.userNameText.text = guncelKullanici.toString()
        try {
            binding.LayProfil.setOnClickListener {
                val intent = Intent(this,ProfilActivity::class.java)
                startActivity(intent)
            }
            binding.LayMuzeAra.setOnClickListener {
                val intente = Intent(this,MuzeActivity::class.java)
                startActivity(intente)
            }
            binding.LayMapSistem.setOnClickListener {
                val intent = Intent(this,HaritaSistemiActivity::class.java)
                startActivity(intent)
            }
            binding.LayCuzdanim.setOnClickListener {
                val intent = Intent(this,SanalParaActivity::class.java)
                startActivity(intent)
            }
        }catch (e: Exception){
            Toast.makeText(applicationContext,"Bir hata oluştu: "  + e.localizedMessage, Toast.LENGTH_LONG).show()
            e.localizedMessage?.let { Log.d("Error screen", it) }
        }


    }




}