package com.example.valorantapplication.fragments.quiz.agents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.valorantapplication.databinding.FragmentFourthQuestionAgentsBinding

class FourthQuestionAgentsFragment : Fragment() {

    private lateinit var binding: FragmentFourthQuestionAgentsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFourthQuestionAgentsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sendAnswer()
    }

    private fun sendAnswer(){
        binding.sendFourthAnswerAgents.setOnClickListener {
            goToNextQuestion()
        }
    }

    private fun goToNextQuestion(){
        val action =
            FourthQuestionAgentsFragmentDirections.actionFourthQuestionAgentsFragmentToFifthQuestionAgentsFragment()
        findNavController().navigate(action)
    }
}