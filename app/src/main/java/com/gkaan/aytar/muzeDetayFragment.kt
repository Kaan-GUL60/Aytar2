package com.gkaan.aytar

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.gkaan.aytar.databinding.FragmentMuzeDetayBinding
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage


class muzeDetayFragment : Fragment() {
    private var _binding: FragmentMuzeDetayBinding? = null
    private val binding get() = _binding!!
    private lateinit var database: DatabaseReference
    private lateinit var storage: FirebaseStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMuzeDetayBinding.inflate(inflater, container, false)
        val view = binding.root

        val mKod = arguments?.getString("mKod").toString()

        hadiSimdiOlacaksin(mKod)

        database = Firebase.database.reference
        binding.biletAlButton.setOnClickListener {
            findNavController().navigate(R.id.action_muzeDetayFragment_to_satinAlMuzeFragment)
        }

        /*val imagePath = "m1/m1b.png"
        val storageReference = FirebaseStorage.getInstance().reference.child(imagePath)
        val imageUrlTask = storageReference.downloadUrl

        imageUrlTask.addOnCompleteListener { uri ->
            val imageUrl = uri.result.toString()

            Glide.with(this)
                .load(imageUrl)
                .fitCenter()
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.add_photo_24)
                .into(binding.mXbImageView)
        }.addOnFailureListener {
            Toast.makeText(requireContext(), "Hata: gerçekleşmiştir", Toast.LENGTH_SHORT).show()
        }.addOnCanceledListener {
            Toast.makeText(requireContext(), "Hata: gerçekleşmiştir", Toast.LENGTH_SHORT).show()
        }*/


        //readMKod(mKod)
        //val resimURL = "gs://aytarmobil.appspot.com/m1/m1a.png"//muzeImagesList[indexDegeri]



        binding.returnButton.setOnClickListener {
            findNavController().navigate(R.id.action_muzeDetayFragment_to_muzeAraFragment)
        }
        return view
    }

    private fun hadiSimdiOlacaksin(mKod: String) {

        database = Firebase.database.reference


        database.child("muzeler").child(mKod).child("muzeAdi").get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val data = task.result?.value // Gelen değeri al
                    // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                    if (data != null) {
                        val gelenVeri = data.toString()
                        //veriyi listeye ekle
                        binding.muzeAdi.text = gelenVeri
                    }
                } else {
                    val exception = task.exception?.localizedMessage

                    Toast.makeText(requireContext(), "Hata: " + exception, Toast.LENGTH_SHORT).show()
                    // Hata durumunda yapılacak işlemler
                    // Örneğin: exception?.message ile hata mesajını alabilirsiniz
                }
            }
        database.child("muzeler").child(mKod).child("muzeHakkinda").get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val data = task.result?.value // Gelen değeri al
                    // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                    if (data != null) {
                        val gelenVeri = data.toString()
                        //veriyi listeye ekle
                        binding.textView6.text = gelenVeri
                    }
                } else {
                    val exception = task.exception?.localizedMessage

                    Toast.makeText(requireContext(), "Hata: " + exception, Toast.LENGTH_SHORT).show()
                    // Hata durumunda yapılacak işlemler
                    // Örneğin: exception?.message ile hata mesajını alabilirsiniz
                }
            }
        val imagePath = mKod + "/" + mKod + "b.png"
        val storageReference = FirebaseStorage.getInstance().reference.child(imagePath)
        val imageUrlTask = storageReference.downloadUrl



        imageUrlTask.addOnCompleteListener { uri ->
            val imageUrl = uri.result.toString()
            Glide.with(this)
                .load(imageUrl)
                .fitCenter()
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.add_photo_24)
                .into(binding.mXbImageView)
        }

        try {
            val videoPath = mKod + "/" + mKod + "v.png"
            val storageReference2 = FirebaseStorage.getInstance().reference.child(videoPath)
            val videoUrlTask = storageReference2.downloadUrl

            binding.muzeVideoView.setVideoURI(Uri.parse(videoUrlTask.toString()))
            binding.muzeVideoView.requestFocus()

            binding.muzeVideoView.setOnPreparedListener{ mediaPlayer ->
                mediaPlayer.isLooping = true
                binding.muzeVideoView.start()
            }


        }catch(e: Exception){
            Toast.makeText(requireContext(),"video için hata oluştu veya video bulunamadı",Toast.LENGTH_LONG).show()
        }

    }


}


