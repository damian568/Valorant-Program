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
import com.example.valorantapplication.databinding.FragmentAstraBinding

class AstraFragment : Fragment() {

    private lateinit var binding: FragmentAstraBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAstraBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAbilityImages()
        clickAbility()
    }

    private fun setAbilityImages(){
        val uriQ = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt8205d4a5a6cf1fca/6039aa950efbd9779b028acd/Astra_Ability_Icons_Q_NovaPulsev2.png")
        val uriE = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt60eb8df261fc5d0b/6039aaa62eee966ee2e3d52e/Astra_Ability_Icons_E_Nebulav2.png")
        val uriC = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt9cb14de8632bd26e/6039aab70efbd9779b028ad1/Astra_Ability_Icons_C_GravityWellv2.png")
        val uriX = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt5b7c62ae295bac95/6039aac8946aa93dbe59a693/Astra_Ability_Icons_X_CosmicDividev2.png")
        Glide.with(this)
            .load(uriQ)
            .into(binding.abilityQAstra)
        Glide.with(this)
            .load(uriE)
            .into(binding.abilityEAstra)
        Glide.with(this)
            .load(uriC)
            .into(binding.abilityCAstra)
        Glide.with(this)
            .load(uriX)
            .into(binding.abilityXAstra)
    }

    private fun clickAbility(){
        binding.abilityQAstra.setOnClickListener {
            setAbilityVideo("Q - NOVA PULSE", getString(R.string.astra_ability_q), R.raw.agent_astra_q)
        }
        binding.abilityEAstra.setOnClickListener {
            setAbilityVideo("E - NEBULA", getString(R.string.astra_ability_e), R.raw.agent_astra_e)
        }
        binding.abilityCAstra.setOnClickListener {
            setAbilityVideo("C - GRAVITY WELL", getString(R.string.astra_ability_c), R.raw.agent_astra_c)
        }
        binding.abilityXAstra.setOnClickListener {
            setAbilityVideo("X - ASTRAL FORM / COSMIC DIVIDE", getString(R.string.astra_ability_x), R.raw.agent_astra_x)
        }
    }

    private fun setAbilityVideo(textName: String, textAbility: String, videoResource: Int) {
        binding.txtNameAbilityAstra.text = textName
        binding.txtAbilityAstra.text = textAbility
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + videoResource)

        binding.videoAstraAbilities.setVideoURI(uri)
        binding.videoAstraAbilities.start()

        binding.videoAstraAbilities.setOnPreparedListener(OnPreparedListener { mp ->
            mp.isLooping = true
        })
    }

    override fun onResume() {
        binding.videoAstraAbilities.resume()
        super.onResume()
    }

    override fun onPause() {
        binding.videoAstraAbilities.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoAstraAbilities.stopPlayback()
        super.onDestroy()
    }
}