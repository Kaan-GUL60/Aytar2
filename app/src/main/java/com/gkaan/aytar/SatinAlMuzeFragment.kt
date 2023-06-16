package com.gkaan.aytar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gkaan.aytar.databinding.FragmentMuzeDetayBinding
import com.gkaan.aytar.databinding.FragmentSatinAlMuzeBinding

class SatinAlMuzeFragment : Fragment() {
    private var _binding: FragmentSatinAlMuzeBinding? = null
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
        _binding = FragmentSatinAlMuzeBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.alimOnaylaButton.setOnClickListener {
            findNavController().navigate(R.id.action_satinAlMuzeFragment_to_satinAlmaBasariliFragment)
        }

        return view
    }


}