package com.example.valorantapplication.fragments.quiz.agents

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantapplication.constants.Constants
import com.example.valorantapplication.constants.ConstantsAnswers
import com.example.valorantapplication.R
import com.example.valorantapplication.bundle
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
        getArgsAgents()
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
            replaceFragment(FourthQuestionAgentsFragment())
        }
        else{
            Constants.NUMBER_OF_QUESTIONS_AGENTS++
            replaceFragment(FourthQuestionAgentsFragment())
        }
    }

    private fun putBundle(){
        bundle.putInt(Constants.ARG_QUESTION, Constants.NUMBER_OF_QUESTIONS_AGENTS)
        bundle.putInt(Constants.ARG_CORRECT_ANSWERS, Constants.AGENTS_QUIZ_POINTS)
        val fragment = FourthQuestionAgentsFragment()
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