package com.example.valorantapplication.fragments.info.gameInfo.agents

import android.media.MediaPlayer.OnPreparedListener
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantapplication.R
import com.example.valorantapplication.databinding.FragmentReynaBinding

class ReynaFragment : Fragment() {

    private lateinit var binding: FragmentReynaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReynaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickReynaAbility()
    }

    private fun clickReynaAbility(){
        binding.abilityQReyna.setOnClickListener {
            setReynaAbilityVideo("Q - DEVOUR", getString(R.string.reyna_ability_q), R.raw.agent_reyna_q)
        }
        binding.abilityEReyna.setOnClickListener {
            setReynaAbilityVideo("E - DISMISS", getString(R.string.reyna_ability_e), R.raw.agent_reyna_e)
        }
        binding.abilityCReyna.setOnClickListener {
            setReynaAbilityVideo("C - LEER", getString(R.string.reyna_ability_c), R.raw.agent_reyna_c)
        }
        binding.abilityXReyna.setOnClickListener {
            setReynaAbilityVideo("X - EMPRESS", getString(R.string.reyna_ability_x), R.raw.agent_reyna_x)
        }
    }

    private fun setReynaAbilityVideo(textName: String, textAbility: String, videoResource: Int) {
        binding.txtNameAbilityReyna.text = textName
        binding.txtAbilityReyna.text = textAbility
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + videoResource)

        binding.videoReynaAbilities.setVideoURI(uri)
        binding.videoReynaAbilities.start()

        binding.videoReynaAbilities.setOnPreparedListener(OnPreparedListener { mp ->
            mp.isLooping = true
        })
    }

    override fun onResume() {
        binding.videoReynaAbilities.resume()
        super.onResume()
    }

    override fun onPause() {
        binding.videoReynaAbilities.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoReynaAbilities.stopPlayback()
        super.onDestroy()
    }
}