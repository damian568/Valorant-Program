package com.example.valorantapplication.fragments.quiz.agents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.valorantapplication.Constants
import com.example.valorantapplication.R
import com.example.valorantapplication.bundle
import com.example.valorantapplication.databinding.FragmentFifthQuestionAgentsBinding
import com.example.valorantapplication.fragments.EndOfQuizFragment

class FifthQuestionAgentsFragment : Fragment() {

    private lateinit var binding: FragmentFifthQuestionAgentsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFifthQuestionAgentsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgs()
        sendAnswer()
    }

    private fun sendAnswer(){
        binding.imgSova.setOnClickListener {
            Constants.AGENTS_QUIZ_POINTS++
            Constants.NUMBER_OF_QUESTIONS_AGENTS++
            replaceFragment(EndOfQuizFragment())
        }

        binding.imgViper.setOnClickListener {
            Constants.NUMBER_OF_QUESTIONS_AGENTS++
            replaceFragment(EndOfQuizFragment())
        }
    }

    private fun putBundle(){
        bundle.putInt(Constants.ARG_QUESTION, Constants.NUMBER_OF_QUESTIONS_AGENTS)
        bundle.putInt(Constants.ARG_CORRECT_ANSWERS, Constants.AGENTS_QUIZ_POINTS)
        val fragment = EndOfQuizFragment()
        fragment.arguments = bundle
    }

    private fun getArgs() {
        val bundle = this.arguments
        if (bundle != null) {
            Constants.AGENTS_QUIZ_POINTS = bundle.getInt(Constants.ARG_CORRECT_ANSWERS)
            Constants.NUMBER_OF_QUESTIONS_AGENTS = bundle.getInt(Constants.ARG_QUESTION)
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
//        putBundle()
//        val action =
//            FifthQuestionAgentsFragmentDirections.actionFifthQuestionAgentsFragmentToEndOfQuizFragment()
//        findNavController().navigate(action)
//    }
}