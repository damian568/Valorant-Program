package com.example.valorantapplication.fragments.quiz.agents

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
import com.example.valorantapplication.databinding.FragmentThirdQuestionAgentsBinding

class ThirdQuestionAgentsFragment : Fragment() {

    private lateinit var binding: FragmentThirdQuestionAgentsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentThirdQuestionAgentsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        playVideo()
        sendAnswer()
    }

    private fun playVideo(){
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + com.example.valorantapplication.R.raw.omen)

        binding.videoOmen.setVideoURI(uri)
        binding.videoOmen.start()

        binding.videoOmen.setOnPreparedListener(MediaPlayer.OnPreparedListener { mp ->
            mp.isLooping = false
        })
    }

    override fun onPause() {
        binding.videoOmen.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoOmen.stopPlayback()
        super.onDestroy()
    }

    private fun sendAnswer(){
        binding.sendThirdAnswerAgents.setOnClickListener {
            checkingAnswer()
        }
    }

    private fun checkingAnswer(){
        if(binding.thirdAnswer.text.toString() == ConstantsAnswers.ANSWER_OF_THIRD_QUESTION_AGENTS){
            Constants.NUMBER_OF_QUESTIONS_AGENTS++
            Constants.AGENTS_QUIZ_POINTS++
            goToNextQuestion()
        }
        else{
            Constants.NUMBER_OF_QUESTIONS_AGENTS++
            goToNextQuestion()
        }
    }

    private fun goToNextQuestion(){
        val action =
            ThirdQuestionAgentsFragmentDirections.actionThirdQuestionAgentsFragmentToFourthQuestionAgentsFragment()
        findNavController().navigate(action)
    }
}