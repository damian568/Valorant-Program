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
import com.example.valorantapplication.databinding.FragmentYoruBinding

class YoruFragment : Fragment() {

    private lateinit var binding: FragmentYoruBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentYoruBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAbilityImages()
        clickAbility()
    }

    private fun setAbilityImages(){
        val uriQ = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt54759b7874fbd40c/5ff5681bb47cdf7fc7d6c3e6/Yoru_Anility_Icons_512x512_Q.png")
        val uriE = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt5427236bf8a82b05/5ff5685e1166ce7d2ed1bd5d/yoru_ability_icons_52x512_E.png")
        val uriC = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt3ffa0e1858916cb8/622159a1c56d222d0cb0cc12/TX_Yoru_Fakeout.png")
        val uriX = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltceb6f71853fa7be7/5ff568b3396e65084a9e8c7c/Yoru_Anility_Icons_512x512_X.png")
        Glide.with(this)
            .load(uriQ)
            .into(binding.abilityQYoru)
        Glide.with(this)
            .load(uriE)
            .into(binding.abilityEYoru)
        Glide.with(this)
            .load(uriC)
            .into(binding.abilityCYoru)
        Glide.with(this)
            .load(uriX)
            .into(binding.abilityXYoru)
    }

    private fun clickAbility(){
        binding.abilityQYoru.setOnClickListener {
            setAbilityVideo("Q - BLINDSIDE", getString(R.string.yoru_ability_q), R.raw.agent_yoru_q)
        }
        binding.abilityEYoru.setOnClickListener {
            setAbilityVideo("E - GATECRASH", getString(R.string.yoru_ability_e), R.raw.agent_yoru_e)
        }
        binding.abilityCYoru.setOnClickListener {
            setAbilityVideo("C - FAKEOUT", getString(R.string.yoru_ability_c), R.raw.agent_yoru_c)
        }
        binding.abilityXYoru.setOnClickListener {
            setAbilityVideo("X - DIMENSIONAL DRIFT", getString(R.string.yoru_ability_x), R.raw.agent_yoru_x)
        }
    }

    private fun setAbilityVideo(textName: String, textAbility: String, videoResource: Int) {
        binding.txtNameAbilityYoru.text = textName
        binding.txtAbilityYoru.text = textAbility
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + videoResource)

        binding.videoYoruAbilities.setVideoURI(uri)
        binding.videoYoruAbilities.start()

        binding.videoYoruAbilities.setOnPreparedListener(OnPreparedListener { mp ->
            mp.isLooping = true
        })
    }

    override fun onResume() {
        binding.videoYoruAbilities.resume()
        super.onResume()
    }

    override fun onPause() {
        binding.videoYoruAbilities.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoYoruAbilities.stopPlayback()
        super.onDestroy()
    }
}