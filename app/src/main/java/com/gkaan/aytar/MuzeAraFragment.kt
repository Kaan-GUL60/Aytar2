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
import com.google.firebase.storage.FirebaseStorage


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

        /*database = Firebase.database.reference

        try {
            var gelenVersiyon: String = "1.0"
            database.child("uygulama").child("verisonName").get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val data = task.result?.value // Gelen değeri al
                        // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                        if (data != null) {
                            gelenVersiyon = data.toString()
                            //veriyi listeye ekle

                        }
                    } else {
                        val exception = task.exception?.localizedMessage

                        Toast.makeText(requireContext(), "Hata: " + exception, Toast.LENGTH_SHORT).show()
                        // Hata durumunda yapılacak işlemler
                        // Örneğin: exception?.message ile hata mesajını alabilirsiniz
                    }
                }
            val packageInfo = context?.packageManager?.getPackageInfo(context!!.packageName, 0)
            val versionName = packageInfo?.versionName

            if (versionName.toString() != gelenVersiyon) {
                findNavController().navigate(R.id.action_muzeAraFragment_to_appUpdateFragment)
            }

        }catch(e: Exception){
            Toast.makeText(requireContext(),"video için hata oluştu veya video bulunamadı",Toast.LENGTH_LONG).show()
        }*/
        database = Firebase.database.reference

        veriAlArtıkYeter()




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


    private fun veriAlArtıkYeter() {
            database.child("muzeler").child("m1").child("muzeAdi").get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val data = task.result?.value // Gelen değeri al
                        // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                        if (data != null) {
                            val gelenVeri = data.toString()
                            //veriyi listeye ekle
                            //val muzeBaslik = muzeAdiList[indexOfDongu]
                            binding.MuzeBaslik1.text = gelenVeri
                            //Toast.makeText(requireContext(), "ID: " + muzeBaslik + "mDeger: " + tagVeriList[indexOfDongu] + "index: " + indexOfDongu +"selam bitti", Toast.LENGTH_LONG).show()
                        }
                    } else {
                        val exception = task.exception?.localizedMessage

                        Toast.makeText(requireContext(), "Hata: " + exception, Toast.LENGTH_SHORT).show()
                        // Hata durumunda yapılacak işlemler
                        // Örneğin: exception?.message ile hata mesajını alabilirsiniz
                    }
                }
            database.child("muzeler").child("m1").child("muzeHakkinda").get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val data = task.result?.value // Gelen değeri al
                        // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                        if (data != null) {
                            val gelenVeri = data.toString()
                            //veriyi listeye ekle
                            //val muzeAciklama = muzeAciklamaList[indexOfDongu]
                            binding.muzeAciklama1.text = gelenVeri
                        }
                    } else {
                        val exception = task.exception?.localizedMessage

                        Toast.makeText(requireContext(), "Hata: " + exception, Toast.LENGTH_SHORT).show()
                        // Hata durumunda yapılacak işlemler
                        // Örneğin: exception?.message ile hata mesajını alabilirsiniz
                    }
                }
            val imagePath = "m1" + "/" + "m1" + "a.png"
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
                    .into(binding.muzeResim1)
            }
        //-------------------------------**********************-----------------------*******************----------------------------------****************************************----------------------------------************************
        database.child("muzeler").child("m2").child("muzeAdi").get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val data = task.result?.value // Gelen değeri al
                    // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                    if (data != null) {
                        val gelenVeri = data.toString()
                        //veriyi listeye ekle
                        //val muzeBaslik = muzeAdiList[indexOfDongu]
                        binding.MuzeBaslik2.text = gelenVeri
                        //Toast.makeText(requireContext(), "ID: " + muzeBaslik + "mDeger: " + tagVeriList[indexOfDongu] + "index: " + indexOfDongu +"selam bitti", Toast.LENGTH_LONG).show()
                    }
                } else {
                    val exception = task.exception?.localizedMessage

                    Toast.makeText(requireContext(), "Hata: " + exception, Toast.LENGTH_SHORT).show()
                    // Hata durumunda yapılacak işlemler
                    // Örneğin: exception?.message ile hata mesajını alabilirsiniz
                }
            }
        database.child("muzeler").child("m2").child("muzeHakkinda").get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val data = task.result?.value // Gelen değeri al
                    // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                    if (data != null) {
                        val gelenVeri = data.toString()
                        //veriyi listeye ekle
                        //val muzeAciklama = muzeAciklamaList[indexOfDongu]
                        binding.muzeAciklama2.text = gelenVeri
                    }
                } else {
                    val exception = task.exception?.localizedMessage

                    Toast.makeText(requireContext(), "Hata: " + exception, Toast.LENGTH_SHORT).show()
                    // Hata durumunda yapılacak işlemler
                    // Örneğin: exception?.message ile hata mesajını alabilirsiniz
                }
            }
        val imagePath2 = "m2" + "/" + "m2" + "a.png"
        val storageReference2 = FirebaseStorage.getInstance().reference.child(imagePath2)
        val imageUrlTask2 = storageReference2.downloadUrl

        imageUrlTask2.addOnCompleteListener { uri ->
            val imageUrl = uri.result.toString()
            Glide.with(this)
                .load(imageUrl)
                .fitCenter()
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.add_photo_24)
                .into(binding.muzeResim2)
        }
        //-------------------------------**********************-----------------------*******************----------------------------------****************************************----------------------------------************************
        database.child("muzeler").child("m3").child("muzeAdi").get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val data = task.result?.value // Gelen değeri al
                    // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                    if (data != null) {
                        val gelenVeri = data.toString()
                        //veriyi listeye ekle
                        //val muzeBaslik = muzeAdiList[indexOfDongu]
                        binding.MuzeBaslik3.text = gelenVeri
                        //Toast.makeText(requireContext(), "ID: " + muzeBaslik + "mDeger: " + tagVeriList[indexOfDongu] + "index: " + indexOfDongu +"selam bitti", Toast.LENGTH_LONG).show()
                    }
                } else {
                    val exception = task.exception?.localizedMessage

                    Toast.makeText(requireContext(), "Hata: " + exception, Toast.LENGTH_SHORT).show()
                    // Hata durumunda yapılacak işlemler
                    // Örneğin: exception?.message ile hata mesajını alabilirsiniz
                }
            }
        database.child("muzeler").child("m3").child("muzeHakkinda").get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val data = task.result?.value // Gelen değeri al
                    // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                    if (data != null) {
                        val gelenVeri = data.toString()
                        //veriyi listeye ekle
                        //val muzeAciklama = muzeAciklamaList[indexOfDongu]
                        binding.muzeAciklama3.text = gelenVeri
                    }
                } else {
                    val exception = task.exception?.localizedMessage

                    Toast.makeText(requireContext(), "Hata: " + exception, Toast.LENGTH_SHORT).show()
                    // Hata durumunda yapılacak işlemler
                    // Örneğin: exception?.message ile hata mesajını alabilirsiniz
                }
            }
        val imagePath3 = "m3" + "/" + "m3" + "a.png"
        val storageReference3 = FirebaseStorage.getInstance().reference.child(imagePath3)
        val imageUrlTask3 = storageReference3.downloadUrl

        imageUrlTask3.addOnCompleteListener { uri ->
            val imageUrl = uri.result.toString()
            Glide.with(this)
                .load(imageUrl)
                .fitCenter()
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.add_photo_24)
                .into(binding.muzeResim3)
        }
        //-------------------------------**********************-----------------------*******************----------------------------------****************************************----------------------------------************************
        database.child("muzeler").child("m4").child("muzeAdi").get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val data = task.result?.value // Gelen değeri al
                    // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                    if (data != null) {
                        val gelenVeri = data.toString()
                        //veriyi listeye ekle
                        //val muzeBaslik = muzeAdiList[indexOfDongu]
                        binding.MuzeBaslik4.text = gelenVeri
                        //Toast.makeText(requireContext(), "ID: " + muzeBaslik + "mDeger: " + tagVeriList[indexOfDongu] + "index: " + indexOfDongu +"selam bitti", Toast.LENGTH_LONG).show()
                    }
                } else {
                    val exception = task.exception?.localizedMessage

                    Toast.makeText(requireContext(), "Hata: " + exception, Toast.LENGTH_SHORT).show()
                    // Hata durumunda yapılacak işlemler
                    // Örneğin: exception?.message ile hata mesajını alabilirsiniz
                }
            }
        database.child("muzeler").child("m4").child("muzeHakkinda").get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val data = task.result?.value // Gelen değeri al
                    // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                    if (data != null) {
                        val gelenVeri = data.toString()
                        //veriyi listeye ekle
                        //val muzeAciklama = muzeAciklamaList[indexOfDongu]
                        binding.muzeAciklama4.text = gelenVeri
                    }
                } else {
                    val exception = task.exception?.localizedMessage

                    Toast.makeText(requireContext(), "Hata: " + exception, Toast.LENGTH_SHORT).show()
                    // Hata durumunda yapılacak işlemler
                    // Örneğin: exception?.message ile hata mesajını alabilirsiniz
                }
            }
        val imagePath4 = "m4" + "/" + "m4" + "a.png"
        val storageReference4 = FirebaseStorage.getInstance().reference.child(imagePath4)
        val imageUrlTask4 = storageReference4.downloadUrl

        imageUrlTask4.addOnCompleteListener { uri ->
            val imageUrl = uri.result.toString()
            Glide.with(this)
                .load(imageUrl)
                .fitCenter()
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.add_photo_24)
                .into(binding.muzeResim4)
        }
        //-------------------------------**********************-----------------------*******************----------------------------------****************************************----------------------------------************************
        database.child("muzeler").child("m5").child("muzeAdi").get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val data = task.result?.value // Gelen değeri al
                    // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                    if (data != null) {
                        val gelenVeri = data.toString()
                        //veriyi listeye ekle
                        //val muzeBaslik = muzeAdiList[indexOfDongu]
                        binding.MuzeBaslik5.text = gelenVeri
                        //Toast.makeText(requireContext(), "ID: " + muzeBaslik + "mDeger: " + tagVeriList[indexOfDongu] + "index: " + indexOfDongu +"selam bitti", Toast.LENGTH_LONG).show()
                    }
                } else {
                    val exception = task.exception?.localizedMessage

                    Toast.makeText(requireContext(), "Hata: " + exception, Toast.LENGTH_SHORT).show()
                    // Hata durumunda yapılacak işlemler
                    // Örneğin: exception?.message ile hata mesajını alabilirsiniz
                }
            }
        database.child("muzeler").child("m5").child("muzeHakkinda").get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val data = task.result?.value // Gelen değeri al
                    // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                    if (data != null) {
                        val gelenVeri = data.toString()
                        //veriyi listeye ekle
                        //val muzeAciklama = muzeAciklamaList[indexOfDongu]
                        binding.muzeAciklama5.text = gelenVeri
                    }
                } else {
                    val exception = task.exception?.localizedMessage

                    Toast.makeText(requireContext(), "Hata: " + exception, Toast.LENGTH_SHORT).show()
                    // Hata durumunda yapılacak işlemler
                    // Örneğin: exception?.message ile hata mesajını alabilirsiniz
                }
            }
        val imagePath5 = "m5" + "/" + "m5" + "a.png"
        val storageReference5 = FirebaseStorage.getInstance().reference.child(imagePath5)
        val imageUrlTask5 = storageReference5.downloadUrl

        imageUrlTask5.addOnCompleteListener { uri ->
            val imageUrl = uri.result.toString()
            Glide.with(this)
                .load(imageUrl)
                .fitCenter()
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.add_photo_24)
                .into(binding.muzeResim5)
        }
        //-------------------------------**********************-----------------------*******************----------------------------------****************************************----------------------------------************************
        database.child("muzeler").child("m6").child("muzeAdi").get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val data = task.result?.value // Gelen değeri al
                    // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                    if (data != null) {
                        val gelenVeri = data.toString()
                        //veriyi listeye ekle
                        //val muzeBaslik = muzeAdiList[indexOfDongu]
                        binding.MuzeBaslik6.text = gelenVeri
                        //Toast.makeText(requireContext(), "ID: " + muzeBaslik + "mDeger: " + tagVeriList[indexOfDongu] + "index: " + indexOfDongu +"selam bitti", Toast.LENGTH_LONG).show()
                    }
                } else {
                    val exception = task.exception?.localizedMessage

                    Toast.makeText(requireContext(), "Hata: " + exception, Toast.LENGTH_SHORT).show()
                    // Hata durumunda yapılacak işlemler
                    // Örneğin: exception?.message ile hata mesajını alabilirsiniz
                }
            }
        database.child("muzeler").child("m6").child("muzeHakkinda").get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val data = task.result?.value // Gelen değeri al
                    // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                    if (data != null) {
                        val gelenVeri = data.toString()
                        //veriyi listeye ekle
                        //val muzeAciklama = muzeAciklamaList[indexOfDongu]
                        binding.muzeAciklama6.text = gelenVeri
                    }
                } else {
                    val exception = task.exception?.localizedMessage

                    Toast.makeText(requireContext(), "Hata: " + exception, Toast.LENGTH_SHORT).show()
                    // Hata durumunda yapılacak işlemler
                    // Örneğin: exception?.message ile hata mesajını alabilirsiniz
                }
            }
        val imagePath6 = "m6" + "/" + "m6" + "a.png"
        val storageReference6 = FirebaseStorage.getInstance().reference.child(imagePath6)
        val imageUrlTask6 = storageReference6.downloadUrl

        imageUrlTask6.addOnCompleteListener { uri ->
            val imageUrl = uri.result.toString()
            Glide.with(this)
                .load(imageUrl)
                .fitCenter()
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.add_photo_24)
                .into(binding.muzeResim6)
        }
        //-------------------------------**********************-----------------------*******************----------------------------------****************************************----------------------------------************************
        database.child("muzeler").child("m7").child("muzeAdi").get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val data = task.result?.value // Gelen değeri al
                    // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                    if (data != null) {
                        val gelenVeri = data.toString()
                        //veriyi listeye ekle
                        //val muzeBaslik = muzeAdiList[indexOfDongu]
                        binding.MuzeBaslik7.text = gelenVeri
                        //Toast.makeText(requireContext(), "ID: " + muzeBaslik + "mDeger: " + tagVeriList[indexOfDongu] + "index: " + indexOfDongu +"selam bitti", Toast.LENGTH_LONG).show()
                    }
                } else {
                    val exception = task.exception?.localizedMessage

                    Toast.makeText(requireContext(), "Hata: " + exception, Toast.LENGTH_SHORT).show()
                    // Hata durumunda yapılacak işlemler
                    // Örneğin: exception?.message ile hata mesajını alabilirsiniz
                }
            }
        database.child("muzeler").child("m7").child("muzeHakkinda").get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val data = task.result?.value // Gelen değeri al
                    // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                    if (data != null) {
                        val gelenVeri = data.toString()
                        //veriyi listeye ekle
                        //val muzeAciklama = muzeAciklamaList[indexOfDongu]
                        binding.muzeAciklama7.text = gelenVeri
                    }
                } else {
                    val exception = task.exception?.localizedMessage

                    Toast.makeText(requireContext(), "Hata: " + exception, Toast.LENGTH_SHORT).show()
                    // Hata durumunda yapılacak işlemler
                    // Örneğin: exception?.message ile hata mesajını alabilirsiniz
                }
            }
        val imagePath7= "m7" + "/" + "m7" + "a.png"
        val storageReference7 = FirebaseStorage.getInstance().reference.child(imagePath7)
        val imageUrlTask7 = storageReference7.downloadUrl

        imageUrlTask7.addOnCompleteListener { uri ->
            val imageUrl = uri.result.toString()
            Glide.with(this)
                .load(imageUrl)
                .fitCenter()
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.add_photo_24)
                .into(binding.muzeResim7)
        }
        //-------------------------------**********************-----------------------*******************----------------------------------****************************************----------------------------------************************
        database.child("muzeler").child("m8").child("muzeAdi").get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val data = task.result?.value // Gelen değeri al
                    // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                    if (data != null) {
                        val gelenVeri = data.toString()
                        //veriyi listeye ekle
                        //val muzeBaslik = muzeAdiList[indexOfDongu]
                        binding.MuzeBaslik8.text = gelenVeri
                        //Toast.makeText(requireContext(), "ID: " + muzeBaslik + "mDeger: " + tagVeriList[indexOfDongu] + "index: " + indexOfDongu +"selam bitti", Toast.LENGTH_LONG).show()
                    }
                } else {
                    val exception = task.exception?.localizedMessage

                    Toast.makeText(requireContext(), "Hata: " + exception, Toast.LENGTH_SHORT).show()
                    // Hata durumunda yapılacak işlemler
                    // Örneğin: exception?.message ile hata mesajını alabilirsiniz
                }
            }
        database.child("muzeler").child("m8").child("muzeHakkinda").get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val data = task.result?.value // Gelen değeri al
                    // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                    if (data != null) {
                        val gelenVeri = data.toString()
                        //veriyi listeye ekle
                        //val muzeAciklama = muzeAciklamaList[indexOfDongu]
                        binding.muzeAciklama8.text = gelenVeri
                    }
                } else {
                    val exception = task.exception?.localizedMessage

                    Toast.makeText(requireContext(), "Hata: " + exception, Toast.LENGTH_SHORT).show()
                    // Hata durumunda yapılacak işlemler
                    // Örneğin: exception?.message ile hata mesajını alabilirsiniz
                }
            }
        val imagePath8= "m8" + "/" + "m8" + "a.png"
        val storageReference8 = FirebaseStorage.getInstance().reference.child(imagePath8)
        val imageUrlTask8 = storageReference8.downloadUrl

        imageUrlTask7.addOnCompleteListener { uri ->
            val imageUrl = uri.result.toString()
            Glide.with(this)
                .load(imageUrl)
                .fitCenter()
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.add_photo_24)
                .into(binding.muzeResim8)
        }
        //-------------------------------**********************-----------------------*******************----------------------------------****************************************----------------------------------************************
        database.child("muzeler").child("m9").child("muzeAdi").get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val data = task.result?.value // Gelen değeri al
                    // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                    if (data != null) {
                        val gelenVeri = data.toString()
                        //veriyi listeye ekle
                        //val muzeBaslik = muzeAdiList[indexOfDongu]
                        binding.MuzeBaslik9.text = gelenVeri
                        //Toast.makeText(requireContext(), "ID: " + muzeBaslik + "mDeger: " + tagVeriList[indexOfDongu] + "index: " + indexOfDongu +"selam bitti", Toast.LENGTH_LONG).show()
                    }
                } else {
                    val exception = task.exception?.localizedMessage

                    Toast.makeText(requireContext(), "Hata: " + exception, Toast.LENGTH_SHORT).show()
                    // Hata durumunda yapılacak işlemler
                    // Örneğin: exception?.message ile hata mesajını alabilirsiniz
                }
            }
        database.child("muzeler").child("m9").child("muzeHakkinda").get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val data = task.result?.value // Gelen değeri al
                    // Gelen değeri kullanmak için burada işlemler yapabilirsiniz
                    if (data != null) {
                        val gelenVeri = data.toString()
                        //veriyi listeye ekle
                        //val muzeAciklama = muzeAciklamaList[indexOfDongu]
                        binding.muzeAciklama9.text = gelenVeri
                    }
                } else {
                    val exception = task.exception?.localizedMessage

                    Toast.makeText(requireContext(), "Hata: " + exception, Toast.LENGTH_SHORT).show()
                    // Hata durumunda yapılacak işlemler
                    // Örneğin: exception?.message ile hata mesajını alabilirsiniz
                }
            }
        val imagePath9= "m9" + "/" + "m9" + "a.png"
        val storageReference9 = FirebaseStorage.getInstance().reference.child(imagePath9)
        val imageUrlTask9 = storageReference9.downloadUrl

        imageUrlTask9.addOnCompleteListener { uri ->
            val imageUrl = uri.result.toString()
            Glide.with(this)
                .load(imageUrl)
                .fitCenter()
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.add_photo_24)
                .into(binding.muzeResim9)
        }
        //-------------------------------**********************-----------------------*******************----------------------------------****************************************----------------------------------************************


    }



}


