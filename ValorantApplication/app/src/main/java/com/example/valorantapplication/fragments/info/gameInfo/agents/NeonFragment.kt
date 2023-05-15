package com.example.valorantapplication.fragments.info.gameInfo.agents

import android.media.MediaPlayer.OnPreparedListener
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.valorantapplication.R
import com.example.valorantapplication.databinding.FragmentNeonBinding

class NeonFragment : Fragment() {

    private lateinit var binding: FragmentNeonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNeonBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAbilityImages()
        clickAbility()
    }

    private fun setAbilityImages(){
        val uriQ = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt10d37aa745665f36/61d8a80814ef402247ceab30/Neon_Q-Relay_Bolt.png")
        val uriE = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltc7f73a2cfc4e3e44/61d8a8181757dc6aed2ada7c/Neon_E-High_Gear.png")
        val uriC = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt50ac2316cddbb64d/61d8a8209efff26ae759809a/Neon_C-Fast_Lane.png")
        val uriX = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltcf74e9670f324266/61d8a829997c0e224de09fae/Neon_X-Overdrive.png")
        Glide.with(this)
            .load(uriQ)
            .into(binding.abilityQNeon)
        Glide.with(this)
            .load(uriE)
            .into(binding.abilityENeon)
        Glide.with(this)
            .load(uriC)
            .into(binding.abilityCNeon)
        Glide.with(this)
            .load(uriX)
            .into(binding.abilityXNeon)
    }

    private fun clickAbility(){
        binding.abilityQNeon.setOnClickListener {
            setAbilityVideo("Q - RELAY BOLT", getString(R.string.neon_ability_q), R.raw.agent_neon_q)
        }
        binding.abilityENeon.setOnClickListener {
            setAbilityVideo("E - HIGH GEAR", getString(R.string.neon_ability_e), R.raw.agent_neon_e)
        }
        binding.abilityCNeon.setOnClickListener {
            setAbilityVideo("C - FAST LANE", getString(R.string.neon_ability_c), R.raw.agent_neon_c)
        }
        binding.abilityXNeon.setOnClickListener {
            setAbilityVideo("X - OVERDRIVE", getString(R.string.neon_ability_x), R.raw.agent_neon_x)
        }
    }

    private fun setAbilityVideo(textName: String, textAbility: String, videoResource: Int) {
        binding.txtNameAbilityNeon.text = textName
        binding.txtAbilityNeon.text = textAbility
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + videoResource)

        binding.videoNeonAbilities.setVideoURI(uri)
        binding.videoNeonAbilities.start()

        binding.videoNeonAbilities.setOnPreparedListener(OnPreparedListener { mp ->
            mp.isLooping = true
        })
    }

    override fun onResume() {
        binding.videoNeonAbilities.resume()
        super.onResume()
    }

    override fun onPause() {
        binding.videoNeonAbilities.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoNeonAbilities.stopPlayback()
        super.onDestroy()
    }
}