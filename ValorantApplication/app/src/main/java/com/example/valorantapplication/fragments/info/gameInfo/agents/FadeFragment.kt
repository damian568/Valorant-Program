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
import com.example.valorantapplication.databinding.FragmentFadeBinding

class FadeFragment : Fragment() {

    private lateinit var binding: FragmentFadeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFadeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAbilityImages()
        clickAbility()
    }

    private fun setAbilityImages(){
        val uriQ = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt80d49ffb1f533029/625db8131574214ead41fc2f/Fade_-_Q_-_Seize.png")
        val uriE = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltff792b334e149272/625db875fd9afd4b1fe2fbf2/Fade_-_E_-_Haunt.png")
        val uriC = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltc12f51743ac56940/625db87d7e7b344b2534f838/Fade_-_C_-_Prowler.png")
        val uriX = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt70f96353cf61d295/625db8887e7b344b2534f83c/Fade_-_X_-_Nightfall.png")
        Glide.with(this)
            .load(uriQ)
            .into(binding.abilityQFade)
        Glide.with(this)
            .load(uriE)
            .into(binding.abilityEFade)
        Glide.with(this)
            .load(uriC)
            .into(binding.abilityCFade)
        Glide.with(this)
            .load(uriX)
            .into(binding.abilityXFade)
    }

    private fun clickAbility(){
        binding.abilityQFade.setOnClickListener {
            setAbilityVideo("Q - SEIZE", getString(R.string.fade_ability_q), R.raw.agent_fade_q)
        }
        binding.abilityEFade.setOnClickListener {
            setAbilityVideo("E - HAUNT", getString(R.string.fade_ability_e), R.raw.agent_fade_e)
        }
        binding.abilityCFade.setOnClickListener {
            setAbilityVideo("C - PROWLER", getString(R.string.fade_ability_c), R.raw.agent_fade_c)
        }
        binding.abilityXFade.setOnClickListener {
            setAbilityVideo("X - NIGHTFALL", getString(R.string.fade_ability_x), R.raw.agent_fade_x)
        }
    }

    private fun setAbilityVideo(textName: String, textAbility: String, videoResource: Int) {
        binding.txtNameAbilityFade.text = textName
        binding.txtAbilityFade.text = textAbility
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + videoResource)

        binding.videoFadeAbilities.setVideoURI(uri)
        binding.videoFadeAbilities.start()

        binding.videoFadeAbilities.setOnPreparedListener(OnPreparedListener { mp ->
            mp.isLooping = true
        })
    }

    override fun onResume() {
        binding.videoFadeAbilities.resume()
        super.onResume()
    }

    override fun onPause() {
        binding.videoFadeAbilities.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoFadeAbilities.stopPlayback()
        super.onDestroy()
    }
}