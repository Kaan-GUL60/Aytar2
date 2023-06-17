package com.gkaan.aytar

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
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
        binding.m1.setOnClickListener {
            val bundle = Bundle()

            bundle.putString("mKod","m1")
            val navController = findNavController()
            navController.navigate(R.id.muzeDetayFragment,bundle)
        }
        binding.m2.setOnClickListener {
            val bundle = Bundle()

            bundle.putString("mKod","m2")
            val navController = findNavController()
            navController.navigate(R.id.muzeDetayFragment,bundle)
        }

        binding.m3.setOnClickListener {
            val bundle = Bundle()

            bundle.putString("mKod","m3")
            val navController = findNavController()
            navController.navigate(R.id.muzeDetayFragment,bundle)
        }
        binding.m4.setOnClickListener {
            val bundle = Bundle()

            bundle.putString("mKod","m4")
            val navController = findNavController()
            navController.navigate(R.id.muzeDetayFragment,bundle)
        }
        binding.m5.setOnClickListener {
            val bundle = Bundle()

            bundle.putString("mKod","m5")
            val navController = findNavController()
            navController.navigate(R.id.muzeDetayFragment,bundle)
        }
        binding.m6.setOnClickListener {
            val bundle = Bundle()

            bundle.putString("mKod","m6")
            val navController = findNavController()
            navController.navigate(R.id.muzeDetayFragment,bundle)
        }
        binding.m7.setOnClickListener {
            val bundle = Bundle()

            bundle.putString("mKod","m7")
            val navController = findNavController()
            navController.navigate(R.id.muzeDetayFragment,bundle)
        }
        binding.m8.setOnClickListener {
            val bundle = Bundle()

            bundle.putString("mKod","m8")
            val navController = findNavController()
            navController.navigate(R.id.muzeDetayFragment,bundle)
        }
        binding.m9.setOnClickListener {
            val bundle = Bundle()

            bundle.putString("mKod","m9")
            val navController = findNavController()
            navController.navigate(R.id.muzeDetayFragment,bundle)
        }


        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}
