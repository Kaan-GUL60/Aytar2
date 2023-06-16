package com.gkaan.aytar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gkaan.aytar.databinding.FragmentMuzeDetayBinding
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase


class muzeDetayFragment : Fragment() {
    private var _binding: FragmentMuzeDetayBinding? = null
    private val binding get() = _binding!!
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMuzeDetayBinding.inflate(inflater, container, false)
        val view = binding.root

        val mKod = arguments?.getString("mKod").toString()

        database = Firebase.database.reference
        binding.biletAlButton.setOnClickListener {
            findNavController().navigate(R.id.action_muzeDetayFragment_to_satinAlMuzeFragment)
        }
        if (mKod == "m1") {
            readDataFromFirebase(mKod)
        }else if(mKod == "m2"){
            readDataFroFirebase(mKod)
        }
        else {
            readMKod(mKod)
        }

        binding.returnButton.setOnClickListener {
            findNavController().navigate(R.id.action_muzeDetayFragment_to_muzeAraFragment)
        }
        return view
    }

    private fun readMKod(m: String) {
        database.child("muzeler").child(m).child("muzeAdi").get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val data = task.result?.value // Gelen değeri al
                binding.textView6.text = "buaray geldi"

                // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                if (data != null) {
                    val muzeAdi = data.toString()
                    binding.muzeAdi.text = muzeAdi
                }
            } else {
                val exception = task.exception
                binding.textView6.text = "veri tabanı hatası"
                // Hata durumunda yapılacak işlemler
                // Örneğin: exception?.message ile hata mesajını alabilirsiniz
            }
        }
    }

    private fun readDataFromFirebase(tag: String) {
        val database =
            FirebaseDatabase.getInstance("https://aytar-f4152-default-rtdb.europe-west1.firebasedatabase.app")

        val ref = database.getReference(tag)

        val getData = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                val databases = database.reference
                databases.child("selam").child("kullaniciBilgi").setValue("kullanıcıyım ben selam")

                val tester = snapshot.child("selam").child("kullaniciBilgi").value.toString()
                binding.textView8.text = tester
                val muzeIsmi = snapshot.child("muzeler").child(tag).child("muzeAdi").value as String
                val muzeHakkinda = snapshot.child("muzeler").child(tag).child("muzeHakkinda").value as String


                binding.muzeAdi.text = muzeIsmi
                binding.textView6.text = muzeHakkinda
            }

            override fun onCancelled(error: DatabaseError) {
                //iptal durumu
                binding.textView6.text = "veri tabanı hatası"
            }
        }
        ref.addValueEventListener(getData)

    }

    private fun readDataFroFirebase(tag: String) {
        var getData = object : ValueEventListener {   //object in üstüne tıkla implement et
            override fun onDataChange(snapshot: DataSnapshot) {
                var sb = StringBuilder() //metin birlerşitrme sınıfı
                for (i in snapshot.children) {
                    var pdsıyad = i.child("muzeler").child(tag).child("muzeAdi").value.toString()
                    var pdenem = i.child("muzeler").child(tag).child("muzeHakkinda").value.toString()
                    sb.append("${i.key} ${pdsıyad} ${pdenem} \n")
                }
                binding.textView8.text = sb


            }

            override fun onCancelled(error: DatabaseError) {
                binding.textView8.text = "acayip hata var"
            }
        }
        database.addValueEventListener(getData)
    }
}
