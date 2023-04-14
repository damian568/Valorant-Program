package com.example.valorantapplication.fragments.info.gameInfo.agents

import android.media.MediaPlayer.OnPreparedListener
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantapplication.R
import com.example.valorantapplication.databinding.FragmentSovaBinding

class SovaFragment : Fragment() {

    private lateinit var binding: FragmentSovaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSovaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickSovaAbility()
    }

    private fun clickSovaAbility(){
        binding.abilityQSova.setOnClickListener {
            setSovaAbilityVideo("Q - SHOCK BOLT", getString(R.string.sage_ability_q), R.raw.agent_sova_q)
        }
        binding.abilityESova.setOnClickListener {
            setSovaAbilityVideo("E - RECON BOLT", getString(R.string.sage_ability_e), R.raw.agent_sova_e)
        }
        binding.abilityCSova.setOnClickListener {
            setSovaAbilityVideo("C - OWL DRONE", getString(R.string.sage_ability_c), R.raw.agent_sova_c)
        }
        binding.abilityXSova.setOnClickListener {
            setSovaAbilityVideo("X - HUNTER’S FURY", getString(R.string.sage_ability_x), R.raw.agent_sova_x)
        }
    }

    private fun setSovaAbilityVideo(textName: String, textAbility: String, videoResource: Int) {
        binding.txtNameAbilitySova.text = textName
        binding.txtAbilitySova.text = textAbility
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + videoResource)

        binding.videoSovaAbilities.setVideoURI(uri)
        binding.videoSovaAbilities.start()

        binding.videoSovaAbilities.setOnPreparedListener(OnPreparedListener { mp ->
            mp.isLooping = true
        })
    }

    override fun onResume() {
        binding.videoSovaAbilities.resume()
        super.onResume()
    }

    override fun onPause() {
        binding.videoSovaAbilities.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoSovaAbilities.stopPlayback()
        super.onDestroy()
    }
}