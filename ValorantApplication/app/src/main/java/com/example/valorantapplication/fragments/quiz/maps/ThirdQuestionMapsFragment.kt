package com.example.valorantapplication.fragments.quiz.maps

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantapplication.Constants
import com.example.valorantapplication.ConstantsAnswers
import com.example.valorantapplication.R
import com.example.valorantapplication.bundle
import com.example.valorantapplication.databinding.FragmentThirdQuestionMapsBinding
import com.example.valorantapplication.fragments.quiz.agents.SecondQuestionAgentsFragment

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
        getArgsMaps()
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
            replaceFragment(FourthQuestionMapsFragment())
        }
        else{
            Constants.NUMBER_OF_QUESTIONS_MAPS++
            replaceFragment(FourthQuestionMapsFragment())
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

//    private fun goToNextQuestion(){
//        val action =
//            ThirdQuestionMapsFragmentDirections.actionThirdQuestionMapsFragmentToFourthQuestionMapsFragment()
//        findNavController().navigate(action)
//    }
}