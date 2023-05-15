package com.example.valorantapplication.fragments.info.social

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantapplication.databinding.FragmentDiscordBinding

class DiscordFragment : Fragment() {

    private lateinit var binding: FragmentDiscordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDiscordBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.webViewDiscord.settings.javaScriptEnabled = true
        binding.webViewDiscord.loadUrl("https://discord.com/invite/valorant")
    }
}