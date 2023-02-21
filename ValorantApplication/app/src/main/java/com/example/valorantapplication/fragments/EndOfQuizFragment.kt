package com.example.valorantapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantapplication.Constants
import com.example.valorantapplication.R
import com.example.valorantapplication.bundle
import com.example.valorantapplication.data.PreferenceQuizUntil
import com.example.valorantapplication.data.PreferenceUntil
import com.example.valorantapplication.data.QuizUsername
import com.example.valorantapplication.data.User
import com.example.valorantapplication.databinding.FragmentEndOfQuizBinding
import com.example.valorantapplication.fragments.quiz.agents.SecondQuestionAgentsFragment

class EndOfQuizFragment : Fragment() {

    private lateinit var binding: FragmentEndOfQuizBinding
    private lateinit var preferenceQuizUntil: PreferenceQuizUntil

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentEndOfQuizBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferenceQuizUntil = PreferenceQuizUntil.getInstance(view.context)
        val quiz = preferenceQuizUntil.getQuizUsernameData()
        quiz?.let { printUserInfo(it) }
        getArgs()
        printText()
    }

    private fun printUserInfo(quiz: QuizUsername?) {
        binding.quizUsername.text = quiz?.username
        binding.category.text = quiz?.category.toString()
    }

    private fun printText() {
        if (Constants.AGENTS_QUIZ_POINTS == 5 || Constants.AGENTS_QUIZ_POINTS == 4 || Constants.AGENTS_QUIZ_POINTS == 3) {
            binding.winOrLose.text = "WIN"
            binding.quizPoints.text = Constants.AGENTS_QUIZ_POINTS.toString()
        } else {
            binding.winOrLose.setTextColor(R.color.btn_game_start_color)
            binding.winOrLose.text = "LOSE"
            binding.quizPoints.text = Constants.AGENTS_QUIZ_POINTS.toString()
        }
    }

    private fun getArgs() {
        val bundle = this.arguments
        if (bundle != null) {
            Constants.AGENTS_QUIZ_POINTS = bundle.getInt(Constants.ARG_CORRECT_ANSWERS)
            Constants.NUMBER_OF_QUESTIONS_AGENTS = bundle.getInt(Constants.ARG_QUESTION)
        }
    }
}