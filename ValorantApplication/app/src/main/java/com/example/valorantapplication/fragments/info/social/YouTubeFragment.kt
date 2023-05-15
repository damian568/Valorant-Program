package com.example.valorantapplication.fragments.info.social

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantapplication.databinding.FragmentYouTubeBinding

class YouTubeFragment : Fragment() {

    private lateinit var binding: FragmentYouTubeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentYouTubeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.webViewYouTube.settings.javaScriptEnabled = true
        binding.webViewYouTube.loadUrl("https://www.youtube.com/PlayValorant")
    }
}