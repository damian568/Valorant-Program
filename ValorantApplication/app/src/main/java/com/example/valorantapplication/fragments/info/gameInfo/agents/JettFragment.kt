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
import com.example.valorantapplication.databinding.FragmentJettBinding

class JettFragment : Fragment() {

    private lateinit var binding: FragmentJettBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentJettBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAbilityImages()
        clickAbility()
    }

    private fun setAbilityImages(){
        val uriQ = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltce7928301a67a33a/5eaf861103f6e72ff388cc20/TX_Jett_Q.png")
        val uriE = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blta0beeaa4a7e1ed78/5eaf8611b8a6356e4ddc1013/TX_Jett_E.png")
        val uriC = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltf137993847c71770/5eaf8611d4b10d15d3e8db4e/TX_Jett_C.png")
        val uriX = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltb3e956f9fb96318e/5eaf86112b79652f27c32a06/TX_Jett_X.png")
        Glide.with(this)
            .load(uriQ)
            .into(binding.abilityQJett)
        Glide.with(this)
            .load(uriE)
            .into(binding.abilityEJett)
        Glide.with(this)
            .load(uriC)
            .into(binding.abilityCJett)
        Glide.with(this)
            .load(uriX)
            .into(binding.abilityXJett)
    }

    private fun clickAbility(){
        binding.abilityQJett.setOnClickListener {
            setAbilityVideo("Q - UPDRAFT", getString(R.string.jett_ability_q), R.raw.agent_jett_q)
        }
        binding.abilityEJett.setOnClickListener {
            setAbilityVideo("E - TAILWIND", getString(R.string.jett_ability_e), R.raw.agent_jett_e)
        }
        binding.abilityCJett.setOnClickListener {
            setAbilityVideo("C - CLOUDBURST", getString(R.string.jett_ability_c), R.raw.agent_jett_c)
        }
        binding.abilityXJett.setOnClickListener {
            setAbilityVideo("X - BLADE STORM", getString(R.string.jett_ability_x), R.raw.agent_jett_x)
        }
    }

    private fun setAbilityVideo(textName: String, textAbility: String, videoResource: Int) {
        binding.txtNameAbilityJett.text = textName
        binding.txtAbilityJett.text = textAbility
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + videoResource)

        binding.videoJettAbilities.setVideoURI(uri)
        binding.videoJettAbilities.start()

        binding.videoJettAbilities.setOnPreparedListener(OnPreparedListener { mp ->
            mp.isLooping = true
        })
    }

    override fun onResume() {
        binding.videoJettAbilities.resume()
        super.onResume()
    }

    override fun onPause() {
        binding.videoJettAbilities.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoJettAbilities.stopPlayback()
        super.onDestroy()
    }
}