package com.example.valorantapplication.fragments.quiz.weapons

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.valorantapplication.Constants
import com.example.valorantapplication.ConstantsAnswers
import com.example.valorantapplication.databinding.FragmentFifthQuestionWeaponsBinding

class FifthQuestionWeaponsFragment : Fragment() {

    private lateinit var binding: FragmentFifthQuestionWeaponsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFifthQuestionWeaponsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sendAnswer()
    }

    private fun sendAnswer(){
        binding.sendFifthAnswerWeapons.setOnClickListener {
            checkingAnswer()
        }
    }

    private fun checkingAnswer(){
        if(binding.fifthAnswerWeapons.text.toString() == ConstantsAnswers.ANSWER_OF_FIFTH_QUESTION_WEAPONS){
            Constants.WEAPONS_QUIZ_POINTS++
            Constants.NUMBER_OF_QUESTIONS_WEAPONS++
            goToNextQuestion()
        }
        else{
            Constants.NUMBER_OF_QUESTIONS_WEAPONS++
            goToNextQuestion()
        }
    }

    private fun goToNextQuestion(){
        val action =
            FifthQuestionWeaponsFragmentDirections.actionFifthQuestionWeaponsFragmentToEndOfQuizFragment()
        findNavController().navigate(action)
    }
}