/* private fun readMKod(m: String) {
     val pathList: List<String> = listOf("muzeAdi","muzeDetay","muzeImages/b","muzeImages/v","muze3DView")
     val muzeVeriList = mutableListOf<String>()


     for (path in pathList) {
         database.child("muzeler").child(m).child(path).get().addOnCompleteListener { task ->
             if (task.isSuccessful) {
                 val data = task.result?.value // Gelen değeri al


                 // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                 if (data != null) {
                     val muzeAdi = data.toString()
                     //veriyi listeye ekle
                     muzeVeriList.add(muzeAdi)

                 }
             } else {
                 val exception = task.exception?.localizedMessage

                 Toast.makeText(requireContext(), "Hata: " + exception, Toast.LENGTH_SHORT).show()
                 // Hata durumunda yapılacak işlemler
                 // Örneğin: exception?.message ile hata mesajını alabilirsiniz
             }
         }
     }
     val muzeAdi = muzeVeriList[0]
     val muzeDetay=muzeVeriList[1]
     val muzeImagesB = muzeVeriList[2]
     val muzeImagesV = muzeVeriList[3]
     val muze3DView = muzeVeriList[4]

     binding.muzeAdi.text = muzeAdi
     binding.textView6.text= muzeDetay

     Glide.with(this)
         .load(muzeImagesB)
         .fitCenter()
         .skipMemoryCache(true)
         .diskCacheStrategy(DiskCacheStrategy.NONE)
         .placeholder(R.drawable.add_photo_24)
         .into(binding.mXbImageView)
*/


/*
    private fun readDataFromFirebase(tag: String) {
        val database =
            FirebaseDatabase.getInstance()

        val ref = database.getReference(tag)

        val getData = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                val databases = database.reference
                databases.child("selam").child("kullaniciBilgi").setValue("kullanıcıyım ben selam")

                val tester = snapshot.child("selam").child("kullaniciBilgi").value.toString()
                Toast.makeText(requireContext(),"from çalıştı ama bekle", Toast.LENGTH_LONG).show()
                if (tester != null){
                    binding.textView8.text = tester
                }else{
                    Toast.makeText(requireContext(),"boş geldi değer", Toast.LENGTH_LONG).show()
                }

                Toast.makeText(requireContext(),"from error vermedi iyi oldu", Toast.LENGTH_LONG).show()
                val muzeIsmi = snapshot.child("muzeler").child(tag).child("muzeAdi").value as? String ?: ""
                val muzeHakkinda = snapshot.child("muzeler").child(tag).child("muzeHakkinda").value as? String ?: ""


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
                    Toast.makeText(requireContext(),"fro çalıştı", Toast.LENGTH_LONG).show()
                }
                binding.textView8.text = sb


            }

            override fun onCancelled(error: DatabaseError) {
                binding.textView8.text = "acayip hata var"
            }
        }
        database.addValueEventListener(getData)
    }
    private fun biktimFonk(tag: String) {
        val postReference = database.child("muzeler").child(tag) // Düğümü belirtin

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
                val post = dataSnapshot.getValue<Post>()
                // ...
                if (post != null) {
                    Toast.makeText(requireContext(),"veri boş değiş", Toast.LENGTH_LONG).show()
                    binding.textView8.text = post.title
                }else{
                    Toast.makeText(requireContext(),"veri boş çıktı", Toast.LENGTH_LONG).show()
                    binding.textView8.text = "post boş çıktı"
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message

            }
        }

        postReference.addValueEventListener(postListener)
    }
    data class Post(
        val title: String? = "",
        val content: String? = ""
    )
    private fun biktimMiFonk(tag: String) {
        val postReference = database.child("https://aytar-f4152-default-rtdb.europe-west1.firebasedatabase.app").child("muzeler").child(tag).child("muzeAdi") // Düğümü belirtin

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
                val poster = dataSnapshot.getValue<String>()
                // ...
                if (poster != null) {
                    Toast.makeText(requireContext(),"veri boş değiş", Toast.LENGTH_LONG).show()
                    binding.textView8.text = poster
                }else{
                    Toast.makeText(requireContext(),"veri boş çıktı", Toast.LENGTH_LONG).show()
                    binding.textView8.text = "post boş çıktı"
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message

            }
        }

        postReference.addValueEventListener(postListener)
    }
    companion object {
        const val TAG = "TAG-FOR-LOG"
    }

*/


