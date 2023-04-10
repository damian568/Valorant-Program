package com.example.valorantapplication.fragments.info

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.valorantapplication.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentInfoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        setBackgroundVideo()
        clickBtnLearnTheGame()
    }

    private fun clickBtnLearnTheGame(){
        binding.btnLearnTheGame.setOnClickListener {
            goToBeginnerFragment()
        }
    }

    private fun goToBeginnerFragment(){
        val action =
            InfoFragmentDirections.actionInfoFragmentToBeginnerFragment()
        findNavController().navigate(action)
    }

    private fun setBackgroundVideo(){
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + com.example.valorantapplication.R.raw.valorant_game_play_info)

        binding.videoInfo.setVideoURI(uri)
        binding.videoInfo.start()

        binding.videoInfo.setOnPreparedListener(MediaPlayer.OnPreparedListener { mp ->
            mp.isLooping = true
        })
    }

    override fun onResume() {
        binding.videoInfo.resume()
        super.onResume()
    }

    override fun onPause() {
        binding.videoInfo.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoInfo.stopPlayback()
        super.onDestroy()
    }
}