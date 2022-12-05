package com.example.valorantapplication.fragments.quiz.agents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.valorantapplication.databinding.FragmentSecondQuestionAgentsBinding

class SecondQuestionAgentsFragment : Fragment() {

    private lateinit var binding: FragmentSecondQuestionAgentsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSecondQuestionAgentsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickButtons()
    }

    private fun clickButtons(){
        binding.btnSova.setOnClickListener {
            goToNextQuestion()
        }

        binding.btnChamber.setOnClickListener {
            goToNextQuestion()
        }

        binding.btnHarbor.setOnClickListener {
            goToNextQuestion()
        }

        binding.btnBrim.setOnClickListener {
            goToNextQuestion()
        }
    }

    private fun goToNextQuestion(){
        val action =
            SecondQuestionAgentsFragmentDirections.actionSecondQuestionAgentsFragmentToThirdQuestionAgentsFragment()
        findNavController().navigate(action)
    }
}