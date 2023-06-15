package com.gkaan.aytar

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gkaan.aytar.databinding.FragmentMuzeAraBinding
import com.gkaan.aytar.databinding.FragmentProfilBinding


class MuzeAraFragment : Fragment() {
    private var _binding: FragmentMuzeAraBinding? = null
    private val binding get() = _binding!!
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
        binding.backImageMuze.setOnClickListener {
            val intent = Intent(activity, MainMenuActivity::class.java)
            activity?.startActivity(intent)
        }


        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}
