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
import com.example.valorantapplication.databinding.FragmentChamberBinding

class ChamberFragment : Fragment() {

    private lateinit var binding: FragmentChamberBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChamberBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAbilityImages()
        clickAbility()
    }

    private fun setAbilityImages(){
        val uriQ = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt734ce749d24f1b4f/618d9ebad380f814d61f0020/Chamber_ability_Q.png")
        val uriE = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt273c7e9db39da271/618d9ec29dccbf6fa4178520/Chamber_ability_E.png")
        val uriC = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt4c14aadba51a0037/618d9ed03b08dd14d79a8087/Chamber_ability_C.png")
        val uriX = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt6856745815feee67/618d9eda3b08dd14d79a808b/Chamber_ability_X.png")
        Glide.with(this)
            .load(uriQ)
            .into(binding.abilityQChamber)
        Glide.with(this)
            .load(uriE)
            .into(binding.abilityEChamber)
        Glide.with(this)
            .load(uriC)
            .into(binding.abilityCChamber)
        Glide.with(this)
            .load(uriX)
            .into(binding.abilityXChamber)
    }

    private fun clickAbility(){
        binding.abilityQChamber.setOnClickListener {
            setAbilityVideo("Q - HEADHUNTER", getString(R.string.chamber_ability_q), R.raw.agent_chamber_q)
        }
        binding.abilityEChamber.setOnClickListener {
            setAbilityVideo("E - RENDEZVOUS", getString(R.string.chamber_ability_e), R.raw.agent_chamber_e)
        }
        binding.abilityCChamber.setOnClickListener {
            setAbilityVideo("C - TRADEMARK", getString(R.string.chamber_ability_c), R.raw.agent_chamber_c)
        }
        binding.abilityXChamber.setOnClickListener {
            setAbilityVideo("X - TOUR DE FORCE", getString(R.string.chamber_ability_x), R.raw.agent_chamber_x)
        }
    }

    private fun setAbilityVideo(textName: String, textAbility: String, videoResource: Int) {
        binding.txtNameAbilityChamber.text = textName
        binding.txtAbilityChamber.text = textAbility
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + videoResource)

        binding.videoChamberAbilities.setVideoURI(uri)
        binding.videoChamberAbilities.start()

        binding.videoChamberAbilities.setOnPreparedListener(OnPreparedListener { mp ->
            mp.isLooping = true
        })
    }

    override fun onResume() {
        binding.videoChamberAbilities.resume()
        super.onResume()
    }

    override fun onPause() {
        binding.videoChamberAbilities.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoChamberAbilities.stopPlayback()
        super.onDestroy()
    }
}