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
import com.example.valorantapplication.databinding.FragmentBreachBinding

class BreachFragment : Fragment() {

    private lateinit var binding: FragmentBreachBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBreachBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAbilityImages()
        clickAbility()
    }

    private fun setAbilityImages(){
        val uriQ = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltf7b0c621601e5577/5eaf863af66b2515dea76b40/TX_Breach_Q.png")
        val uriE = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt40b144165bebbb57/5eaf863aa20afe612d82fb54/TX_Breach_E.png")
        val uriC = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltd59235294cc21d88/5eaf863acf88d36e47cf02b1/TX_Breach_C.png")
        val uriX = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltb39bc3e8df9012dc/5eaf863ad238e314f259fa93/TX_Breach_X.png")
        Glide.with(this)
            .load(uriQ)
            .into(binding.abilityQBreach)
        Glide.with(this)
            .load(uriE)
            .into(binding.abilityEBreach)
        Glide.with(this)
            .load(uriC)
            .into(binding.abilityCBreach)
        Glide.with(this)
            .load(uriX)
            .into(binding.abilityXBreach)
    }

    private fun clickAbility(){
        binding.abilityQBreach.setOnClickListener {
            setAbilityVideo("Q - FLASHPOINT", getString(R.string.breach_ability_q), R.raw.agent_breach_q)
        }
        binding.abilityEBreach.setOnClickListener {
            setAbilityVideo("E - FAULT LINE", getString(R.string.breach_ability_e), R.raw.agent_breach_e)
        }
        binding.abilityCBreach.setOnClickListener {
            setAbilityVideo("C - AFTERSHOCK", getString(R.string.breach_ability_c), R.raw.agent_breach_c)
        }
        binding.abilityXBreach.setOnClickListener {
            setAbilityVideo("X - ROLLING THUNDER", getString(R.string.breach_ability_x), R.raw.agent_breach_x)
        }
    }

    private fun setAbilityVideo(textName: String, textAbility: String, videoResource: Int) {
        binding.txtNameAbilityBreach.text = textName
        binding.txtAbilityBreach.text = textAbility
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + videoResource)

        binding.videoBreachAbilities.setVideoURI(uri)
        binding.videoBreachAbilities.start()

        binding.videoBreachAbilities.setOnPreparedListener(OnPreparedListener { mp ->
            mp.isLooping = true
        })
    }

    override fun onResume() {
        binding.videoBreachAbilities.resume()
        super.onResume()
    }

    override fun onPause() {
        binding.videoBreachAbilities.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoBreachAbilities.stopPlayback()
        super.onDestroy()
    }
}