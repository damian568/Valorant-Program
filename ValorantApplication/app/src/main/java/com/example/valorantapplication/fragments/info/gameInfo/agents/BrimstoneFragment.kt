package com.example.valorantapplication.fragments.info.gameInfo.agents

import android.media.MediaPlayer.OnPreparedListener
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantapplication.R
import com.example.valorantapplication.databinding.FragmentBrimstoneBinding

class BrimstoneFragment : Fragment() {

    private lateinit var binding: FragmentBrimstoneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBrimstoneBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickBrimAbility()
    }

    private fun clickBrimAbility(){
        binding.abilityQBrim.setOnClickListener {
            setBrimAbilityVideo("Q - INCENDIARY", getString(R.string.brim_ability_q), R.raw.agent_brim_q)
        }
        binding.abilityEBrim.setOnClickListener {
            setBrimAbilityVideo("E - SKY SMOKE", getString(R.string.brim_ability_e), R.raw.agent_brim_e)
        }
        binding.abilityCBrim.setOnClickListener {
            setBrimAbilityVideo("C - STIM BEACON", getString(R.string.brim_ability_c), R.raw.agent_brim_c)
        }
        binding.abilityXBrim.setOnClickListener {
            setBrimAbilityVideo("X - ORBITAL STRIKE", getString(R.string.brim_ability_x), R.raw.agent_brim_x)
        }
    }

    private fun setBrimAbilityVideo(textName: String, textAbility: String, videoResource: Int) {
        binding.txtNameAbilityBrim.text = textName
        binding.txtAbilityBrim.text = textAbility
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + videoResource)

        binding.videoBrimAbilities.setVideoURI(uri)
        binding.videoBrimAbilities.start()

        binding.videoBrimAbilities.setOnPreparedListener(OnPreparedListener { mp ->
            mp.isLooping = true
        })
    }

    override fun onResume() {
        binding.videoBrimAbilities.resume()
        super.onResume()
    }

    override fun onPause() {
        binding.videoBrimAbilities.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoBrimAbilities.stopPlayback()
        super.onDestroy()
    }
}