/*
    private fun readMKod() {  // gs://aytarmobil.appspot.com/m1/m1a.png
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

        for (muzeAdları in muzeBasliklariList) {
            val indexT = muzeBasliklariList.indexOf(muzeAdları)
            val textView = muzeAdiList[indexT]
            textView.text = muzeAdları
        }
        for (muzeAciklamalari in muzeHakkindalariList) {
            val indexS = muzeHakkindalariList.indexOf(muzeAciklamalari)
            val textViewS = muzeAdiList[indexS]
            textViewS.text = muzeAciklamalari
        }

        for (imageResim in imageViewList) {// gs://aytarmobil.appspot.com/m1/m1a.png
            val indexDegeri = imageViewList.indexOf(imageResim)
            val imagePath = "m1/m1b.png"
            val storageReference = FirebaseStorage.getInstance().reference.child(imagePath)
            val imageUrlTask = storageReference.downloadUrl

            imageUrlTask.addOnCompleteListener { uri ->
                val imageUrl = uri.result.toString()
                Toast.makeText(requireContext(), "Hata yoktur ellağam: " + imageUrl, Toast.LENGTH_SHORT).show()
                Glide.with(this)
                    .load(imageUrl)
                    .fitCenter()
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .placeholder(R.drawable.add_photo_24)
                    .into()
            }.addOnFailureListener {
                Toast.makeText(requireContext(), "Hata: gerçekleşmiştir", Toast.LENGTH_SHORT).show()
            }.addOnCanceledListener {
                Toast.makeText(requireContext(), "Hata: gerçekleşmiştir", Toast.LENGTH_SHORT).show()
            }
        }


    }

}

*/