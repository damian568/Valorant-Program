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
import com.example.valorantapplication.databinding.FragmentOmenBinding

class OmenFragment : Fragment() {

    private lateinit var binding: FragmentOmenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOmenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAbilityImages()
        clickAbility()
    }

    private fun setAbilityImages(){
        val uriQ = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt323e0178def67d36/5eaf85f4cf88d36e47cf02a5/TX_Omen_Q.png")
        val uriE = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blta95e6968cb32f519/5eaf85f44398082ffe24019b/TX_Omen_E.png")
        val uriC = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt7016fed86331500b/5eaf85f41b51e36d7c1b6ad6/TX_Omen_C.png")
        val uriX = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltd7b44696b74076d4/5eaf85f4f66b2515dea76b2c/TX_Omen_X.png")
        Glide.with(this)
            .load(uriQ)
            .into(binding.abilityQOmen)
        Glide.with(this)
            .load(uriE)
            .into(binding.abilityEOmen)
        Glide.with(this)
            .load(uriC)
            .into(binding.abilityCOmen)
        Glide.with(this)
            .load(uriX)
            .into(binding.abilityXOmen)
    }

    private fun clickAbility(){
        binding.abilityQOmen.setOnClickListener {
            setAbilityVideo("Q - PARANOIA", getString(R.string.omen_ability_q), R.raw.agent_omen_q)
        }
        binding.abilityEOmen.setOnClickListener {
            setAbilityVideo("E - DARK COVER", getString(R.string.omen_ability_e), R.raw.agent_omen_e)
        }
        binding.abilityCOmen.setOnClickListener {
            setAbilityVideo("C - SHROUDED STEP", getString(R.string.omen_ability_c), R.raw.agent_omen_c)
        }
        binding.abilityXOmen.setOnClickListener {
            setAbilityVideo("X - FROM THE SHADOWS", getString(R.string.omen_ability_x), R.raw.agent_omen_x)
        }
    }

    private fun setAbilityVideo(textName: String, textAbility: String, videoResource: Int) {
        binding.txtNameAbilityOmen.text = textName
        binding.txtAbilityOmen.text = textAbility
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + videoResource)

        binding.videoOmenAbilities.setVideoURI(uri)
        binding.videoOmenAbilities.start()

        binding.videoOmenAbilities.setOnPreparedListener(OnPreparedListener { mp ->
            mp.isLooping = true
        })
    }

    override fun onResume() {
        binding.videoOmenAbilities.resume()
        super.onResume()
    }

    override fun onPause() {
        binding.videoOmenAbilities.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoOmenAbilities.stopPlayback()
        super.onDestroy()
    }
}