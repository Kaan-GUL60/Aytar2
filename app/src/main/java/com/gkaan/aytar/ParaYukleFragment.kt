package com.gkaan.aytar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gkaan.aytar.databinding.FragmentMuzeDetayBinding
import com.gkaan.aytar.databinding.FragmentParaYukleBinding


class ParaYukleFragment : Fragment() {
    private var _binding: FragmentParaYukleBinding? = null
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
        _binding = FragmentParaYukleBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.imageView24.setOnClickListener {
            findNavController().navigate(R.id.action_paraYukleFragment_to_hesapGecmisFragment)
        }
        return view
    }

}