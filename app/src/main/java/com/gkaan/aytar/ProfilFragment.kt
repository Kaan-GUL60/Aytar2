package com.gkaan.aytar

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.gkaan.aytar.databinding.FragmentProfilBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class ProfilFragment : Fragment(R.layout.fragment_profil) {
    private var _binding: FragmentProfilBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfilBinding.inflate(inflater,container,false)
        val view = binding.root

        auth = Firebase.auth
        val guncelKullanici = auth.currentUser!!.displayName


        binding.textView15.text = guncelKullanici.toString()
        binding.backImageProfil.setOnClickListener {
            val intent = Intent(activity, MainMenuActivity::class.java)
            activity?.startActivity(intent)
        }
        binding.editProfil.setOnClickListener {
            findNavController().navigate(R.id.action_profilFragment_to_ayarlarFragment)
        }
        binding.logOutButton.setOnClickListener {
            auth.signOut()
            val intent = Intent(activity,SignActivity::class.java)
            activity?.startActivity(intent)
            requireActivity().finish()

        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null

    }

}