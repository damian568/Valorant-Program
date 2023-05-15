package com.example.valorantapplication.fragments.info.support

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantapplication.R
import com.example.valorantapplication.databinding.FragmentSpecsBinding

class SpecsFragment : Fragment() {

    private lateinit var binding: FragmentSpecsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSpecsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setImageColor()
    }

    private fun setImageColor(){
        binding.imageWindowsSpecs.setColorFilter(resources.getColor(R.color.white))
        binding.imageLowFPSSpecs.setColorFilter(resources.getColor(R.color.white))
        binding.imageAverageFPSSpecs.setColorFilter(resources.getColor(R.color.white))
        binding.imageMaxFPSSpecs.setColorFilter(resources.getColor(R.color.white))
    }
}