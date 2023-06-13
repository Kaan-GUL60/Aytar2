package com.gkaan.aytar

import android.content.Intent
import com.gkaan.aytar.databinding.ActivitySignBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.userProfileChangeRequest

class SignActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth

    private lateinit var binding: ActivitySignBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = FirebaseAuth.getInstance()

        binding.signButton.setOnClickListener {
            kayitOl()
        }


    }

    private fun kayitOl(){
        val email = binding.editTextUserGmail.text.toString()
        val sifre = binding.editTextUserPassword.text.toString()
        val kullaniciAdi = binding.editTextUserName.text.toString()

        auth.createUserWithEmailAndPassword(email,sifre).addOnCompleteListener{task ->
            //asenkron
            if(task.isSuccessful) {
                //diğer aktivitiye geç
                val guncelKullanici = auth.currentUser
                val profilGuncellemeIstedgi = userProfileChangeRequest {
                    displayName = kullaniciAdi
                }
                if (guncelKullanici != null) {
                    guncelKullanici.updateProfile(profilGuncellemeIstedgi).addOnCompleteListener{task ->
                        if (task.isSuccessful){
                            Toast.makeText(applicationContext,"Profil kullanıcı adı eklendi",Toast.LENGTH_LONG).show()
                        }
                    }
                }
                val intent = Intent(this,MainMenuActivity::class.java)
                startActivity(intent)
                finish()

            }
        }.addOnFailureListener{exception ->
            Toast.makeText(applicationContext,exception.localizedMessage, Toast.LENGTH_LONG).show()
        }

    }

}