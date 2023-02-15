package com.example.valorantapplication.fragments.quiz.maps

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.valorantapplication.Constants
import com.example.valorantapplication.R
import com.example.valorantapplication.databinding.FragmentSecondQuestionMapsBinding
import com.example.valorantapplication.enums.SecondQuestionMaps

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
                goToNextQuestion()
            }
            R.id.radioBtnIcebox -> {
                SecondQuestionMaps.Icebox
                Constants.NUMBER_OF_QUESTIONS_MAPS++
                goToNextQuestion()
            }
        }
    }

    private fun goToNextQuestion(){
        val action =
            SecondQuestionMapsFragmentDirections.actionSecondQuestionMapsFragmentToThirdQuestionMapsFragment()
        findNavController().navigate(action)
    }
}