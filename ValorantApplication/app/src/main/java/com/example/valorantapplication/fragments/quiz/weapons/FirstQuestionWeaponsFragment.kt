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
import com.example.valorantapplication.ConstantsAnswers
import com.example.valorantapplication.databinding.FragmentFirstQuestionWeaponsBinding

class FirstQuestionWeaponsFragment : Fragment() {

    private lateinit var binding: FragmentFirstQuestionWeaponsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFirstQuestionWeaponsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        playVideo()
        sendAnswer()
    }

    private fun playVideo(){
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + com.example.valorantapplication.R.raw.judge)

        binding.videoJudge.setVideoURI(uri)
        binding.videoJudge.start()

        binding.videoJudge.setOnPreparedListener(MediaPlayer.OnPreparedListener { mp ->
            mp.isLooping = false
        })
    }

    override fun onPause() {
        binding.videoJudge.suspend()
        super.onPause()
        binding.videoJudge.alpha = 0f
    }

    override fun onDestroy() {
        binding.videoJudge.stopPlayback()
        super.onDestroy()
    }

    private fun sendAnswer(){
        binding.sendFirstAnswerWeapons.setOnClickListener {
            checkingAnswer()
        }
    }

    private fun checkingAnswer(){
        if(binding.firstAnswerWeapons.text.toString() == ConstantsAnswers.ANSWER_OF_FIRST_QUESTION_WEAPONS){
            Constants.WEAPONS_QUIZ_POINTS++
            Constants.NUMBER_OF_QUESTIONS_WEAPONS++
            goToNextQuestion()
        }
        else{
            Constants.NUMBER_OF_QUESTIONS_WEAPONS++
            goToNextQuestion()
        }
    }

    private fun goToNextQuestion(){
        val action =
            FirstQuestionWeaponsFragmentDirections.actionFirstQuestionWeaponsFragmentToSecondQuestionWeaponsFragment()
        findNavController().navigate(action)
    }
}