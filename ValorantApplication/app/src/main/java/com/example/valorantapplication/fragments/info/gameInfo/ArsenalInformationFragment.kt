package com.example.valorantapplication.fragments.info.gameInfo

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.valorantapplication.constants.Constants
import com.example.valorantapplication.databinding.FragmentArsenalInformationBinding

class ArsenalInformationFragment : Fragment() {

    private lateinit var binding: FragmentArsenalInformationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArsenalInformationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgsArsenal()

        val argString = arguments?.getString("argString")

        binding.txtNameArsenal.text = argString
        binding.txtTypeArsenal.text = Constants.typeArsenal
        binding.txtArsenalInformation.text = Constants.arsenalInformation
        val uri = Uri.parse(Constants.imageArsenalURI)
        Glide.with(this)
            .load(uri)
            .into(binding.imageArsenalInformation)
    }

    private fun getArgsArsenal() {
        val bundle = arguments
        if (bundle != null) {
            Constants.nameArsenal = bundle.getString(Constants.ARG_ARSENAL, Constants.typeArsenal).toString()
            Constants.nameArsenal = bundle.getString(Constants.ARG_ARSENAL, Constants.arsenalInformation).toString()
            Constants.nameArsenal = bundle.getString(Constants.ARG_ARSENAL, Constants.imageArsenalURI).toString()
        }
    }
}