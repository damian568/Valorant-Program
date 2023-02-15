package com.example.valorantapplication.fragments.quiz.maps

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.valorantapplication.Constants
import com.example.valorantapplication.R
import com.example.valorantapplication.databinding.FragmentFirstQuestionMapsBinding
import com.example.valorantapplication.enums.FirstQuestionMaps
import com.example.valorantapplication.enums.FourthQuestionAgents

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
                goToNextQuestion()
            }
            R.id.btnRadioSide -> {
                FirstQuestionMaps.Side
                Constants.NUMBER_OF_QUESTIONS_MAPS++
                goToNextQuestion()
            }
            R.id.btnRadioYellow -> {
                FirstQuestionMaps.Yellow
                Constants.NUMBER_OF_QUESTIONS_MAPS++
                goToNextQuestion()
            }
        }
    }

    private fun goToNextQuestion(){
        val action =
            FirstQuestionMapsFragmentDirections.actionFirstQuestionMapsFragmentToSecondQuestionMapsFragment()
        findNavController().navigate(action)
    }
}