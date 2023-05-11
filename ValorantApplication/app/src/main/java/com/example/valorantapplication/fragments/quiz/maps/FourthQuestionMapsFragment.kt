package com.example.valorantapplication.fragments.quiz.maps

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantapplication.constants.Constants
import com.example.valorantapplication.constants.ConstantsAnswers
import com.example.valorantapplication.R
import com.example.valorantapplication.bundle
import com.example.valorantapplication.databinding.FragmentFourthQuestionMapsBinding
import com.example.valorantapplication.fragments.quiz.agents.SecondQuestionAgentsFragment

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
        getArgsMaps()
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
            replaceFragment(FifthQuestionMapsFragment())
        }
        else{
            Constants.NUMBER_OF_QUESTIONS_MAPS++
            replaceFragment(FifthQuestionMapsFragment())
        }
    }

    private fun putBundle(){
        bundle.putInt(Constants.ARG_QUESTION, Constants.NUMBER_OF_QUESTIONS_MAPS)
        bundle.putInt(Constants.ARG_CORRECT_ANSWERS, Constants.MAPS_QUIZ_POINTS)
        val fragment = SecondQuestionAgentsFragment()
        fragment.arguments = bundle
    }

    private fun getArgsMaps() {
        val bundle = this.arguments
        if (bundle != null) {
            Constants.MAPS_QUIZ_POINTS = bundle.getInt(Constants.ARG_CORRECT_ANSWERS)
            Constants.NUMBER_OF_QUESTIONS_MAPS = bundle.getInt(Constants.ARG_QUESTION)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        putBundle()
        fragmentManager
            ?.beginTransaction()
            ?.replace(R.id.navHostFragment, fragment)
            ?.addToBackStack(null)
            ?.commit()
    }
}