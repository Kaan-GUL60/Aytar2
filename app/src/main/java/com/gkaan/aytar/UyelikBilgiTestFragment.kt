package com.gkaan.aytar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gkaan.aytar.databinding.FragmentMuzeAraBinding


class UyelikBilgiTestFragment : Fragment() {
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


        return view
    }


}