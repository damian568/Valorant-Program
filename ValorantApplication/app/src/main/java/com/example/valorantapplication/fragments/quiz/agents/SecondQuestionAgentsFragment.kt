package com.example.valorantapplication.fragments.quiz.agents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.valorantapplication.Constants
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
            Constants.NUMBER_OF_QUESTIONS_AGENTS++
            goToNextQuestion()
        }

        binding.btnChamber.setOnClickListener {
            Constants.AGENTS_QUIZ_POINTS++
            Constants.NUMBER_OF_QUESTIONS_AGENTS++
            goToNextQuestion()
        }

        binding.btnHarbor.setOnClickListener {
            Constants.NUMBER_OF_QUESTIONS_AGENTS++
            goToNextQuestion()
        }

        binding.btnBrim.setOnClickListener {
            Constants.NUMBER_OF_QUESTIONS_AGENTS++
            goToNextQuestion()
        }
    }

    private fun goToNextQuestion(){
        val action =
            SecondQuestionAgentsFragmentDirections.actionSecondQuestionAgentsFragmentToThirdQuestionAgentsFragment()
        findNavController().navigate(action)
    }
}