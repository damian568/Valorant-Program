package com.example.valorantapplication.fragments.info.social

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantapplication.databinding.FragmentInstagramBinding

class InstagramFragment : Fragment() {

    private lateinit var binding: FragmentInstagramBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInstagramBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.webViewInstagram.settings.javaScriptEnabled = true
        binding.webViewInstagram.loadUrl("https://www.instagram.com/playvalorantofficial/")
    }
}