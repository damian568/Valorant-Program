package com.example.valorantapplication.fragments.info.gameInfo.agents

import android.media.MediaPlayer.OnPreparedListener
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantapplication.R
import com.example.valorantapplication.databinding.FragmentPhoenixBinding

class PhoenixFragment : Fragment() {

    private lateinit var binding: FragmentPhoenixBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPhoenixBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickPhoenixAbility()
    }

    private fun clickPhoenixAbility(){
        binding.abilityQPhoenix.setOnClickListener {
            setPhoenixAbilityVideo("Q - CURVEBALL", getString(R.string.phoenix_ability_q), R.raw.agent_phoenix_q)
        }
        binding.abilityEPhoenix.setOnClickListener {
            setPhoenixAbilityVideo("E - HOT HANDS", getString(R.string.phoenix_ability_e), R.raw.agent_phoenix_e)
        }
        binding.abilityCPhoenix.setOnClickListener {
            setPhoenixAbilityVideo("C - BLAZE", getString(R.string.phoenix_ability_c), R.raw.agent_phoenix_c)
        }
        binding.abilityXPhoenix.setOnClickListener {
            setPhoenixAbilityVideo("X - RUN IT BACK", getString(R.string.phoenix_ability_x), R.raw.agent_phoenix_x)
        }
    }

    private fun setPhoenixAbilityVideo(textName: String, textAbility: String, videoResource: Int) {
        binding.txtNameAbilityPhoenix.text = textName
        binding.txtAbilityPhoenix.text = textAbility
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + videoResource)

        binding.videoPhoenixAbilities.setVideoURI(uri)
        binding.videoPhoenixAbilities.start()

        binding.videoPhoenixAbilities.setOnPreparedListener(OnPreparedListener { mp ->
            mp.isLooping = true
        })
    }

    override fun onResume() {
        binding.videoPhoenixAbilities.resume()
        super.onResume()
    }

    override fun onPause() {
        binding.videoPhoenixAbilities.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoPhoenixAbilities.stopPlayback()
        super.onDestroy()
    }
}