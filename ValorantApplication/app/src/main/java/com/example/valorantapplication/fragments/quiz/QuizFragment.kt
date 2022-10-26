package com.example.valorantapplication.fragments.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.valorantapplication.R
import com.example.valorantapplication.databinding.FragmentQuizBinding
import com.example.valorantapplication.enums.QuizOn

class QuizFragment : Fragment() {

    private lateinit var binding: FragmentQuizBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentQuizBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickBtnStartGame()
    }

    private fun clickBtnStartGame() {
        binding.startGameBtn.setOnClickListener {
            verificationRadioButtons()
        }
    }

    private fun getSelectRadioBtnValue() =
        when (binding.radioGroupGender.checkedRadioButtonId) {
            R.id.btnRadioAgents -> QuizOn.Agents
            R.id.btnRadioMaps -> QuizOn.Maps
            R.id.btnRadioWeapons -> QuizOn.Weapons
            else -> QuizOn.Maps
        }

    private fun verificationRadioButtons(){
        if (getSelectRadioBtnValue().toString() == getString(R.string.agents)) {
            goToFirstQuestionAgentsFragment()
        }
        else if (getSelectRadioBtnValue().toString() == getString(R.string.maps)) {
            goToFirstQuestionMapsFragment()
        }
        else if (getSelectRadioBtnValue().toString() == getString(R.string.weapons)) {
            goToFirstQuestionWeaponsFragment()
        }
        else{
            goToFirstQuestionMapsFragment()
        }
    }

    private fun goToFirstQuestionAgentsFragment() {
        val action =
            QuizFragmentDirections.actionQuizFragmentToFirstQuestionAgentsFragment()
        findNavController().navigate(action)
    }

    private fun goToFirstQuestionMapsFragment() {
        val action =
            QuizFragmentDirections.actionQuizFragmentToFirstQuestionMapsFragment()
        findNavController().navigate(action)
    }

    private fun goToFirstQuestionWeaponsFragment() {
        val action =
            QuizFragmentDirections.actionQuizFragmentToFirstQuestionWeaponsFragment()
        findNavController().navigate(action)
    }
}