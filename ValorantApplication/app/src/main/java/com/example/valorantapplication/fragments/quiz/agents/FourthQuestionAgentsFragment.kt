package com.example.valorantapplication.fragments.quiz.agents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.valorantapplication.Constants
import com.example.valorantapplication.R
import com.example.valorantapplication.databinding.FragmentFourthQuestionAgentsBinding
import com.example.valorantapplication.enums.FourthQuestionAgents

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
            getSelectRadioBtnValue()
        }
    }

    private fun getSelectRadioBtnValue(){
        when(binding.radioGroupFourthAnswer.checkedRadioButtonId){
            R.id.btnRadioPhoenix -> {
                FourthQuestionAgents.Phoenix
                Constants.NUMBER_OF_QUESTIONS_AGENTS++
                goToNextQuestion()
            }
            R.id.btnRadioKillJoy -> {
                FourthQuestionAgents.KillJoy
                Constants.NUMBER_OF_QUESTIONS_AGENTS++
                goToNextQuestion()
            }
            R.id.btnRadioCypher -> {
                FourthQuestionAgents.Cypher
                Constants.AGENTS_QUIZ_POINTS++
                Constants.NUMBER_OF_QUESTIONS_AGENTS++
                goToNextQuestion()
            }
        }
    }

    private fun goToNextQuestion(){
        val action =
            FourthQuestionAgentsFragmentDirections.actionFourthQuestionAgentsFragmentToFifthQuestionAgentsFragment()
        findNavController().navigate(action)
    }
}