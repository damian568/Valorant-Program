package com.example.valorantapplication.fragments.quiz.weapons

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.valorantapplication.Constants
import com.example.valorantapplication.R
import com.example.valorantapplication.bundle
import com.example.valorantapplication.databinding.FragmentFourthQuestionWeaponsBinding
import com.example.valorantapplication.fragments.quiz.agents.SecondQuestionAgentsFragment

class FourthQuestionWeaponsFragment : Fragment() {

    private lateinit var binding: FragmentFourthQuestionWeaponsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFourthQuestionWeaponsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgsWeapons()
        startSound()
        sendAnswer()
    }

    private fun startSound(){
        binding.soundOfElderFlameVandal.setOnClickListener {
            playVideo()
            makeIconInvisible()
        }
    }

    private fun playVideo(){
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + com.example.valorantapplication.R.raw.elderflame_vandal)

        binding.videoBundleVandal.setVideoURI(uri)
        binding.videoBundleVandal.alpha = 0f
        binding.videoBundleVandal.start()

        binding.videoBundleVandal.setOnPreparedListener(MediaPlayer.OnPreparedListener { mp ->
            mp.isLooping = false
        })
    }

    override fun onPause() {
        binding.videoBundleVandal.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoBundleVandal.stopPlayback()
        super.onDestroy()
    }

    private fun makeIconInvisible(){
        binding.soundOfElderFlameVandal.visibility = View.INVISIBLE
    }

    private fun sendAnswer(){
        binding.btnElderFlameFrenzy.setOnClickListener {
            Constants.NUMBER_OF_QUESTIONS_WEAPONS++
            replaceFragment(FifthQuestionWeaponsFragment())
        }
        binding.btnSentinelVandal.setOnClickListener {
            Constants.NUMBER_OF_QUESTIONS_WEAPONS++
            replaceFragment(FifthQuestionWeaponsFragment())
        }
        binding.btnRuinationPhantom.setOnClickListener {
            Constants.NUMBER_OF_QUESTIONS_WEAPONS++
            replaceFragment(FifthQuestionWeaponsFragment())
        }
        binding.btnElderFlameVandal.setOnClickListener {
            Constants.WEAPONS_QUIZ_POINTS++
            Constants.NUMBER_OF_QUESTIONS_WEAPONS++
            replaceFragment(FifthQuestionWeaponsFragment())
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
//            FourthQuestionWeaponsFragmentDirections.actionFourthQuestionWeaponsFragmentToFifthQuestionWeaponsFragment()
//        findNavController().navigate(action)
//    }
}