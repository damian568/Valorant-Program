package com.example.valorantapplication.fragments.quiz.agents

import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.valorantapplication.databinding.FragmentFirstQuestionAgentsBinding
import kotlinx.android.synthetic.main.fragment_first_question_agents.view.*


class FirstQuestionAgentsFragment : Fragment() {

    private lateinit var binding: FragmentFirstQuestionAgentsBinding
//    private var mediaPlayer: MediaPlayer? = null
    private var soundPool: SoundPool? = null
    private var sound1 = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFirstQuestionAgentsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startVoiceLine()
        sendAnswer()
    }

    private fun startVoiceLine(){
        binding.voiceLine.setOnClickListener {
//            val uri = "android.resource://" + activity!!.packageName + "/" + com.example.valorantapplication.R.raw.reyna
//            mediaPlayer = MediaPlayer()
//            mediaPlayer?.setAudioStreamType(AudioManager.STREAM_MUSIC)
//
//            try {
//                mediaPlayer?.setDataSource(uri)
//                mediaPlayer?.stop()
//            }
//            catch (e: IOException){
//                e.printStackTrace()
//            }
//
//            Toast.makeText(this.context, "Audio started playing", Toast.LENGTH_SHORT).show()

//            soundPool = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                val audioAttributes = AudioAttributes.Builder()
//                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
//                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
//                    .build()
//                SoundPool.Builder()
//                    .setMaxStreams(1)
//                    .setAudioAttributes(audioAttributes)
//                    .build()
//            } else {
//                SoundPool(1, AudioManager.STREAM_MUSIC, 0)
//            }
//
//            sound1 = soundPool!!.load(this.context, com.example.valorantapplication.R.raw.reyna, 1)
            makeIconInvisible()
        }
    }

//    fun playSound(v: View) {
//        when (v.voiceLine) {
//            binding.voiceLine -> {
//                soundPool!!.play(sound1, 1f, 1f, 0, 0, 1f)
//                soundPool!!.autoPause()
//            }
//        }
//    }

//    override fun onDestroy() {
//        super.onDestroy()
//        soundPool!!.release()
//        soundPool = null
//    }

//    override fun onDestroy() {
//        super.onDestroy()
//        mediaPlayer?.release()
//        mediaPlayer = null
//    }

    private fun makeIconInvisible(){
        binding.voiceLine.visibility = View.INVISIBLE
    }

    private fun sendAnswer(){
        binding.sendFirstAnswerAgents.setOnClickListener {
            goToNextQuestion()
        }
    }

    private fun goToNextQuestion(){
        val action =
            FirstQuestionAgentsFragmentDirections.actionFirstQuestionAgentsFragmentToSecondQuestionAgentsFragment()
        findNavController().navigate(action)
    }
}