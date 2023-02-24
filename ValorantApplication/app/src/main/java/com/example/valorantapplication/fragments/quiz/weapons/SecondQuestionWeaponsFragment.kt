package com.example.valorantapplication.fragments.quiz.weapons

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.valorantapplication.Constants
import com.example.valorantapplication.R
import com.example.valorantapplication.bundle
import com.example.valorantapplication.databinding.FragmentSecondQuestionWeaponsBinding
import com.example.valorantapplication.enums.SecondQuestionMaps
import com.example.valorantapplication.enums.SecondQuestionWeapons
import com.example.valorantapplication.fragments.quiz.agents.SecondQuestionAgentsFragment

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
        getArgsWeapons()
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
                replaceFragment(ThirdQuestionWeaponsFragment())
            }
            R.id.btnRadioSMGS -> {
                SecondQuestionWeapons.Smg
                Constants.NUMBER_OF_QUESTIONS_WEAPONS++
                Constants.WEAPONS_QUIZ_POINTS++
                replaceFragment(ThirdQuestionWeaponsFragment())
            }
        }
    }

    private fun putBundle(){
        bundle.putInt(Constants.ARG_QUESTION, Constants.NUMBER_OF_QUESTIONS_WEAPONS)
        bundle.putInt(Constants.ARG_CORRECT_ANSWERS, Constants.WEAPONS_QUIZ_POINTS)
        val fragment = SecondQuestionAgentsFragment()
        fragment.arguments = bundle
    }

    private fun getArgsWeapons() {
        val bundle = this.arguments
        if (bundle != null) {
            Constants.WEAPONS_QUIZ_POINTS = bundle.getInt(Constants.ARG_CORRECT_ANSWERS)
            Constants.NUMBER_OF_QUESTIONS_WEAPONS = bundle.getInt(Constants.ARG_QUESTION)
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
//            SecondQuestionWeaponsFragmentDirections.actionSecondQuestionWeaponsFragmentToThirdQuestionWeaponsFragment()
//        findNavController().navigate(action)
//    }
}