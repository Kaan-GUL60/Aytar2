package com.gkaan.aytar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.IdRes
import com.gkaan.aytar.R.id.imageView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    private val SPLASH_DELAY: Long = 2500
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth

        val guncelKullanici = auth.currentUser

        if (guncelKullanici != null) {
            Handler().postDelayed({
                val intent = Intent(this, MainMenuActivity::class.java)
                startActivity(intent)
            }, SPLASH_DELAY)
        }
        else if (guncelKullanici == null) {
            Handler().postDelayed({
                val intent = Intent(this, SignActivity::class.java)
                startActivity(intent)
            }, SPLASH_DELAY)
        }

        /*
        Çıkış yapmak için gerekli kod

        auth.signOut()

         */
    }

}