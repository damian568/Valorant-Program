package com.example.valorantapplication.fragments.quiz.maps

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.valorantapplication.Constants
import com.example.valorantapplication.ConstantsAnswers
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
            checkingAnswer()
        }
    }

    private fun checkingAnswer(){
        if(binding.thirdAnswerMaps.text.toString() == ConstantsAnswers.ANSWER_OF_THIRD_QUESTION_MAPS){
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
            ThirdQuestionMapsFragmentDirections.actionThirdQuestionMapsFragmentToFourthQuestionMapsFragment()
        findNavController().navigate(action)
    }
}