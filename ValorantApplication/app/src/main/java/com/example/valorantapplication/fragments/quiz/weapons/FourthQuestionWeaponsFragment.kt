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
import com.example.valorantapplication.databinding.FragmentFourthQuestionWeaponsBinding

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
            goToNextQuestion()
        }
        binding.btnSentinelVandal.setOnClickListener {
            Constants.NUMBER_OF_QUESTIONS_WEAPONS++
            goToNextQuestion()
        }
        binding.btnRuinationPhantom.setOnClickListener {
            Constants.NUMBER_OF_QUESTIONS_WEAPONS++
            goToNextQuestion()
        }
        binding.btnElderFlameVandal.setOnClickListener {
            Constants.WEAPONS_QUIZ_POINTS++
            Constants.NUMBER_OF_QUESTIONS_WEAPONS++
            goToNextQuestion()
        }
    }

    private fun goToNextQuestion(){
        val action =
            FourthQuestionWeaponsFragmentDirections.actionFourthQuestionWeaponsFragmentToFifthQuestionWeaponsFragment()
        findNavController().navigate(action)
    }
}