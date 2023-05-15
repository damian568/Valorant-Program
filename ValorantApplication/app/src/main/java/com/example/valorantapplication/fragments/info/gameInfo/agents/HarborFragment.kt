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
import com.example.valorantapplication.databinding.FragmentHarborBinding

class HarborFragment : Fragment() {

    private lateinit var binding: FragmentHarborBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHarborBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAbilityImages()
        clickAbility()
    }

    private fun setAbilityImages(){
        val uriQ = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blta7b530a6396a2fee/6348a9e88473831f96bbc3ab/TX_Mage_ShieldGrenade.png")
        val uriE = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltc713955823a626c5/6348a9e8dc111e1f95032df0/TX_Mage_WaterWall.png")
        val uriC = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt8f7e1a26b7bae10b/6348a9e8e9d2c541844df812/TX_Mage_TidalWave.png")
        val uriX = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltba6bb33d886bfa80/6348a9e85e281916980f657d/TX_Mage_Tempest.png")
        Glide.with(this)
            .load(uriQ)
            .into(binding.abilityQHarbor)
        Glide.with(this)
            .load(uriE)
            .into(binding.abilityEHarbor)
        Glide.with(this)
            .load(uriC)
            .into(binding.abilityCHarbor)
        Glide.with(this)
            .load(uriX)
            .into(binding.abilityXHarbor)
    }

    private fun clickAbility(){
        binding.abilityQHarbor.setOnClickListener {
            setAbilityVideo("Q - COVE", getString(R.string.harbor_ability_q), R.raw.agent_harbor_q)
        }
        binding.abilityEHarbor.setOnClickListener {
            setAbilityVideo("E - HIGH TIDE", getString(R.string.harbor_ability_e), R.raw.agent_harbor_e)
        }
        binding.abilityCHarbor.setOnClickListener {
            setAbilityVideo("C - CASCADE", getString(R.string.harbor_ability_c), R.raw.agent_harbor_c)
        }
        binding.abilityXHarbor.setOnClickListener {
            setAbilityVideo("X - RECKONING", getString(R.string.harbor_ability_x), R.raw.agent_harbor_x)
        }
    }

    private fun setAbilityVideo(textName: String, textAbility: String, videoResource: Int) {
        binding.txtNameAbilityHarbor.text = textName
        binding.txtAbilityHarbor.text = textAbility
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + videoResource)

        binding.videoHarborAbilities.setVideoURI(uri)
        binding.videoHarborAbilities.start()

        binding.videoHarborAbilities.setOnPreparedListener(OnPreparedListener { mp ->
            mp.isLooping = true
        })
    }

    override fun onResume() {
        binding.videoHarborAbilities.resume()
        super.onResume()
    }

    override fun onPause() {
        binding.videoHarborAbilities.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoHarborAbilities.stopPlayback()
        super.onDestroy()
    }
}