package com.gkaan.aytar

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.gkaan.aytar.databinding.FragmentMuzeAraBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class MuzeAraFragment : Fragment() {
    private var _binding: FragmentMuzeAraBinding? = null
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
        _binding = FragmentMuzeAraBinding.inflate(inflater, container, false)
        val view = binding.root

        database = Firebase.database.reference

        readMKod()


        binding.backImageMuze.setOnClickListener {
            val intent = Intent(activity, MainMenuActivity::class.java)
            activity?.startActivity(intent)
        }
        binding.m1.setOnClickListener {
            val bundle = Bundle()

            bundle.putString("mKod", "m1")
            val navController = findNavController()
            navController.navigate(R.id.muzeDetayFragment, bundle)
        }
        binding.m2.setOnClickListener {
            val bundle = Bundle()

            bundle.putString("mKod", "m2")
            val navController = findNavController()
            navController.navigate(R.id.muzeDetayFragment, bundle)
        }

        binding.m3.setOnClickListener {
            val bundle = Bundle()

            bundle.putString("mKod", "m3")
            val navController = findNavController()
            navController.navigate(R.id.muzeDetayFragment, bundle)
        }
        binding.m4.setOnClickListener {
            val bundle = Bundle()

            bundle.putString("mKod", "m4")
            val navController = findNavController()
            navController.navigate(R.id.muzeDetayFragment, bundle)
        }
        binding.m5.setOnClickListener {
            val bundle = Bundle()

            bundle.putString("mKod", "m5")
            val navController = findNavController()
            navController.navigate(R.id.muzeDetayFragment, bundle)
        }
        binding.m6.setOnClickListener {
            val bundle = Bundle()

            bundle.putString("mKod", "m6")
            val navController = findNavController()
            navController.navigate(R.id.muzeDetayFragment, bundle)
        }
        binding.m7.setOnClickListener {
            val bundle = Bundle()

            bundle.putString("mKod", "m7")
            val navController = findNavController()
            navController.navigate(R.id.muzeDetayFragment, bundle)
        }
        binding.m8.setOnClickListener {
            val bundle = Bundle()

            bundle.putString("mKod", "m8")
            val navController = findNavController()
            navController.navigate(R.id.muzeDetayFragment, bundle)
        }
        binding.m9.setOnClickListener {
            val bundle = Bundle()

            bundle.putString("mKod", "m9")
            val navController = findNavController()
            navController.navigate(R.id.muzeDetayFragment, bundle)
        }


        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }

    private fun readMKod() {
        //val pathList: List<String> = listOf("muzeAdi", "muzeHakkinda", "muzeImages/a")

        val muzeBasliklariList = mutableListOf<String>()
        val muzeHakkindalariList = mutableListOf<String>()
        val muzeImagesList = mutableListOf<String>()

        val tagVeriList: List<String> = listOf("m1", "m2", "m3", "m4", "m5", "m6", "m7", "m8", "m9")

        val imageViewList = mutableListOf<ImageView>()
        imageViewList.add(binding.muzeResim1)
        imageViewList.add(binding.muzeResim2)
        imageViewList.add(binding.muzeResim3)
        imageViewList.add(binding.muzeResim4)
        imageViewList.add(binding.muzeResim5)
        imageViewList.add(binding.muzeResim6)
        imageViewList.add(binding.muzeResim7)
        imageViewList.add(binding.muzeResim8)
        imageViewList.add(binding.muzeResim9)
        val muzeAdiList = mutableListOf<TextView>()
        muzeAdiList.add(binding.MuzeBaslik1)
        muzeAdiList.add(binding.MuzeBaslik2)
        muzeAdiList.add(binding.MuzeBaslik3)
        muzeAdiList.add(binding.MuzeBaslik4)
        muzeAdiList.add(binding.MuzeBaslik5)
        muzeAdiList.add(binding.MuzeBaslik6)
        muzeAdiList.add(binding.MuzeBaslik7)
        muzeAdiList.add(binding.MuzeBaslik8)
        muzeAdiList.add(binding.MuzeBaslik9)
        val muzeAciklamaList = mutableListOf<TextView>()
        muzeAciklamaList.add(binding.muzeAciklama1)
        muzeAciklamaList.add(binding.muzeAciklama2)
        muzeAciklamaList.add(binding.muzeAciklama3)
        muzeAciklamaList.add(binding.muzeAciklama4)
        muzeAciklamaList.add(binding.muzeAciklama5)
        muzeAciklamaList.add(binding.muzeAciklama6)
        muzeAciklamaList.add(binding.muzeAciklama7)
        muzeAciklamaList.add(binding.muzeAciklama8)
        muzeAciklamaList.add(binding.muzeAciklama9)

        for (m in tagVeriList) {// m1, m2...
            database.child("muzeler").child(m).child("muzeAdi").get().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val data = task.result?.value // Gelen değeri al
                    // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                    if (data != null) {
                        val gelenVeri = data.toString()
                        //veriyi listeye ekle
                        muzeBasliklariList.add(gelenVeri)
                    }
                } else {
                    val exception = task.exception?.localizedMessage

                    Toast.makeText(requireContext(), "Hata: " + exception, Toast.LENGTH_SHORT).show()
                    // Hata durumunda yapılacak işlemler
                    // Örneğin: exception?.message ile hata mesajını alabilirsiniz
                }
            }
        }
        for (m in tagVeriList) {// m1, m2...
            database.child("muzeler").child(m).child("muzeHakkinda").get().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val data = task.result?.value // Gelen değeri al
                    // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                    if (data != null) {
                        val gelenVeri = data.toString()
                        //veriyi listeye ekle
                        muzeHakkindalariList.add(gelenVeri)
                    }
                } else {
                    val exception = task.exception?.localizedMessage

                    Toast.makeText(requireContext(), "Hata: " + exception, Toast.LENGTH_SHORT).show()
                    // Hata durumunda yapılacak işlemler
                    // Örneğin: exception?.message ile hata mesajını alabilirsiniz
                }
            }
        }
        for (m in tagVeriList) {// m1, m2...
            database.child("muzeler").child(m).child("muzeImages/a").get().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val data = task.result?.value // Gelen değeri al
                    // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                    if (data != null) {
                        val gelenVeri = data.toString()
                        //veriyi listeye ekle
                        muzeImagesList.add(gelenVeri)
                    }
                } else {
                    val exception = task.exception?.localizedMessage

                    Toast.makeText(requireContext(), "Hata: " + exception, Toast.LENGTH_SHORT).show()
                    // Hata durumunda yapılacak işlemler
                    // Örneğin: exception?.message ile hata mesajını alabilirsiniz
                }
            }
        }

        for(muzeAdları in muzeBasliklariList){
            val indexT = muzeBasliklariList.indexOf(muzeAdları)
            val textView = muzeAdiList[indexT]
            textView.text = muzeAdları
        }
        for (muzeAciklamalari in muzeHakkindalariList){
            val indexS = muzeHakkindalariList.indexOf(muzeAciklamalari)
            val textViewS = muzeAdiList[indexS]
            textViewS.text = muzeAciklamalari
        }

        for (imageResim in imageViewList) {
            val indexDegeri = imageViewList.indexOf(imageResim)
            val resimURL = muzeImagesList[indexDegeri]
            Glide.with(this)
                .load(resimURL)
                .fitCenter()
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.add_photo_24)
                .into(imageResim)
        }


    }

}

