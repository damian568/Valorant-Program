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
import com.example.valorantapplication.databinding.FragmentKilljoyBinding

class KilljoyFragment : Fragment() {

    private lateinit var binding: FragmentKilljoyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKilljoyBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAbilityImages()
        clickAbility()
    }

    private fun setAbilityImages(){
        val uriQ = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt143467a7379d4211/5f21feb94d73a00a2e1428d3/Copy_of_TX_KJ_Alarm.png")
        val uriE = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt1a4926627b38cc1a/5f2201490e38240638cd81d2/Copy_of_tx_kj_turret.png")
        val uriC = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt4e53712407193852/5f22010d8ff50d070ad2d172/Copy_of_TX_KJ_Bees.png")
        val uriX = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt1e4113a934e67fa3/5f22018d71ec397ef9bf089e/Copy_of_TX_KJ_Lockdown.png")
        Glide.with(this)
            .load(uriQ)
            .into(binding.abilityQKill)
        Glide.with(this)
            .load(uriE)
            .into(binding.abilityEKill)
        Glide.with(this)
            .load(uriC)
            .into(binding.abilityCKill)
        Glide.with(this)
            .load(uriX)
            .into(binding.abilityXKill)
    }

    private fun clickAbility(){
        binding.abilityQKill.setOnClickListener {
            setAbilityVideo("Q - ALARMBOT", getString(R.string.killjoy_ability_q), R.raw.agent_kill_q)
        }
        binding.abilityEKill.setOnClickListener {
            setAbilityVideo("E - TURRET", getString(R.string.killjoy_ability_e), R.raw.agent_kill_e)
        }
        binding.abilityCKill.setOnClickListener {
            setAbilityVideo("C - NANOSWARM", getString(R.string.killjoy_ability_c), R.raw.agent_kill_c)
        }
        binding.abilityXKill.setOnClickListener {
            setAbilityVideo("X - LOCKDOWN", getString(R.string.killjoy_ability_x), R.raw.agent_kill_x)
        }
    }

    private fun setAbilityVideo(textName: String, textAbility: String, videoResource: Int) {
        binding.txtNameAbilityKill.text = textName
        binding.txtAbilityKill.text = textAbility
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + videoResource)

        binding.videoKillAbilities.setVideoURI(uri)
        binding.videoKillAbilities.start()

        binding.videoKillAbilities.setOnPreparedListener(OnPreparedListener { mp ->
            mp.isLooping = true
        })
    }

    override fun onResume() {
        binding.videoKillAbilities.resume()
        super.onResume()
    }

    override fun onPause() {
        binding.videoKillAbilities.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoKillAbilities.stopPlayback()
        super.onDestroy()
    }
}