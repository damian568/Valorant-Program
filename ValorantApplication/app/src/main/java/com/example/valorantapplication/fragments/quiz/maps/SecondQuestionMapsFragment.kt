package com.example.valorantapplication.fragments.quiz.maps

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantapplication.constants.Constants
import com.example.valorantapplication.R
import com.example.valorantapplication.bundle
import com.example.valorantapplication.databinding.FragmentSecondQuestionMapsBinding
import com.example.valorantapplication.enums.SecondQuestionMaps
import com.example.valorantapplication.fragments.quiz.agents.SecondQuestionAgentsFragment

class SecondQuestionMapsFragment : Fragment() {

    private lateinit var binding: FragmentSecondQuestionMapsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSecondQuestionMapsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgsMaps()
        clickButtons()
    }

    private fun clickButtons(){
        binding.sendSecondThAnswerMaps.setOnClickListener {
            getSelectRadioBtnValue()
        }
    }

    private fun getSelectRadioBtnValue(){
        when(binding.radioGroupNameOfMap.checkedRadioButtonId){
            R.id.radioBtnFracture -> {
                SecondQuestionMaps.Fracture
                Constants.NUMBER_OF_QUESTIONS_MAPS++
                Constants.MAPS_QUIZ_POINTS++
                replaceFragment(ThirdQuestionMapsFragment())
            }
            R.id.radioBtnIcebox -> {
                SecondQuestionMaps.Icebox
                Constants.NUMBER_OF_QUESTIONS_MAPS++
                replaceFragment(ThirdQuestionMapsFragment())
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
//            SecondQuestionMapsFragmentDirections.actionSecondQuestionMapsFragmentToThirdQuestionMapsFragment()
//        findNavController().navigate(action)
//    }
}