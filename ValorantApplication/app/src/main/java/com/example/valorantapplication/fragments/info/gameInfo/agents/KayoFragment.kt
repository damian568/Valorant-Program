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
import com.example.valorantapplication.databinding.FragmentKayoBinding

class KayoFragment : Fragment() {

    private lateinit var binding: FragmentKayoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKayoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAbilityImages()
        clickAbility()
    }

    private fun setAbilityImages(){
        val uriQ = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt83e92ae578e66b8e/60d204231e0505677a882f38/Q_FlashDrive.png")
        val uriE = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt496288e7ab899b47/60d2018db930a53616fa4882/E_ZeroPoint.png")
        val uriC = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blte671cefaedb07d26/60d2046483f9fe49a6fef713/C_FragMent.png")
        val uriX = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltead1f4cb9ad32e19/60d20208bcec595109d831c2/X_NullCmd.png")
        Glide.with(this)
            .load(uriQ)
            .into(binding.abilityQKayo)
        Glide.with(this)
            .load(uriE)
            .into(binding.abilityEKayo)
        Glide.with(this)
            .load(uriC)
            .into(binding.abilityCKayo)
        Glide.with(this)
            .load(uriX)
            .into(binding.abilityXKayo)
    }

    private fun clickAbility(){
        binding.abilityQKayo.setOnClickListener {
            setAbilityVideo("Q - FLASH/DRIVE", getString(R.string.kayo_ability_q), R.raw.agent_kayo_q)
        }
        binding.abilityEKayo.setOnClickListener {
            setAbilityVideo("E - ZERO/POINT", getString(R.string.kayo_ability_e), R.raw.agent_kayo_e)
        }
        binding.abilityCKayo.setOnClickListener {
            setAbilityVideo("C - FRAG/MENT", getString(R.string.kayo_ability_c), R.raw.agent_kayo_c)
        }
        binding.abilityXKayo.setOnClickListener {
            setAbilityVideo("X - NULL/CMD", getString(R.string.kayo_ability_x), R.raw.agent_kayo_x)
        }
    }

    private fun setAbilityVideo(textName: String, textAbility: String, videoResource: Int) {
        binding.txtNameAbilityKayo.text = textName
        binding.txtAbilityKayo.text = textAbility
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + videoResource)

        binding.videoKayoAbilities.setVideoURI(uri)
        binding.videoKayoAbilities.start()

        binding.videoKayoAbilities.setOnPreparedListener(OnPreparedListener { mp ->
            mp.isLooping = true
        })
    }

    override fun onResume() {
        binding.videoKayoAbilities.resume()
        super.onResume()
    }

    override fun onPause() {
        binding.videoKayoAbilities.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoKayoAbilities.stopPlayback()
        super.onDestroy()
    }
}