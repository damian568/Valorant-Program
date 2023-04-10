package com.example.valorantapplication.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.valorantapplication.Constants
import com.example.valorantapplication.data.PreferenceUntil
import com.example.valorantapplication.databinding.FragmentSplashScreenBinding

class SplashScreenFragment : Fragment() {

    private lateinit var binding: FragmentSplashScreenBinding
    private lateinit var preferencesUntil: PreferenceUntil

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSplashScreenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferencesUntil = PreferenceUntil.getInstance(view.context)
        showFullScreen()
        hideToolbar()
        slowedFragment()
    }

    private fun hideToolbar(){
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    private fun showFullScreen(){
        activity?.window?.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }

    private fun slowedFragment() {
        val user = preferencesUntil.getUserData()
        Handler(Looper.getMainLooper()).postDelayed({
            if (user == null) {
                goToRegistrationScreen()
            } else {
                goToMainScreen()
            }
        }, Constants.DELAY_MILLS.toLong())
    }

    private fun goToMainScreen() {
        val action =
            SplashScreenFragmentDirections.actionSplashScreenFragmentToMainScreenFragment()
        findNavController().navigate(action)
    }

    private fun goToRegistrationScreen() {
        val action =
            SplashScreenFragmentDirections.actionSplashScreenFragmentToRegistrationScreenFragment()
        findNavController().navigate(action)
    }
}