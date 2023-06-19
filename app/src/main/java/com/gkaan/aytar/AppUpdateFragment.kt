package com.gkaan.aytar

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gkaan.aytar.databinding.FragmentAppUpdateBinding



class AppUpdateFragment : Fragment() {
    private var _binding: FragmentAppUpdateBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAppUpdateBinding.inflate(inflater, container, false)
        val view = binding.root

            val updateLink = "https://drive.google.com/file/d/1AdXZRkPAD8VdDXMFdkLJ5vqn44QPValZ/view?usp=drivesdk"

            binding.button6.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(updateLink))
                startActivity(intent)

        }




        return view
    }

}