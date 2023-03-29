package com.example.valorantapplication.fragments

import android.media.MediaPlayer.OnPreparedListener
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.valorantapplication.databinding.FragmentMainScreenBinding

open class MainScreenFragment : Fragment() {

    private lateinit var binding: FragmentMainScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainScreenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBackgroundVideo()
        clickBtnInfo()
        clickBtnQuiz()
    }

    private fun clickBtnInfo(){
        binding.btnInfo.setOnClickListener {
            goToInfoFragment()
        }
    }

    private fun clickBtnQuiz(){
        binding.btnGame.setOnClickListener {
            goToQuizGameFragment()
        }
    }

    private fun goToQuizGameFragment(){
        val action =
            MainScreenFragmentDirections.actionMainScreenFragmentToQuizFragment()
        findNavController().navigate(action)
    }

    private fun goToInfoFragment(){
        val action =
            MainScreenFragmentDirections.actionMainScreenFragmentToInfoFragment()
        findNavController().navigate(action)
    }

    private fun setBackgroundVideo(){
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + com.example.valorantapplication.R.raw.valorant)

        binding.video.setVideoURI(uri)
        binding.video.start()

        binding.video.setOnPreparedListener(OnPreparedListener { mp -> mp.isLooping = true })
    }

    override fun onResume() {
        binding.video.resume()
        super.onResume()
    }

    override fun onPause() {
        binding.video.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.video.stopPlayback()
        super.onDestroy()
    }
}