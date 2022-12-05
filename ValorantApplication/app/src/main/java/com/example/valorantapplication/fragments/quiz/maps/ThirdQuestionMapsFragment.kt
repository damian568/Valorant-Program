package com.example.valorantapplication.fragments.quiz.maps

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.valorantapplication.databinding.FragmentThirdQuestionMapsBinding

class ThirdQuestionMapsFragment : Fragment() {

    private lateinit var binding: FragmentThirdQuestionMapsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentThirdQuestionMapsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sendAnswer()
    }

    private fun sendAnswer(){
        binding.sendThirdAnswerMaps.setOnClickListener {
            goToNextQuestion()
        }
    }

    private fun goToNextQuestion(){
        val action =
            ThirdQuestionMapsFragmentDirections.actionThirdQuestionMapsFragmentToFourthQuestionMapsFragment()
        findNavController().navigate(action)
    }
}