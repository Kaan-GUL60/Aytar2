package com.gkaan.aytar

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.gkaan.aytar.databinding.FragmentAyarlarBinding

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class AyarlarFragment : Fragment(R.layout.fragment_ayarlar) {
    private var _binding: FragmentAyarlarBinding?= null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth
    private lateinit var autho: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAyarlarBinding.inflate(inflater,container,false)
        val view = binding.root

        auth = Firebase.auth
        autho = FirebaseAuth.getInstance()

        val guncelKullanici = auth.currentUser!!.displayName
        binding.backImage.setOnClickListener {
            findNavController().navigate(R.id.action_ayarlarFragment_to_profilFragment)
        }

        binding.changePasswordButton.setOnClickListener {
            val user = autho.currentUser

            user?.let {
                val email = user.email

                email?.let {
                    sendPasswordResetEmail(email)
                }
            }
        }

        binding.textView26.text = guncelKullanici.toString()
        try {

            binding.dilTurkceButton.setOnClickListener {
                LanguageManager.setCurrentLanguage("tr", requireActivity().application)
            }
            binding.dilAlmancaButton.setOnClickListener {
                LanguageManager.setCurrentLanguage("de", requireActivity().application)
            }
            binding.dilingilizceButton.setOnClickListener {
                LanguageManager.setCurrentLanguage("en", requireActivity().application)
            }
            binding.dilFransZcaButton.setOnClickListener {
                LanguageManager.setCurrentLanguage("fr", requireActivity().application)
            }
        }catch (e: Exception){
            Toast.makeText(requireContext(),"Bir hata oluştu: "  + e.localizedMessage, Toast.LENGTH_LONG).show()
            e.localizedMessage?.let { Log.d("Error screen", it) }
        }
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null

    }


    private fun sendPasswordResetEmail(email: String ){
        auth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
            if(task.isSuccessful){
                Toast.makeText(requireContext(),"Email gönderme başarılı " , Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(requireContext(),"Email gönderme başarısız " , Toast.LENGTH_LONG).show()
            }
        }
    }
}