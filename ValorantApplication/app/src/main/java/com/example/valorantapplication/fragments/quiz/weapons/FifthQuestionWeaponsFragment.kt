package com.example.valorantapplication.fragments.quiz.weapons

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.valorantapplication.databinding.FragmentFifthQuestionWeaponsBinding

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
        sendAnswer()
    }

    private fun sendAnswer(){
        binding.sendFifthAnswerWeapons.setOnClickListener {
            goToNextQuestion()
        }
    }

    private fun goToNextQuestion(){
        val action =
            FifthQuestionWeaponsFragmentDirections.actionFifthQuestionWeaponsFragmentToEndOfQuizFragment()
        findNavController().navigate(action)
    }
}