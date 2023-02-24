package com.example.valorantapplication.fragments.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantapplication.Constants
import com.example.valorantapplication.R
import com.example.valorantapplication.data.PreferenceQuizUntil
import com.example.valorantapplication.data.QuizUsername
import com.example.valorantapplication.databinding.FragmentEndOfQuizBinding

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
        quiz?.let { printAndGetPoints(it) }
        quiz?.let { printUserInfo(it) }
    }

    private fun printAndGetPoints(quiz: QuizUsername?){
        if(quiz?.category.toString() == "Agents"){
            getArgsAgents()
            printTextAgents()
        }
        else if(quiz?.category.toString() == "Maps"){
            getArgsMaps()
            printTextMaps()
        }
        else if (quiz?.category.toString() == "Weapons"){
            getArgsWeapons()
            printTextWeapons()
        }
    }

    private fun printUserInfo(quiz: QuizUsername?) {
        binding.quizUsername.text = quiz?.username
        binding.category.text = quiz?.category.toString()
        setColorsOfUserInfo()
    }

    private fun printTextAgents() {
        if (Constants.AGENTS_QUIZ_POINTS == 5 || Constants.AGENTS_QUIZ_POINTS == 4 || Constants.AGENTS_QUIZ_POINTS == 3) {
            setColorsAndTextOfWin()
            binding.quizPoints.text = Constants.AGENTS_QUIZ_POINTS.toString()
        } else {
            setColorsAndTextOfLose()
            binding.quizPoints.text = Constants.AGENTS_QUIZ_POINTS.toString()
        }
    }

    private fun printTextMaps() {
        if (Constants.MAPS_QUIZ_POINTS == 5 || Constants.MAPS_QUIZ_POINTS == 4 || Constants.MAPS_QUIZ_POINTS == 3) {
            setColorsAndTextOfWin()
            binding.quizPoints.text = Constants.MAPS_QUIZ_POINTS.toString()
        } else {
            setColorsAndTextOfLose()
            binding.quizPoints.text = Constants.MAPS_QUIZ_POINTS.toString()
        }
    }

    private fun printTextWeapons() {
        if (Constants.WEAPONS_QUIZ_POINTS == 5 || Constants.WEAPONS_QUIZ_POINTS == 4 || Constants.WEAPONS_QUIZ_POINTS == 3) {
            setColorsAndTextOfWin()
            binding.quizPoints.text = Constants.WEAPONS_QUIZ_POINTS.toString()
        } else {
            setColorsAndTextOfLose()
            binding.quizPoints.text = Constants.WEAPONS_QUIZ_POINTS.toString()
        }
    }

    private fun setColorsOfUserInfo(){
        binding.quizUsername.setTextColor(resources.getColor(R.color.black))
        binding.category.setTextColor(resources.getColor(R.color.black))
        binding.quizPoints.setTextColor(resources.getColor(R.color.black))
    }

    private fun setColorsAndTextOfWin(){
        binding.winOrLose.text = "WIN"
        binding.winOrLose.setTextColor(resources.getColor(R.color.text_color_win))
        binding.cardView.background = resources.getDrawable(R.drawable.card_gradient_background_win)
    }

    private fun setColorsAndTextOfLose(){
        binding.winOrLose.text = "LOSE"
        binding.winOrLose.setTextColor(resources.getColor(R.color.text_color_lose))
        binding.cardView.background = resources.getDrawable(R.drawable.card_gradient_background_lose)
    }

    private fun getArgsAgents() {
        val bundle = this.arguments
        if (bundle != null) {
            Constants.AGENTS_QUIZ_POINTS = bundle.getInt(Constants.ARG_CORRECT_ANSWERS)
            Constants.NUMBER_OF_QUESTIONS_AGENTS = bundle.getInt(Constants.ARG_QUESTION)
        }
    }

    private fun getArgsMaps() {
        val bundle = this.arguments
        if (bundle != null) {
            Constants.MAPS_QUIZ_POINTS = bundle.getInt(Constants.ARG_CORRECT_ANSWERS)
            Constants.NUMBER_OF_QUESTIONS_MAPS = bundle.getInt(Constants.ARG_QUESTION)
        }
    }

    private fun getArgsWeapons() {
        val bundle = this.arguments
        if (bundle != null) {
            Constants.WEAPONS_QUIZ_POINTS = bundle.getInt(Constants.ARG_CORRECT_ANSWERS)
            Constants.NUMBER_OF_QUESTIONS_WEAPONS = bundle.getInt(Constants.ARG_QUESTION)
        }
    }
}