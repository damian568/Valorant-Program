package com.example.valorantapplication.fragments.info.social

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantapplication.databinding.FragmentFacebookBinding

class FacebookFragment : Fragment() {

    private lateinit var binding: FragmentFacebookBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFacebookBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.webViewFacebook.settings.javaScriptEnabled = true
        binding.webViewFacebook.loadUrl("https://www.facebook.com/PlayVALORANT/")
    }
}