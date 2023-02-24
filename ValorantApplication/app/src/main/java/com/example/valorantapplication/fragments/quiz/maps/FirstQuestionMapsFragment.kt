package com.example.valorantapplication.fragments.quiz.maps

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantapplication.Constants
import com.example.valorantapplication.R
import com.example.valorantapplication.bundle
import com.example.valorantapplication.databinding.FragmentFirstQuestionMapsBinding
import com.example.valorantapplication.enums.FirstQuestionMaps
import com.example.valorantapplication.fragments.quiz.agents.SecondQuestionAgentsFragment

class FirstQuestionMapsFragment : Fragment() {

    private lateinit var binding: FragmentFirstQuestionMapsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFirstQuestionMapsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgsMaps()
        sendAnswer()
    }

    private fun sendAnswer(){
        binding.sendFirstAnswerMaps.setOnClickListener {
            getSelectRadioBtnValue()
        }
    }

    private fun getSelectRadioBtnValue(){
        when(binding.radioGroupPoints.checkedRadioButtonId){
            R.id.btnRadioSnowman -> {
                FirstQuestionMaps.Snowman
                Constants.NUMBER_OF_QUESTIONS_MAPS++
                Constants.MAPS_QUIZ_POINTS++
                replaceFragment(SecondQuestionMapsFragment())
            }
            R.id.btnRadioSide -> {
                FirstQuestionMaps.Side
                Constants.NUMBER_OF_QUESTIONS_MAPS++
                replaceFragment(SecondQuestionMapsFragment())
            }
            R.id.btnRadioYellow -> {
                FirstQuestionMaps.Yellow
                Constants.NUMBER_OF_QUESTIONS_MAPS++
                replaceFragment(SecondQuestionMapsFragment())
            }
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
//            FirstQuestionMapsFragmentDirections.actionFirstQuestionMapsFragmentToSecondQuestionMapsFragment()
//        findNavController().navigate(action)
//    }
}