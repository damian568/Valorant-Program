package com.example.valorantapplication.fragments.quiz.weapons

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.valorantapplication.Constants
import com.example.valorantapplication.ConstantsAnswers
import com.example.valorantapplication.R
import com.example.valorantapplication.bundle
import com.example.valorantapplication.databinding.FragmentFifthQuestionWeaponsBinding
import com.example.valorantapplication.fragments.quiz.EndOfQuizFragment
import com.example.valorantapplication.fragments.quiz.agents.SecondQuestionAgentsFragment

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
        getArgsWeapons()
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
            replaceFragment(EndOfQuizFragment())
        }
        else{
            Constants.NUMBER_OF_QUESTIONS_WEAPONS++
            replaceFragment(EndOfQuizFragment())
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
//            FifthQuestionWeaponsFragmentDirections.actionFifthQuestionWeaponsFragmentToEndOfQuizFragment()
//        findNavController().navigate(action)
//    }
}