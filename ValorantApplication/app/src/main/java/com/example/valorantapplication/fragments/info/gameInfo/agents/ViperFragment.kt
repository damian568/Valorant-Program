package com.example.valorantapplication.fragments.info.gameInfo.agents

import android.media.MediaPlayer.OnPreparedListener
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantapplication.R
import com.example.valorantapplication.databinding.FragmentViperBinding

class ViperFragment : Fragment() {

    private lateinit var binding: FragmentViperBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViperBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickViperAbility()
    }

    private fun clickViperAbility(){
        binding.abilityQViper.setOnClickListener {
            setViperAbilityVideo("Q - POISON CLOUD", getString(R.string.viper_ability_q), R.raw.agent_viper_q)
        }
        binding.abilityEViper.setOnClickListener {
            setViperAbilityVideo("E - TOXIC SCREEN", getString(R.string.viper_ability_e), R.raw.agent_viper_e)
        }
        binding.abilityCViper.setOnClickListener {
            setViperAbilityVideo("C - SNAKE BITE", getString(R.string.viper_ability_c), R.raw.agent_viper_c)
        }
        binding.abilityXViper.setOnClickListener {
            setViperAbilityVideo("X - VIPER’S PIT", getString(R.string.viper_ability_x), R.raw.agent_viper_x)
        }
    }

    private fun setViperAbilityVideo(textName: String, textAbility: String, videoResource: Int) {
        binding.txtNameAbilityViper.text = textName
        binding.txtAbilityViper.text = textAbility
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + videoResource)

        binding.videoViperAbilities.setVideoURI(uri)
        binding.videoViperAbilities.start()

        binding.videoViperAbilities.setOnPreparedListener(OnPreparedListener { mp ->
            mp.isLooping = true
        })
    }

    override fun onResume() {
        binding.videoViperAbilities.resume()
        super.onResume()
    }

    override fun onPause() {
        binding.videoViperAbilities.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoViperAbilities.stopPlayback()
        super.onDestroy()
    }
}