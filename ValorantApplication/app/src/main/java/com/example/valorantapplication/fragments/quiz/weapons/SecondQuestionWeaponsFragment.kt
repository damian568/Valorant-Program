package com.example.valorantapplication.fragments.quiz.weapons

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.valorantapplication.Constants
import com.example.valorantapplication.R
import com.example.valorantapplication.databinding.FragmentSecondQuestionWeaponsBinding
import com.example.valorantapplication.enums.SecondQuestionMaps
import com.example.valorantapplication.enums.SecondQuestionWeapons

class SecondQuestionWeaponsFragment : Fragment() {

    private lateinit var binding: FragmentSecondQuestionWeaponsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondQuestionWeaponsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sendAnswer()
    }

    private fun sendAnswer(){
        binding.sendSecondThAnswerWeapons.setOnClickListener {
            getSelectRadioBtnValue()
        }
    }

    private fun getSelectRadioBtnValue(){
        when(binding.radioGroupCategory.checkedRadioButtonId){
            R.id.btnRadioRIFLES -> {
                SecondQuestionWeapons.Rifle
                Constants.NUMBER_OF_QUESTIONS_WEAPONS++
                goToNextQuestion()
            }
            R.id.btnRadioSMGS -> {
                SecondQuestionWeapons.Smg
                Constants.NUMBER_OF_QUESTIONS_WEAPONS++
                Constants.WEAPONS_QUIZ_POINTS++
                goToNextQuestion()
            }
        }
    }

    private fun goToNextQuestion(){
        val action =
            SecondQuestionWeaponsFragmentDirections.actionSecondQuestionWeaponsFragmentToThirdQuestionWeaponsFragment()
        findNavController().navigate(action)
    }
}