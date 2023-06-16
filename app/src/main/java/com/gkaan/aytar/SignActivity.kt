package com.gkaan.aytar

import android.content.Intent
import com.gkaan.aytar.databinding.ActivitySignBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.database.FirebaseDatabase

class SignActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    var database = FirebaseDatabase.getInstance().reference //"https://aytar-f4152-default-rtdb.europe-west1.firebasedatabase.app"

    private lateinit var binding: ActivitySignBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = FirebaseAuth.getInstance()




        binding.signButton.setOnClickListener {
            kayitOl()
            savedDatabase()

        }
        binding.changeLoginButton.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
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
                savedDatabase()
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
    private fun savedDatabase(){
        val email = binding.editTextUserGmail.text.toString()
        val sifre = binding.editTextUserPassword.text.toString()
        val image= "null"
        val pSanalBakiye = 100 //varsayılan olarak
        val kullaniciAdi = binding.editTextUserName.text.toString()
        val asd = auth.currentUser?.uid.toString()
        database.child("kullanicilar").child(asd).setValue(saveUser(kullaniciAdi,asd,sifre,email,image,pSanalBakiye))
    }

}