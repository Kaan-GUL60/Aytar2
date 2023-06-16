package com.gkaan.aytar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gkaan.aytar.databinding.FragmentHesapGecmisBinding
import com.gkaan.aytar.databinding.FragmentMuzeDetayBinding


class HesapGecmisFragment : Fragment() {
    private var _binding: FragmentHesapGecmisBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHesapGecmisBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_hesapGecmisFragment_to_paraYukleFragment)
        }
        return view
    }

}