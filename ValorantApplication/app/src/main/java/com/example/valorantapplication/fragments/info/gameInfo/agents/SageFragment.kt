package com.example.valorantapplication.fragments.info.gameInfo.agents

import android.media.MediaPlayer.OnPreparedListener
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantapplication.R
import com.example.valorantapplication.databinding.FragmentSageBinding

class SageFragment : Fragment() {

    private lateinit var binding: FragmentSageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSageBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickSageAbility()
    }

    private fun clickSageAbility(){
        binding.abilityQSage.setOnClickListener {
            setSageAbilityVideo("Q - SLOW ORB", getString(R.string.sage_ability_q), R.raw.agent_sage_q)
        }
        binding.abilityESage.setOnClickListener {
            setSageAbilityVideo("E - HEALING ORB", getString(R.string.sage_ability_e), R.raw.agent_sage_e)
        }
        binding.abilityCSage.setOnClickListener {
            setSageAbilityVideo("C - BARRIER ORB", getString(R.string.sage_ability_c), R.raw.agent_sage_c)
        }
        binding.abilityXSage.setOnClickListener {
            setSageAbilityVideo("X - RESURRECTION", getString(R.string.sage_ability_x), R.raw.agent_sage_x)
        }
    }

    private fun setSageAbilityVideo(textName: String, textAbility: String, videoResource: Int) {
        binding.txtNameAbilitySage.text = textName
        binding.txtAbilitySage.text = textAbility
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + videoResource)

        binding.videoSageAbilities.setVideoURI(uri)
        binding.videoSageAbilities.start()

        binding.videoSageAbilities.setOnPreparedListener(OnPreparedListener { mp ->
            mp.isLooping = true
        })
    }

    override fun onResume() {
        binding.videoSageAbilities.resume()
        super.onResume()
    }

    override fun onPause() {
        binding.videoSageAbilities.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoSageAbilities.stopPlayback()
        super.onDestroy()
    }
}