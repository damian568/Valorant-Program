package com.example.valorantapplication.fragments.quiz.agents

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.valorantapplication.Constants
import com.example.valorantapplication.ConstantsAnswers
import com.example.valorantapplication.R
import com.example.valorantapplication.bundle
import com.example.valorantapplication.databinding.FragmentFirstQuestionAgentsBinding

class FirstQuestionAgentsFragment : Fragment() {

    private lateinit var binding: FragmentFirstQuestionAgentsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFirstQuestionAgentsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgsAgents()
        startVoiceLine()
        sendAnswer()
    }

    private fun startVoiceLine(){
        binding.voiceLine.setOnClickListener {
            playVideo()
            makeIconInvisible()
        }
    }

    private fun playVideo(){
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + com.example.valorantapplication.R.raw.reyna)

        binding.videoReyna.setVideoURI(uri)
        binding.videoReyna.alpha = 0f
        binding.videoReyna.start()

        binding.videoReyna.setOnPreparedListener(MediaPlayer.OnPreparedListener { mp ->
            mp.isLooping = false
        })
    }

    override fun onPause() {
        binding.videoReyna.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoReyna.stopPlayback()
        super.onDestroy()
    }

    private fun makeIconInvisible(){
        binding.voiceLine.visibility = View.INVISIBLE
    }

    private fun sendAnswer(){
        binding.sendFirstAnswerAgents.setOnClickListener {
            checkingAnswer()
        }
    }

    private fun checkingAnswer(){
        if(binding.firstAnswer.text.toString() == ConstantsAnswers.ANSWER_OF_FIRST_QUESTION_AGENTS){
            Constants.AGENTS_QUIZ_POINTS++
            Constants.NUMBER_OF_QUESTIONS_AGENTS++
            replaceFragment(SecondQuestionAgentsFragment())
        }
        else{
            Constants.NUMBER_OF_QUESTIONS_AGENTS++
            replaceFragment(SecondQuestionAgentsFragment())
        }
    }

    private fun putBundle(){
        bundle.putInt(Constants.ARG_QUESTION, Constants.NUMBER_OF_QUESTIONS_AGENTS)
        bundle.putInt(Constants.ARG_CORRECT_ANSWERS, Constants.AGENTS_QUIZ_POINTS)
        val fragment = SecondQuestionAgentsFragment()
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