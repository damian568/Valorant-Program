package com.example.valorantapplication.fragments.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantapplication.R
import com.example.valorantapplication.databinding.FragmentInfoBinding
import com.example.valorantapplication.databinding.FragmentMainScreenBinding

class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentInfoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}