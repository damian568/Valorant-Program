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
import com.example.valorantapplication.R
import com.example.valorantapplication.bundle
import com.example.valorantapplication.databinding.FragmentFirstQuestionWeaponsBinding
import com.example.valorantapplication.fragments.quiz.agents.SecondQuestionAgentsFragment

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
        getArgsWeapons()
        startWeaponsSound()
        sendAnswer()
    }

    private fun startWeaponsSound(){
        binding.soundOfJudge.setOnClickListener {
            playVideo()
            makeIconInvisible()
        }
    }

    private fun makeIconInvisible(){
        binding.soundOfJudge.visibility = View.INVISIBLE
    }

    private fun playVideo(){
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + com.example.valorantapplication.R.raw.judge)

        binding.videoJudge.setVideoURI(uri)
        binding.videoJudge.alpha = 0f
        binding.videoJudge.start()

        binding.videoJudge.setOnPreparedListener(MediaPlayer.OnPreparedListener { mp ->
            mp.isLooping = false
        })
    }

    override fun onPause() {
        binding.videoJudge.suspend()
        super.onPause()
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
            replaceFragment(SecondQuestionWeaponsFragment())
        }
        else{
            Constants.NUMBER_OF_QUESTIONS_WEAPONS++
            replaceFragment(SecondQuestionWeaponsFragment())
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
//            FirstQuestionWeaponsFragmentDirections.actionFirstQuestionWeaponsFragmentToSecondQuestionWeaponsFragment()
//        findNavController().navigate(action)
//    }
}