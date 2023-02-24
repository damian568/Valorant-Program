package com.example.valorantapplication.fragments.quiz.agents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantapplication.Constants
import com.example.valorantapplication.R
import com.example.valorantapplication.bundle
import com.example.valorantapplication.databinding.FragmentSecondQuestionAgentsBinding

class SecondQuestionAgentsFragment : Fragment() {

    private lateinit var binding: FragmentSecondQuestionAgentsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSecondQuestionAgentsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgsAgents()
        clickButtons()
    }

    private fun clickButtons(){
        binding.btnSova.setOnClickListener {
            Constants.NUMBER_OF_QUESTIONS_AGENTS++
            replaceFragment(ThirdQuestionAgentsFragment())
        }

        binding.btnChamber.setOnClickListener {
            Constants.AGENTS_QUIZ_POINTS++
            Constants.NUMBER_OF_QUESTIONS_AGENTS++
            replaceFragment(ThirdQuestionAgentsFragment())
        }

        binding.btnHarbor.setOnClickListener {
            Constants.NUMBER_OF_QUESTIONS_AGENTS++
            replaceFragment(ThirdQuestionAgentsFragment())
        }

        binding.btnBrim.setOnClickListener {
            Constants.NUMBER_OF_QUESTIONS_AGENTS++
            replaceFragment(ThirdQuestionAgentsFragment())
        }
    }

    private fun putBundle(){
        bundle.putInt(Constants.ARG_QUESTION, Constants.NUMBER_OF_QUESTIONS_AGENTS)
        bundle.putInt(Constants.ARG_CORRECT_ANSWERS, Constants.AGENTS_QUIZ_POINTS)
        val fragment = ThirdQuestionAgentsFragment()
        fragment.arguments = bundle
    }

    private fun getArgsAgents() {
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
}