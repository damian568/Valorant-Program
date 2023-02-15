package com.example.valorantapplication.fragments.quiz.maps

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.valorantapplication.Constants
import com.example.valorantapplication.ConstantsAnswers
import com.example.valorantapplication.databinding.FragmentFourthQuestionMapsBinding

class FourthQuestionMapsFragment : Fragment() {

    private lateinit var binding: FragmentFourthQuestionMapsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFourthQuestionMapsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sendAnswer()
    }

    private fun sendAnswer(){
        binding.sendFourThAnswerMaps.setOnClickListener {
            checkingAnswer()
        }
    }

    private fun checkingAnswer(){
        if(binding.fourthAnswerMaps.text.toString() == ConstantsAnswers.ANSWER_OF_FOURTH_QUESTION_MAPS){
            Constants.MAPS_QUIZ_POINTS++
            Constants.NUMBER_OF_QUESTIONS_MAPS++
            goToNextQuestion()
        }
        else{
            Constants.NUMBER_OF_QUESTIONS_MAPS++
            goToNextQuestion()
        }
    }

    private fun goToNextQuestion(){
        val action =
            FourthQuestionMapsFragmentDirections.actionFourthQuestionMapsFragmentToFifthQuestionMapsFragment()
        findNavController().navigate(action)
    }
}