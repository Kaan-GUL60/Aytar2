package com.gkaan.aytar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.gkaan.aytar.databinding.FragmentMuzeAraBinding
import com.gkaan.aytar.databinding.FragmentUyelikBilgiProfilImageBinding


class UyelikBilgiProfilImageFragment : Fragment() {
    private var _binding: FragmentUyelikBilgiProfilImageBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUyelikBilgiProfilImageBinding.inflate(inflater, container, false)
        val view = binding.root


        val userImageUrl = String?: null
        binding.button5.setOnClickListener{
            if(userImageUrl != null){
                findNavController().navigate(R.id.action_uyelikBilgiProfilImageFragment_to_uyelikBilgiTestFragment)

            }
        }

        return view
    }

}