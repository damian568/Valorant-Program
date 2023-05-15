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
import com.example.valorantapplication.constants.Constants
import com.example.valorantapplication.databinding.FragmentGekkoBinding

class GekkoFragment : Fragment() {

    private lateinit var binding: FragmentGekkoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGekkoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAbilityImages()
        clickAbility()
    }

    private fun setAbilityImages(){
        val uriQ = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt84c8955357322ecd/64027318ec12cd34d0060449/Gekko_ability_Icon_Wingman_.png")
        val uriE = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt09558f0cb6be03a3/6402737a27ccd11087ac6a70/Gekko_ability_Icon_3.png")
        val uriC = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltb04bcc15680583e4/640273e5aa6c3f7f594bd1cf/Gekko_icon_mosh.png")
        val uriX = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltb24321feccb0cb69/6402740fba95fe6a2554b0b5/Gekko_ability_icon_4.png")
        Glide.with(this)
            .load(uriQ)
            .into(binding.abilityQGekko)
        Glide.with(this)
            .load(uriE)
            .into(binding.abilityEGekko)
        Glide.with(this)
            .load(uriC)
            .into(binding.abilityCGekko)
        Glide.with(this)
            .load(uriX)
            .into(binding.abilityXGekko)
    }

    private fun clickAbility(){
        binding.abilityQGekko.setOnClickListener {
            setAbilityVideo("Q - WINGMAN", getString(R.string.gekko_ability_q), R.raw.agent_gekko_q)
        }
        binding.abilityEGekko.setOnClickListener {
            setAbilityVideo("E - DIZZY", getString(R.string.gekko_ability_e), R.raw.agent_gekko_e)
        }
        binding.abilityCGekko.setOnClickListener {
            setAbilityVideo("C - MOSH PIT", getString(R.string.gekko_ability_c), R.raw.agent_gekko_c)
        }
        binding.abilityXGekko.setOnClickListener {
            setAbilityVideo("X - THRASH", getString(R.string.gekko_ability_x), R.raw.agent_gekko_x)
        }
    }

    private fun setAbilityVideo(textName: String, textAbility: String, videoResource: Int) {
        binding.txtNameAbilityGekko.text = textName
        binding.txtAbilityGekko.text = textAbility
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + videoResource)

        binding.videoGekkoAbilities.setVideoURI(uri)
        binding.videoGekkoAbilities.start()

        binding.videoGekkoAbilities.setOnPreparedListener(OnPreparedListener { mp ->
            mp.isLooping = true
        })
    }

    override fun onResume() {
        binding.videoGekkoAbilities.resume()
        super.onResume()
    }

    override fun onPause() {
        binding.videoGekkoAbilities.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoGekkoAbilities.stopPlayback()
        super.onDestroy()
    }
}