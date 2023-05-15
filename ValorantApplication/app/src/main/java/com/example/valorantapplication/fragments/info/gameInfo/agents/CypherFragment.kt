package com.example.valorantapplication.fragments.info.gameInfo.agents

import android.media.MediaPlayer.OnPreparedListener
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.valorantapplication.R
import com.example.valorantapplication.databinding.FragmentCypherBinding

class CypherFragment : Fragment() {

    private lateinit var binding: FragmentCypherBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCypherBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickCypherAbility()
    }

    private fun clickCypherAbility(){
        binding.abilityQCypher.setOnClickListener {
            setCypherAbilityVideo("Q - CYBER CAGE", getString(R.string.cypher_ability_q), R.raw.agent_cypher_q)
        }
        binding.abilityECypher.setOnClickListener {
            setCypherAbilityVideo("E - SPYCAM", getString(R.string.cypher_ability_e), R.raw.agent_cypher_e)
        }
        binding.abilityCCypher.setOnClickListener {
            setCypherAbilityVideo("C - TRAPWIRE", getString(R.string.cypher_ability_c), R.raw.agent_cypher_c)
        }
        binding.abilityXCypher.setOnClickListener {
            setCypherAbilityVideo("X - NEURAL THEFT", getString(R.string.cypher_ability_x), R.raw.agent_cypher_x)
        }
    }

    private fun setCypherAbilityVideo(textName: String, textAbility: String, videoResource: Int) {
        binding.txtNameAbilityCypher.text = textName
        binding.txtAbilityCypher.text = textAbility
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + videoResource)

        binding.videoCypherAbilities.setVideoURI(uri)
        binding.videoCypherAbilities.start()

        binding.videoCypherAbilities.setOnPreparedListener(OnPreparedListener { mp ->
            mp.isLooping = true
        })
    }

    override fun onResume() {
        binding.videoCypherAbilities.resume()
        super.onResume()
    }

    override fun onPause() {
        binding.videoCypherAbilities.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoCypherAbilities.stopPlayback()
        super.onDestroy()
    }
}